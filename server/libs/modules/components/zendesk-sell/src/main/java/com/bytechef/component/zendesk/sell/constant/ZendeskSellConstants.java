/*
 * Copyright 2023-present ByteChef Inc.
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

package com.bytechef.component.zendesk.sell.constant;

import static com.bytechef.component.definition.ComponentDSL.string;

import com.bytechef.component.definition.ComponentDSL.ModifiableStringProperty;

/**
 * @author Monika Domiter
 */
public class ZendeskSellConstants {

    public static final String BASE_URL = "https://api.getbase.com/v2";
    public static final String CONTENT = "content";
    public static final String CREATE_CONTACT = "createContact";
    public static final String CREATE_TASK = "createTask";
    public static final String DATA = "data";
    public static final String DUE_DATE = "due_date";
    public static final String EMAIL = "email";
    public static final String FIRST_NAME = "first_name";
    public static final String IS_ORGANIZATION = "is_organization";
    public static final String LAST_NAME = "last_name";
    public static final String NAME = "name";
    public static final String NAME_PROPERTY = "nameProperty";
    public static final String TITLE = "title";
    public static final String WEBSITE = "website";
    public static final String ZENDESK_SELL = "zendeskSell";

    public static final ModifiableStringProperty FIRST_NAME_PROPERTY = string(FIRST_NAME)
        .label("First name")
        .description("The first name of the person.")
        .required(false);

    public static final ModifiableStringProperty LAST_NAME_PROPERTY = string(LAST_NAME)
        .label("Last name")
        .description("The last name of the person.")
        .required(true);

    public static final ModifiableStringProperty ORGANIZATION_NAME_PROPERTY = string(NAME)
        .label("Name")
        .description("The name of the organisation.")
        .required(false);

    private ZendeskSellConstants() {
    }
}
