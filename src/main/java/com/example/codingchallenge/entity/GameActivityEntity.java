package com.example.codingchallenge.entity;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;

import com.example.codingchallenge.enums.CurrencyEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder(builderMethodName = "aNewGameActivityEntity", toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "game_activity")
public class GameActivityEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @ToString.Exclude
    @JsonBackReference
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private PlayerEntity playerEntity;

    @Column(name = "bet_amount")
    private BigDecimal betAmount;

    @Column(name = "win_amount")
    private BigDecimal winAmount;

    @Enumerated(STRING)
    @Column(name = "currency")
    private CurrencyEnum currency;
}
