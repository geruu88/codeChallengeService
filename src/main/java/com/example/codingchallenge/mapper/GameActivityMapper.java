package com.example.codingchallenge.mapper;

import com.amusnet.service.model.GameActivity;
import com.example.codingchallenge.entity.GameActivityEntity;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GameActivityMapper {

    public GameActivity gameActivityFrom(GameActivityEntity entity) {
        return GameActivity.builder()
                .id(entity.getId())
                .playerId(entity.getPlayerEntity().getId())
                .betAmount(entity.getBetAmount())
                .winAmount(entity.getWinAmount())
                .currency(entity.getCurrency().toString())
                .build();
    }

    public List<GameActivity> gameActivitiesFrom(List<GameActivityEntity> entities) {
        return entities.stream()
                .map(this::gameActivityFrom)
                .toList();
    }
}
