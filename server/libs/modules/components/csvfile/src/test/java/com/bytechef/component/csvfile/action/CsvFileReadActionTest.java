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

package com.bytechef.component.csvfile.action;

import static com.bytechef.component.csvfile.constant.CsvFileConstants.DELIMITER;
import static com.bytechef.component.csvfile.constant.CsvFileConstants.FILE_ENTRY;
import static com.bytechef.component.csvfile.constant.CsvFileConstants.HEADER_ROW;
import static com.bytechef.component.csvfile.constant.CsvFileConstants.INCLUDE_EMPTY_CELLS;
import static com.bytechef.component.csvfile.constant.CsvFileConstants.PAGE_NUMBER;
import static com.bytechef.component.csvfile.constant.CsvFileConstants.PAGE_SIZE;
import static com.bytechef.component.csvfile.constant.CsvFileConstants.READ_AS_STRING;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

import com.bytechef.component.csvfile.CsvFileComponentHandlerTest;
import com.bytechef.hermes.component.definition.ActionContext;
import com.bytechef.hermes.component.definition.ParameterMap;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * @author Ivica Cardic
 */
@Disabled
public class CsvFileReadActionTest {

    private static final ActionContext context = Mockito.mock(ActionContext.class);

    @Test
    public void testPerformReadCSV() throws Exception {
        // headerRow: true, includeEmptyCells: false, readAsString: false

        ParameterMap parameterMap = Mockito.mock(ParameterMap.class);

        assertEquals(
            new JSONArray(getJSONObjectsWithNamedColumns(false, false)),
            new JSONArray(CsvFileReadAction.perform(
                getReadParameters(true, false, null, null, false, getFile("sample_header.csv"), parameterMap),
                parameterMap, context)),
            true);

        // headerRow: true, includeEmptyCells: true, readAsString: false

        assertEquals(
            new JSONArray(getJSONObjectsWithNamedColumns(true, false)),
            new JSONArray(CsvFileReadAction.perform(
                getReadParameters(true, true, null, null, false, getFile("sample_header.csv"), parameterMap),
                parameterMap, context)),
            true);

        // headerRow: true, includeEmptyCells: false, readAsString: true

        assertEquals(
            new JSONArray(getJSONObjectsWithNamedColumns(false, true)),
            new JSONArray(CsvFileReadAction.perform(
                getReadParameters(true, false, null, null, true, getFile("sample_header.csv"), parameterMap),
                parameterMap, context)),
            true);

        // headerRow: true, includeEmptyCells: true, readAsString: true

        assertEquals(
            new JSONArray(getJSONObjectsWithNamedColumns(true, true)),
            new JSONArray(CsvFileReadAction.perform(
                getReadParameters(true, true, null, null, true, getFile("sample_header.csv"), parameterMap),
                parameterMap, context)),
            true);

        // headerRow: false, includeEmptyCells: false, readAsString: false

        assertEquals(
            new JSONArray(getJSONArrayWithoutNamedColumns(false, false)),
            new JSONArray(CsvFileReadAction.perform(
                getReadParameters(false, false, null, null, false, getFile("sample_no_header.csv"), parameterMap),
                parameterMap, context)),
            true);

        // headerRow: false, includeEmptyCells: false, readAsString: true

        assertEquals(
            new JSONArray(getJSONArrayWithoutNamedColumns(false, true)),
            new JSONArray(CsvFileReadAction.perform(
                getReadParameters(false, false, null, null, true, getFile("sample_no_header.csv"), parameterMap),
                parameterMap, context)),
            true);

        // headerRow: false, includeEmptyCells: true, readAsString: false

        assertEquals(
            new JSONArray(getJSONArrayWithoutNamedColumns(true, false)),
            new JSONArray(CsvFileReadAction.perform(
                getReadParameters(false, true, null, null, false, getFile("sample_no_header.csv"), parameterMap),
                parameterMap, context)),
            true);

        // headerRow: false, includeEmptyCells: true, readAsString: true

        assertEquals(
            new JSONArray(getJSONArrayWithoutNamedColumns(true, true)),
            new JSONArray(CsvFileReadAction.perform(
                getReadParameters(false, true, null, null, true, getFile("sample_no_header.csv"), parameterMap),
                parameterMap, context)),
            true);

        // paging

        assertEquals(
            new JSONArray(getJSONObjectsWithNamedColumns(false, false).subList(0, 3)),
            new JSONArray(CsvFileReadAction.perform(
                getReadParameters(true, false, 1, 3, false, getFile("sample_header.csv"), parameterMap),
                parameterMap, context)),
            true);
    }

