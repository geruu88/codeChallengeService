package com.amusnet.service.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
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
 * GameActivityFilter
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL) @lombok.Builder(toBuilder=true) @lombok.NoArgsConstructor @lombok.AllArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-26T10:51:52.725404300+02:00[Europe/Sofia]")
public class GameActivityFilter implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("ids")
  @Valid
  private List<Long> ids = null;

  @JsonProperty("playerIds")
  @Valid
  private List<Long> playerIds = null;

  @JsonProperty("page")
  private Integer page;

  @JsonProperty("pageSize")
  private Integer pageSize;

  public GameActivityFilter ids(List<Long> ids) {
    this.ids = ids;
    return this;
  }

  public GameActivityFilter addIdsItem(Long idsItem) {
    if (this.ids == null) {
      this.ids = new ArrayList<>();
    }
    this.ids.add(idsItem);
    return this;
  }

  /**
   * Get ids
   * @return ids
  */
  
  @Schema(name = "ids", required = false)
  public List<Long> getIds() {
    return ids;
  }

  public void setIds(List<Long> ids) {
    this.ids = ids;
  }

  public GameActivityFilter playerIds(List<Long> playerIds) {
    this.playerIds = playerIds;
    return this;
  }

  public GameActivityFilter addPlayerIdsItem(Long playerIdsItem) {
    if (this.playerIds == null) {
      this.playerIds = new ArrayList<>();
    }
    this.playerIds.add(playerIdsItem);
    return this;
  }

  /**
   * Get playerIds
   * @return playerIds
  */
  
  @Schema(name = "playerIds", required = false)
  public List<Long> getPlayerIds() {
    return playerIds;
  }

  public void setPlayerIds(List<Long> playerIds) {
    this.playerIds = playerIds;
  }

  public GameActivityFilter page(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * Get page
   * @return page
  */
  
  @Schema(name = "page", required = false)
  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public GameActivityFilter pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  /**
   * Get pageSize
   * @return pageSize
  */
  
  @Schema(name = "pageSize", required = false)
  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GameActivityFilter gameActivityFilter = (GameActivityFilter) o;
    return Objects.equals(this.ids, gameActivityFilter.ids) &&
        Objects.equals(this.playerIds, gameActivityFilter.playerIds) &&
        Objects.equals(this.page, gameActivityFilter.page) &&
        Objects.equals(this.pageSize, gameActivityFilter.pageSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ids, playerIds, page, pageSize);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GameActivityFilter {\n");
    sb.append("    ids: ").append(toIndentedString(ids)).append("\n");
    sb.append("    playerIds: ").append(toIndentedString(playerIds)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
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

