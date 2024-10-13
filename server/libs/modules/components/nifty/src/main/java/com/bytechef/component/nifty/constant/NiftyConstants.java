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

package com.bytechef.component.nifty.constant;

import static com.bytechef.component.definition.ComponentDsl.option;
import static com.bytechef.component.definition.ComponentDsl.string;

import com.bytechef.component.definition.ComponentDsl.ModifiableStringProperty;
import com.bytechef.component.definition.Option;
import com.bytechef.component.definition.OptionsDataSource.ActionOptionsFunction;
import com.bytechef.component.nifty.util.NiftyOptionUtils;
import java.util.List;

/**
 * @author Luka Ljubić
 */
public class NiftyConstants {

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PROJECT = "project";
    public static final String DESCRIPTION = "description";
    public static final String TEMPLATE_TYPE = "template_type";
    public static final String ACCESS_TYPE = "access_type";

    public static final List<Option<String>> ACCESS_TYPES = List.of(option("Public", "public"),
        option("Limited", "limited"));
    public static final List<Option<String>> PROJECT_TYPES = List.of(option("Simple", "simple"),
        option("Kanban", "kanban"), option("Scrum", "scrum"), option("Custom", "custom"));

    public static final ModifiableStringProperty PROJECT_PROPERTY = string(PROJECT)
        .label("Project")
        .description("Project within which the task will be created.")
        .options((ActionOptionsFunction<String>) NiftyOptionUtils::getProjectIdOptions)
        .required(true);

    private NiftyConstants() {
    }
}
