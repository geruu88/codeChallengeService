package com.coding.challenge.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Arrays;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ErrorDetails
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL) @lombok.Builder(toBuilder=true) @lombok.NoArgsConstructor @lombok.AllArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-26T10:51:52.430406600+02:00[Europe/Sofia]")
public class ErrorDetails implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("type")
  private JsonNullable<String> type = JsonNullable.undefined();

  @JsonProperty("title")
  private JsonNullable<String> title = JsonNullable.undefined();

  @JsonProperty("status")
  private JsonNullable<Integer> status = JsonNullable.undefined();

  @JsonProperty("detail")
  private JsonNullable<String> detail = JsonNullable.undefined();

  public ErrorDetails type(String type) {
    this.type = JsonNullable.of(type);
    return this;
  }

  /**
   * A URI reference that identifies the problem type.
   * @return type
  */
  
  @Schema(name = "type", description = "A URI reference that identifies the problem type.", required = false)
  public JsonNullable<String> getType() {
    return type;
  }

  public void setType(JsonNullable<String> type) {
    this.type = type;
  }

  public ErrorDetails title(String title) {
    this.title = JsonNullable.of(title);
    return this;
  }

  /**
   * Short, human-readable summary of the error type.
   * @return title
  */
  
  @Schema(name = "title", description = "Short, human-readable summary of the error type.", required = false)
  public JsonNullable<String> getTitle() {
    return title;
  }

  public void setTitle(JsonNullable<String> title) {
    this.title = title;
  }

  public ErrorDetails status(Integer status) {
    this.status = JsonNullable.of(status);
    return this;
  }

  /**
   * The HTTP status code
   * @return status
  */
  
  @Schema(name = "status", description = "The HTTP status code", required = false)
  public JsonNullable<Integer> getStatus() {
    return status;
  }

  public void setStatus(JsonNullable<Integer> status) {
    this.status = status;
  }

  public ErrorDetails detail(String detail) {
    this.detail = JsonNullable.of(detail);
    return this;
  }

  /**
   * Human-readable explanation specific to this occurrence of the problem
   * @return detail
  */
  
  @Schema(name = "detail", description = "Human-readable explanation specific to this occurrence of the problem", required = false)
  public JsonNullable<String> getDetail() {
    return detail;
  }

  public void setDetail(JsonNullable<String> detail) {
    this.detail = detail;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorDetails errorDetails = (ErrorDetails) o;
    return equalsNullable(this.type, errorDetails.type) &&
        equalsNullable(this.title, errorDetails.title) &&
        equalsNullable(this.status, errorDetails.status) &&
        equalsNullable(this.detail, errorDetails.detail);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashCodeNullable(type), hashCodeNullable(title), hashCodeNullable(status), hashCodeNullable(detail));
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorDetails {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
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

