package com.amusnet.service.model;

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
 * GameActivity
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL) @lombok.Builder(toBuilder=true) @lombok.NoArgsConstructor @lombok.AllArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-26T10:51:52.725404300+02:00[Europe/Sofia]")
public class GameActivity implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id;

  @JsonProperty("playerId")
  private Long playerId;

  @JsonProperty("betAmount")
  private BigDecimal betAmount;

  @JsonProperty("winAmount")
  private BigDecimal winAmount;

  @JsonProperty("currency")
  private String currency;

  public GameActivity id(Long id) {
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

  public GameActivity playerId(Long playerId) {
    this.playerId = playerId;
    return this;
  }

  /**
   * Get playerId
   * @return playerId
  */
  
  @Schema(name = "playerId", required = false)
  public Long getPlayerId() {
    return playerId;
  }

  public void setPlayerId(Long playerId) {
    this.playerId = playerId;
  }

  public GameActivity betAmount(BigDecimal betAmount) {
    this.betAmount = betAmount;
    return this;
  }

  /**
   * Get betAmount
   * @return betAmount
  */
  @Valid 
  @Schema(name = "betAmount", required = false)
  public BigDecimal getBetAmount() {
    return betAmount;
  }

  public void setBetAmount(BigDecimal betAmount) {
    this.betAmount = betAmount;
  }

  public GameActivity winAmount(BigDecimal winAmount) {
    this.winAmount = winAmount;
    return this;
  }

  /**
   * Get winAmount
   * @return winAmount
  */
  @Valid 
  @Schema(name = "winAmount", required = false)
  public BigDecimal getWinAmount() {
    return winAmount;
  }

  public void setWinAmount(BigDecimal winAmount) {
    this.winAmount = winAmount;
  }

  public GameActivity currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
  */
  
  @Schema(name = "currency", required = false)
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GameActivity gameActivity = (GameActivity) o;
    return Objects.equals(this.id, gameActivity.id) &&
        Objects.equals(this.playerId, gameActivity.playerId) &&
        Objects.equals(this.betAmount, gameActivity.betAmount) &&
        Objects.equals(this.winAmount, gameActivity.winAmount) &&
        Objects.equals(this.currency, gameActivity.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, playerId, betAmount, winAmount, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GameActivity {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    playerId: ").append(toIndentedString(playerId)).append("\n");
    sb.append("    betAmount: ").append(toIndentedString(betAmount)).append("\n");
    sb.append("    winAmount: ").append(toIndentedString(winAmount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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

