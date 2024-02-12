/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytechef.automation.workflow.execution.web.rest;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.bytechef.automation.workflow.execution.web.rest.model.WorkflowExecutionModel;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-12T06:58:10.229509+01:00[Europe/Zagreb]")
@Validated
@Tag(name = "workflow-execution", description = "The Automation Workflow Execution API")
public interface WorkflowExecutionApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /workflow-executions/{id} : Get workflow executions by id
     * Get workflow execution by id.
     *
     * @param id The id of an execution. (required)
     * @return The execution object. (status code 200)
     */
    @Operation(
        operationId = "getWorkflowExecution",
        summary = "Get workflow executions by id",
        description = "Get workflow execution by id.",
        tags = { "workflow-execution" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The execution object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = WorkflowExecutionModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/workflow-executions/{id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<WorkflowExecutionModel> getWorkflowExecution(
        @Parameter(name = "id", description = "The id of an execution.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"triggerExecution\" : { \"retryDelayFactor\" : 9, \"endDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"batch\" : true, \"error\" : { \"stackTrace\" : [ \"stackTrace\", \"stackTrace\" ], \"message\" : \"message\" }, \"priority\" : 5, \"type\" : \"type\", \"executionTime\" : 1, \"output\" : \"{}\", \"retryDelay\" : \"retryDelay\", \"input\" : { \"key\" : \"\" }, \"retryDelayMillis\" : 6, \"component\" : { \"icon\" : \"icon\", \"name\" : \"name\", \"actionsCount\" : 6, \"description\" : \"description\", \"title\" : \"title\", \"triggersCount\" : 7 }, \"maxRetries\" : 4, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"workflowTrigger\" : { \"name\" : \"name\", \"label\" : \"label\", \"type\" : \"type\", \"parameters\" : { \"key\" : \"{}\" }, \"connections\" : [ { \"workflowNodeName\" : \"workflowNodeName\", \"componentName\" : \"componentName\", \"componentVersion\" : 8, \"id\" : 9, \"key\" : \"key\", \"required\" : true }, { \"workflowNodeName\" : \"workflowNodeName\", \"componentName\" : \"componentName\", \"componentVersion\" : 8, \"id\" : 9, \"key\" : \"key\", \"required\" : true } ], \"timeout\" : \"timeout\" }, \"id\" : \"id\", \"retryAttempts\" : 9, \"startDate\" : \"2000-01-23T04:56:07.000+00:00\", \"status\" : \"CREATED\" }, \"workflow\" : { \"__version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"description\" : \"description\", \"id\" : \"id\", \"label\" : \"label\" }, \"project\" : { \"workflowIds\" : [ \"workflowIds\", \"workflowIds\" ], \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"description\" : \"description\", \"tags\" : [ { \"__version\" : 7, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 2 }, { \"__version\" : 7, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 2 } ], \"__version\" : 9, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"name\" : \"name\", \"id\" : 5, \"publishedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"category\" : { \"__version\" : 1, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 6 }, \"projectVersion\" : 5, \"status\" : \"PUBLISHED\" }, \"id\" : 0, \"projectInstance\" : { \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"description\" : \"description\", \"enabled\" : true, \"tags\" : [ { \"__version\" : 7, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 2 }, { \"__version\" : 7, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 2 } ], \"__version\" : 1, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"projectInstanceWorkflows\" : [ { \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"inputs\" : { \"key\" : \"{}\" }, \"lastModifiedBy\" : \"lastModifiedBy\", \"enabled\" : true, \"projectInstanceId\" : 1, \"__version\" : 1, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"staticWebhookUrl\" : \"staticWebhookUrl\", \"id\" : 7, \"lastExecutionDate\" : \"2000-01-23T04:56:07.000+00:00\", \"connections\" : [ { \"workflowNodeName\" : \"workflowNodeName\", \"connectionId\" : 4, \"key\" : \"key\" }, { \"workflowNodeName\" : \"workflowNodeName\", \"connectionId\" : 4, \"key\" : \"key\" } ], \"workflowId\" : \"workflowId\" }, { \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"inputs\" : { \"key\" : \"{}\" }, \"lastModifiedBy\" : \"lastModifiedBy\", \"enabled\" : true, \"projectInstanceId\" : 1, \"__version\" : 1, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"staticWebhookUrl\" : \"staticWebhookUrl\", \"id\" : 7, \"lastExecutionDate\" : \"2000-01-23T04:56:07.000+00:00\", \"connections\" : [ { \"workflowNodeName\" : \"workflowNodeName\", \"connectionId\" : 4, \"key\" : \"key\" }, { \"workflowNodeName\" : \"workflowNodeName\", \"connectionId\" : 4, \"key\" : \"key\" } ], \"workflowId\" : \"workflowId\" } ], \"createdBy\" : \"createdBy\", \"name\" : \"name\", \"id\" : 3, \"lastExecutionDate\" : \"2000-01-23T04:56:07.000+00:00\", \"projectId\" : 2 } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /workflow-executions : Get project workflow executions
     * Get project workflow executions.
     *
     * @param jobStatus The status of an executed job (optional)
     * @param jobStartDate The start date of a job. (optional)
     * @param jobEndDate The end date of a job. (optional)
     * @param projectId The id of a project. (optional)
     * @param projectInstanceId The id of a project instance. (optional)
     * @param workflowId The id of a workflow. (optional)
     * @param pageNumber The number of the page to return. (optional, default to 0)
     * @return The page of workflow executions. (status code 200)
     */
    @Operation(
        operationId = "getWorkflowExecutionsPage",
        summary = "Get project workflow executions",
        description = "Get project workflow executions.",
        tags = { "workflow-execution" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The page of workflow executions.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = org.springframework.data.domain.Page.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/workflow-executions",
        produces = { "application/json" }
    )
    
    default ResponseEntity<org.springframework.data.domain.Page> getWorkflowExecutionsPage(
        @Parameter(name = "jobStatus", description = "The status of an executed job", in = ParameterIn.QUERY) @Valid @RequestParam(value = "jobStatus", required = false) String jobStatus,
        @Parameter(name = "jobStartDate", description = "The start date of a job.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "jobStartDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime jobStartDate,
        @Parameter(name = "jobEndDate", description = "The end date of a job.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "jobEndDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime jobEndDate,
        @Parameter(name = "projectId", description = "The id of a project.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "projectId", required = false) Long projectId,
        @Parameter(name = "projectInstanceId", description = "The id of a project instance.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "projectInstanceId", required = false) Long projectInstanceId,
        @Parameter(name = "workflowId", description = "The id of a workflow.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "workflowId", required = false) String workflowId,
        @Parameter(name = "pageNumber", description = "The number of the page to return.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"number\" : 0, \"size\" : 6, \"numberOfElements\" : 1, \"totalPages\" : 5, \"content\" : [ \"{}\", \"{}\" ], \"totalElements\" : 5 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
