package com.example.codingchallenge.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder(builderMethodName = "aNewPlayerEntity", toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "players")
public class PlayerEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

}
