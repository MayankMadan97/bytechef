
/*
 * Copyright 2021 <your company/name>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytechef.component.httpclient.connection;

import com.bytechef.hermes.component.definition.Authorization;
import com.bytechef.hermes.component.definition.ConnectionDefinition;
import com.bytechef.hermes.definition.Property;

import static com.bytechef.hermes.component.definition.Authorization.ADD_TO;
import static com.bytechef.hermes.component.definition.Authorization.AUTHORIZATION_URL;
import static com.bytechef.hermes.component.definition.ConnectionDefinition.BASE_URI;
import static com.bytechef.hermes.component.definition.Authorization.CLIENT_ID;
import static com.bytechef.hermes.component.definition.Authorization.CLIENT_SECRET;
import static com.bytechef.hermes.component.definition.Authorization.KEY;
import static com.bytechef.hermes.component.definition.Authorization.PASSWORD;
import static com.bytechef.hermes.component.definition.Authorization.SCOPES;
import static com.bytechef.hermes.component.definition.Authorization.TOKEN;
import static com.bytechef.hermes.component.definition.Authorization.TOKEN_URL;
import static com.bytechef.hermes.component.definition.Authorization.USERNAME;
import static com.bytechef.hermes.component.definition.Authorization.VALUE;
import static com.bytechef.hermes.component.definition.ComponentDSL.authorization;
import static com.bytechef.hermes.component.definition.ComponentDSL.connection;
import static com.bytechef.hermes.definition.DefinitionDSL.display;
import static com.bytechef.hermes.definition.DefinitionDSL.option;
import static com.bytechef.hermes.definition.DefinitionDSL.string;

public class HttpClientConnection {

    public static final ConnectionDefinition CONNECTION_DEFINITION = connection()
        .properties(string(BASE_URI).label("Base URI"))
        .authorizationRequired(false)
        .authorizations(
            authorization(Authorization.AuthorizationType.API_KEY.name()
                .toLowerCase(), Authorization.AuthorizationType.API_KEY)
                .display(display("API Key"))
                .properties(
                    string(KEY)
                        .label("Key")
                        .required(true)
                        .defaultValue(Authorization.API_TOKEN),
                    string(VALUE).label("Value")
                        .required(true),
                    string(ADD_TO)
                        .label("Add to")
                        .required(true)
                        .options(
                            option(
                                "Header", Authorization.ApiTokenLocation.HEADER.name()),
                            option(
                                "QueryParams",
                                Authorization.ApiTokenLocation.QUERY_PARAMETERS.name()))),
            authorization(
                Authorization.AuthorizationType.BEARER_TOKEN
                    .name()
                    .toLowerCase(),
                Authorization.AuthorizationType.BEARER_TOKEN)
                .display(display("Bearer Token"))
                .properties(string(TOKEN).label("Token")
                    .required(true)),
            authorization(
                Authorization.AuthorizationType.BASIC_AUTH.name()
                    .toLowerCase(),
                Authorization.AuthorizationType.BASIC_AUTH)
                .display(display("Basic Auth"))
                .properties(
                    string(USERNAME).label("Username")
                        .required(true),
                    string(PASSWORD).label("Password")
                        .required(true)),
            authorization(
                Authorization.AuthorizationType.DIGEST_AUTH.name()
                    .toLowerCase(),
                Authorization.AuthorizationType.DIGEST_AUTH)
                .display(display("Digest Auth"))
                .properties(
                    string(USERNAME).label("Username")
                        .required(true),
                    string(PASSWORD).label("Password")
                        .required(true)),
            authorization(
                Authorization.AuthorizationType.OAUTH2_AUTHORIZATION_CODE
                    .name()
                    .toLowerCase(),
                Authorization.AuthorizationType.OAUTH2_AUTHORIZATION_CODE)
                .display(display("OAuth2 Authorization Code"))
                .properties(
                    string(AUTHORIZATION_URL)
                        .label("Authorization URL")
                        .required(true),
                    string(TOKEN_URL).label("Token URL")
                        .required(true),
                    string(CLIENT_ID).label("Client Id")
                        .required(true),
                    string(CLIENT_SECRET)
                        .label("Client Secret")
                        .required(true),
                    string(SCOPES)
                        .label("Scopes")
                        .description("Optional comma-delimited list of scopes")
                        .controlType(Property.ControlType.TEXT_AREA)),
            authorization(
                Authorization.AuthorizationType.OAUTH2_IMPLICIT_CODE
                    .name()
                    .toLowerCase(),
                Authorization.AuthorizationType.OAUTH2_IMPLICIT_CODE)
                .display(display("OAuth2 Implicit Code"))
                .properties(
                    string(AUTHORIZATION_URL)
                        .label("Authorization URL")
                        .required(true),
                    string(CLIENT_ID).label("Client Id")
                        .required(true),
                    string(CLIENT_SECRET)
                        .label("Client Secret")
                        .required(true),
                    string(SCOPES)
                        .label("Scopes")
                        .description("Optional comma-delimited list of scopes")
                        .controlType(Property.ControlType.TEXT_AREA)),
            authorization(
                Authorization.AuthorizationType.OAUTH2_CLIENT_CREDENTIALS
                    .name()
                    .toLowerCase(),
                Authorization.AuthorizationType.OAUTH2_CLIENT_CREDENTIALS)
                .display(display("OAuth2 Client Credentials"))
                .properties(
                    string(TOKEN_URL).label("Token URL")
                        .required(true),
                    string(CLIENT_ID).label("Client Id")
                        .required(true),
                    string(CLIENT_SECRET)
                        .label("Client Secret")
                        .required(true),
                    string(SCOPES)
                        .label("Scopes")
                        .description("Optional comma-delimited list of scopes")
                        .controlType(Property.ControlType.TEXT_AREA)));
}
