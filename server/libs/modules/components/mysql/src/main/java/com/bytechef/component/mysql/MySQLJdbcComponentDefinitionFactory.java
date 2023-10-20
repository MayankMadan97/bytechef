
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

package com.bytechef.component.mysql;

import static com.bytechef.component.mysql.constant.MySQLConstants.MYSQL;

import static com.bytechef.hermes.component.definition.ComponentDSL.jdbcComponent;

import com.bytechef.hermes.component.JdbcComponentDefinitionFactory;
import com.bytechef.hermes.component.definition.JdbcComponentDefinition;
import com.google.auto.service.AutoService;

/**
 * @author Ivica Cardic
 */
@AutoService(JdbcComponentDefinitionFactory.class)
public class MySQLJdbcComponentDefinitionFactory implements JdbcComponentDefinitionFactory {

    private static final JdbcComponentDefinition COMPONENT_DEFINITION = jdbcComponent(MYSQL)
        .title("MySQL")
        .description("Query, insert nd update data from MySQL.")
        .icon("path:assets/mysql.svg")
        .databaseJdbcName("mysql")
        .jdbcDriverClassName("com.mysql.jdbc.Driver");

    @Override
    public JdbcComponentDefinition getJdbcComponentDefinition() {
        return COMPONENT_DEFINITION;
    }
}
