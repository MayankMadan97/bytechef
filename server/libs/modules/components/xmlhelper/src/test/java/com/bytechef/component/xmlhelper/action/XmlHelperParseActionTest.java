
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

package com.bytechef.component.xmlhelper.action;

import com.bytechef.hermes.component.Context;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;

import static com.bytechef.component.xmlhelper.constant.XmlHelperConstants.SOURCE;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Ivica Cardic
 */
public class XmlHelperParseActionTest {

    @Test
    public void testExecuteParse() {
        Map<String, ?> inputParameters = Map.of(
            SOURCE,
            """
                <Flower id="45">
                    <name>Poppy</name>
                </Flower>
                """);

        assertThat((Map<String, ?>) XmlHelperParseAction.executeParse(Mockito.mock(Context.class), inputParameters))
            .isEqualTo(Map.of("id", "45", "name", "Poppy"));

        inputParameters = Map.of(
            SOURCE,
            """
                <Flowers>
                    <Flower id="45">
                        <name>Poppy</name>
                    </Flower>
                    <Flower id="50">
                        <name>Rose</name>
                    </Flower>
                </Flowers>
                """);

        assertThat(XmlHelperParseAction.executeParse(Mockito.mock(Context.class), inputParameters))
            .isEqualTo(
                Map.of("Flower", List.of(Map.of("id", "45", "name", "Poppy"), Map.of("id", "50", "name", "Rose"))));
    }
}
