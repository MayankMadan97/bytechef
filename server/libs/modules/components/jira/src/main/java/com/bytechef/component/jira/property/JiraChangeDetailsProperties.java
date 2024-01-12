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

package com.bytechef.component.jira.property;

import static com.bytechef.component.definition.ComponentDSL.string;

import com.bytechef.component.definition.ComponentDSL;
import java.util.List;

/**
 * Provides properties definition built from OpenAPI schema.
 *
 * @generated
 */
public class JiraChangeDetailsProperties {
    public static final List<ComponentDSL.ModifiableValueProperty<?, ?>> PROPERTIES = List.of(
        string("field").label("Field")
            .description("The name of the field changed.")
            .required(false),
        string("fieldtype").label("Fieldtype")
            .description("The type of the field changed.")
            .required(false),
        string("fieldId").label("Field Id")
            .description("The ID of the field changed.")
            .required(false),
        string("from").label("From")
            .description("The details of the original value.")
            .required(false),
        string("fromString").label("From String")
            .description("The details of the original value as a string.")
            .required(false),
        string("to").label("To")
            .description("The details of the new value.")
            .required(false),
        string("toString").label("To String")
            .description("The details of the new value as a string.")
            .required(false));
}
