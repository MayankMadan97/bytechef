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

package com.bytechef.component.var.action;

import static com.bytechef.component.definition.ComponentDSL.action;
import static com.bytechef.component.definition.ComponentDSL.array;
import static com.bytechef.component.var.constant.VarConstants.SET_ARRAY;
import static com.bytechef.component.var.constant.VarConstants.VALUE;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.ComponentDSL.ModifiableActionDefinition;
import com.bytechef.component.definition.Parameters;

/**
 * @author Ivica Cardic
 */
public class VarSetArrayAction {

    public static final ModifiableActionDefinition ACTION_DEFINITION = action(SET_ARRAY)
        .title("Set array value")
        .description("Assign value to a variable that can be used in the following steps.")
        .properties(
            array(VALUE)
                .label("Value")
                .description("Value of array type to set.")
                .required(true))
        .output()
        .perform(VarSetArrayAction::perform);

    protected static Object perform(
        Parameters inputParameters, Parameters connectionParameters, ActionContext context) {

        return inputParameters.getRequired(VALUE);
    }
}
