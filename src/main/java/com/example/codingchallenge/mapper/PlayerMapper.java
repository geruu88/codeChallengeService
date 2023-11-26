package com.example.codingchallenge.mapper;

import com.amusnet.service.model.Player;
import com.coding.challenge.model.PlayerGGR;
import com.example.codingchallenge.entity.PlayerEntity;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {

    public PlayerGGR playerGGRFrom(Map.Entry<Long, BigDecimal> maxGGREntry) {
        return PlayerGGR.builder()
                .id(maxGGREntry.getKey())
                .ggr(maxGGREntry.getValue())
                .build();
    }

    public Player playerFrom(PlayerEntity playerEntity) {
        return Player.builder()
                .id(playerEntity.getId())
                .name(playerEntity.getName())
                .surname(playerEntity.getSurname())
                .build();
    }

    public List<Player> playersFrom(List<PlayerEntity> entities) {
        return entities.stream()
                .map(this::playerFrom)
                .toList();
    }
}
