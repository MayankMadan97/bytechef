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

package com.bytechef.component.google.drive.action;

import static com.bytechef.component.google.drive.constant.GoogleDriveConstants.FILE_ID;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.bytechef.component.definition.Parameters;
import com.google.api.services.drive.Drive;

public class GoogleMailDeleteFileActionTest extends AbstractGoogleDriveActionTest {

    @Test
    public void testPerform() throws IOException {

        String fileId = "testFileId";
        Parameters inputParameters = mock(Parameters.class);
        Parameters connectionParameters = mock(Parameters.class);

        // Mock input parameters to return the required file ID
        when(inputParameters.getRequiredString(FILE_ID)).thenReturn(fileId);

        // Mock Drive.Files.Delete and its behavior
        Drive.Files.Delete mockedDelete = mock(Drive.Files.Delete.class);
        when(mockedFiles.delete(fileId)).thenReturn(mockedDelete);

        // Since execute() returns void, we use doNothing() to mock its behavior
        doNothing().when(mockedDelete).execute();

        // Act
        GoogleDriveDeleteFileAction.perform(inputParameters, connectionParameters, mockedContext);

        // Assert
        verify(mockedFiles).delete(fileId); // Verify the delete method was called with the correct file ID
        verify(mockedDelete).execute();

    }

    @Test
    public void testPerform_ThrowsIOException() throws IOException {
        // Arrange
        String fileId = "testFileId";
        Parameters inputParameters = mock(Parameters.class);
        Parameters connectionParameters = mock(Parameters.class);

        when(inputParameters.getRequiredString(FILE_ID)).thenReturn(fileId);

        Drive.Files.Delete mockedDelete = mock(Drive.Files.Delete.class);
        when(mockedFiles.delete(fileId)).thenReturn(mockedDelete);

        // Simulate exception on execute()
        doThrow(new IOException("Error deleting file")).when(mockedDelete).execute();

        // Act and Assert
        assertThrows(IOException.class, () -> {
            GoogleDriveDeleteFileAction.perform(inputParameters, connectionParameters, mockedContext);
        });
    }
}