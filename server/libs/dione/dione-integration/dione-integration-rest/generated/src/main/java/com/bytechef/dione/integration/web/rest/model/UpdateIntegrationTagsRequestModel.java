package com.bytechef.dione.integration.web.rest.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * The request object that contains the array of tags.
 */

@Schema(name = "updateIntegrationTags_request", description = "The request object that contains the array of tags.")
@JsonTypeName("updateIntegrationTags_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-04T17:08:22.844227+01:00[Europe/Zagreb]")
public class UpdateIntegrationTagsRequestModel {

  @JsonProperty("tags")
  @Valid
  private List<com.bytechef.tag.web.rest.model.TagModel> tags = null;

  public UpdateIntegrationTagsRequestModel tags(List<com.bytechef.tag.web.rest.model.TagModel> tags) {
    this.tags = tags;
    return this;
  }

  public UpdateIntegrationTagsRequestModel addTagsItem(com.bytechef.tag.web.rest.model.TagModel tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tagsItem);
    return this;
  }

  /**
   * Get tags
   * @return tags
  */
  @Valid 
  @Schema(name = "tags", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<com.bytechef.tag.web.rest.model.TagModel> getTags() {
    return tags;
  }

  public void setTags(List<com.bytechef.tag.web.rest.model.TagModel> tags) {
    this.tags = tags;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateIntegrationTagsRequestModel updateIntegrationTagsRequest = (UpdateIntegrationTagsRequestModel) o;
    return Objects.equals(this.tags, updateIntegrationTagsRequest.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateIntegrationTagsRequestModel {\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