    @SuppressWarnings("PMD.SimplifiedTernary")
    private List<JSONObject> getJSONObjectsWithNamedColumns(boolean includeEmptyCells, boolean readAsString)
        throws JSONException {
        return List.of(
            getJSONObjectWithNamedColumns(
                readAsString ? "77" : 77,
                "A",
                "B",
                "C",
                readAsString ? "true" : true,
                "2021-12-07",
                readAsString ? "11.2" : 11.2),
            getJSONObjectWithNamedColumns(
                readAsString ? "4" : 4,
                "name1",
                "city1",
                "description1",
                readAsString ? "false" : false,
                includeEmptyCells ? "" : null,
                readAsString ? "12" : 12),
            getJSONObjectWithNamedColumns(
                readAsString ? "2" : 2,
                "A",
                "city2",
                includeEmptyCells ? "" : null,
                readAsString ? "true" : true,
                "2021-12-09",
                includeEmptyCells ? "" : null),
            getJSONObjectWithNamedColumns(
                readAsString ? "5678" : 5678,
                "ABCD",
                "city3",
                "EFGH",
                readAsString ? "false" : false,
                "2021-12-10",
                readAsString ? "13.23" : 13.23));
    }

    @SuppressWarnings("PMD.SimplifiedTernary")
    private List<JSONObject> getJSONArrayWithoutNamedColumns(boolean includeEmptyCells, boolean readAsString)
        throws JSONException {
        return List.of(
            getJSONObjectWithoutNamedColumns(
                readAsString ? "77" : 77,
                "A",
                "B",
                "C",
                readAsString ? "true" : true,
                "2021-12-07",
                readAsString ? "11.2" : 11.2),
            getJSONObjectWithoutNamedColumns(
                readAsString ? "4" : 4,
                "name1",
                "city1",
                "description1",
                readAsString ? "false" : false,
                includeEmptyCells ? "" : null,
                readAsString ? "12" : 12),
            getJSONObjectWithoutNamedColumns(
                readAsString ? "2" : 2,
                "A",
                "city2",
                includeEmptyCells ? "" : null,
                readAsString ? "true" : true,
                "2021-12-09",
                includeEmptyCells ? "" : null),
            getJSONObjectWithoutNamedColumns(
                readAsString ? "5678" : 5678,
                "ABCD",
                "city3",
                "EFGH",
                readAsString ? "false" : false,
                "2021-12-10",
                readAsString ? "13.23" : 13.23));
    }

    private JSONObject getJSONObjectWithNamedColumns(
        Object id, String name, String city, String description, Object active, String date, Object sum)
        throws JSONException {
        return getJSONObject(
            "id",
            id,
            "name",
            name,
            "city",
            city,
            "description",
            description,
            "active",
            active,
            "date",
            date,
            "sum",
            sum);
    }

    private JSONObject getJSONObjectWithoutNamedColumns(
        Object id, String name, String city, String description, Object active, String date, Object sum)
        throws JSONException {
        return getJSONObject(
            "column_1",
            id,
            "column_2",
            name,
            "column_3",
            city,
            "column_4",
            description,
            "column_5",
            active,
            "column_6",
            date,
            "column_7",
            sum);
    }

    private JSONObject getJSONObject(
        String idKey, Object idValue, String nameKey, String nameValue, String cityKey, String cityValue,
        String descriptionKey, String descriptionValue, String activeKey, Object activeValue, String dateKey,
        Object dateValue, String sumKey, Object sumValue)
        throws JSONException {
        JSONObject jsonObject = new JSONObject()
            .put(idKey, idValue)
            .put(nameKey, nameValue)
            .put(cityKey, cityValue)
            .put(activeKey, activeValue)
            .put(dateKey, dateValue)
            .put(sumKey, sumValue);

        if (descriptionValue != null) {
            jsonObject.put(descriptionKey, descriptionValue);
        }

        return jsonObject;
    }

    @SuppressFBWarnings("OBL")
    private ParameterMap getReadParameters(
        boolean headerRow, boolean includeEmptyCells, Integer pageNumber, Integer pageSize, boolean readAsString,
        File file, ParameterMap parameterMap)
        throws FileNotFoundException {

        Mockito.when(parameterMap.getString(Mockito.eq(DELIMITER), Mockito.eq(",")))
            .thenReturn(",");
        Mockito.when(parameterMap.getRequiredFileEntry(Mockito.eq(FILE_ENTRY)))
            .thenReturn(Mockito.mock(ActionContext.FileEntry.class));
        Mockito.when(parameterMap.getBoolean(Mockito.eq(HEADER_ROW), Mockito.eq(true)))
            .thenReturn(headerRow);
        Mockito.when(parameterMap.getBoolean(Mockito.eq(INCLUDE_EMPTY_CELLS), Mockito.eq(false)))
            .thenReturn(includeEmptyCells);
        Mockito.when(parameterMap.getInteger(Mockito.eq(PAGE_NUMBER)))
            .thenReturn(pageNumber);
        Mockito.when(parameterMap.getInteger(Mockito.eq(PAGE_SIZE)))
            .thenReturn(pageSize);
        Mockito.when(parameterMap.getBoolean(Mockito.eq(READ_AS_STRING), Mockito.eq(false)))
            .thenReturn(readAsString);

        if (file != null) {
            Mockito.when(context.file(file1 -> file1.getStream(Mockito.any(ActionContext.FileEntry.class))))
                .thenReturn(new FileInputStream(file));
        }

        return parameterMap;
    }

    private File getFile(String fileName) {
        return new File(CsvFileComponentHandlerTest.class
            .getClassLoader()
            .getResource("dependencies/" + fileName)
            .getFile());
    }
}
