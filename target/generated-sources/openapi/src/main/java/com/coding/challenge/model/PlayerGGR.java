package com.coding.challenge.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
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
 * PlayerGGR
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL) @lombok.Builder(toBuilder=true) @lombok.NoArgsConstructor @lombok.AllArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-26T10:51:52.430406600+02:00[Europe/Sofia]")
public class PlayerGGR implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id;

  @JsonProperty("ggr")
  private BigDecimal ggr;

  public PlayerGGR id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", required = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PlayerGGR ggr(BigDecimal ggr) {
    this.ggr = ggr;
    return this;
  }

  /**
   * Get ggr
   * @return ggr
  */
  @Valid 
  @Schema(name = "ggr", required = false)
  public BigDecimal getGgr() {
    return ggr;
  }

  public void setGgr(BigDecimal ggr) {
    this.ggr = ggr;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlayerGGR playerGGR = (PlayerGGR) o;
    return Objects.equals(this.id, playerGGR.id) &&
        Objects.equals(this.ggr, playerGGR.ggr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, ggr);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlayerGGR {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    ggr: ").append(toIndentedString(ggr)).append("\n");
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

