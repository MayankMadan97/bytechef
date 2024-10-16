import {UserI} from '@/shared/models/user.model';
import {getCookie} from '@/shared/util/cookie-utils';

/* eslint-disable sort-keys */

import {create} from 'zustand';
import {devtools} from 'zustand/middleware';

export interface AuthenticationI {
    account: UserI | undefined;
    authenticated: boolean;
    loading: boolean;
    loginError: boolean;
    sessionHasBeenFetched: boolean;
    showLogin: boolean;

    clearAuthentication: () => void;
    getAccount: () => Promise<Response>;
    login: (email: string, password: string, rememberMe: boolean) => Promise<Response>;
    logout: () => void;
    reset: () => void;
}

const initialState = {
    account: undefined,
    authenticated: false,
    loading: false,
    loginError: false,
    sessionHasBeenFetched: false,
    showLogin: false,
};

const fetchAuthenticate = async (data: string): Promise<Response> => {
    return await fetch('/api/authentication', {
        body: data,
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
            'X-XSRF-TOKEN': getCookie('XSRF-TOKEN') || '',
        },
        method: 'POST',
    }).then((response) => response);
};

const fetchGetAccount = async (): Promise<Response> => {
    return await fetch('/api/account', {
        headers: {
            'X-XSRF-TOKEN': getCookie('XSRF-TOKEN') || '',
        },
        method: 'GET',
    }).then((response) => response);
};

const fetchLogout = async (): Promise<Response> => {
    return await fetch('/api/logout', {
        headers: {
            'X-XSRF-TOKEN': getCookie('XSRF-TOKEN') || '',
        },
        method: 'POST',
    }).then((response) => response);
};

export const useAuthenticationStore = create<AuthenticationI>()(
    devtools(
        (set, get) => ({
            account: undefined,
            authenticated: false,
            loading: false,
            loginError: false,
            sessionHasBeenFetched: false,
            showLogin: false,

            clearAuthentication: () => {
                set((state) => ({
                    ...state,
                    loading: false,
                    showLogin: true,
                    authenticated: false,
                }));
            },

            getAccount: async (): Promise<Response> => {
                if (get().loading) {
                    return Promise.resolve(new Response());
                }

                set((state) => ({
                    ...state,
                    loading: true,
                }));

                return fetchGetAccount().then((response) => {
                    if (response.status === 200) {
                        response.json().then((account) => {
                            set((state) => ({
                                ...state,
                                account,
                                authenticated: account.activated,
                                loading: false,
                                sessionHasBeenFetched: true,
                            }));
                        });
                    } else {
                        set((state) => ({
                            ...state,
                            loading: false,
                            isAuthenticated: false,
                            sessionHasBeenFetched: true,
                            showLogin: true,
                        }));
                    }

                    return response;
                });
            },

            login: async (email: string, password: string, rememberMe: boolean): Promise<Response> => {
                const data = `username=${encodeURIComponent(email)}&password=${encodeURIComponent(password)}&remember-me=${rememberMe}&submit=Login`;

                return fetchAuthenticate(data).then(async (response) => {
                    if (response.status === 200) {
                        set((state) => ({
                            ...state,
                            loginError: false,
                            loginSuccess: true,
                            showLogin: false,
                        }));

                        const {getAccount} = get();

                        getAccount();
                    } else {
                        set(() => ({
                            ...initialState,
                            loginError: true,
                            showLogin: true,
                        }));
                    }

                    return response;
                });
            },

            logout: async () => {
                const response = await fetchLogout();

                if (response.status === 200) {
                    set(() => ({
                        ...initialState,
                        showLogin: true,
                    }));
                }

                // const {getAccount} = get();

                // fetch new csrf token
                // getAccount();
            },

            reset: () => {
                set(() => ({
                    ...initialState,
                }));
            },
        }),
        {
            name: 'authentication',
        }
    )
);
