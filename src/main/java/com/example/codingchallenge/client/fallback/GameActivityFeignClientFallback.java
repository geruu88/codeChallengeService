package com.example.codingchallenge.client.fallback;

import com.amusnet.service.model.GameActivity;
import com.amusnet.service.model.GameActivityFilter;
import com.example.codingchallenge.client.GameActivityFeignClient;
import com.example.codingchallenge.entity.GameActivityEntity;
import com.example.codingchallenge.mapper.GameActivityMapper;
import com.example.codingchallenge.repository.GameActivityRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GameActivityFeignClientFallback implements GameActivityFeignClient {
    //TODO: improve this and make this logic more Generic. Decide how to sync DB records

    private final GameActivityRepository gameActivityRepository;
    private final GameActivityMapper gameActivityMapper;

    @Override
    public ResponseEntity<List<GameActivity>> getGameActivity(GameActivityFilter gameActivityFilter) {
        try {
            // Return cached or default data
            return getGameActivitiesCachedData(gameActivityFilter);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve data from external API and no fallback available.", e);
        }
    }

    @Override
    public ResponseEntity<GameActivity> getGameActivityById(Long gameActivityId) {
        try {
            // Return cached or default data
            return getGameActivityByIdCachedData(gameActivityId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve data from external API and no fallback available.", e);
        }
    }

    private ResponseEntity<GameActivity> getGameActivityByIdCachedData(Long playerId) {
        GameActivityEntity playerEntity = gameActivityRepository.findById(playerId).orElse(new GameActivityEntity());
        return ResponseEntity.ok(gameActivityMapper.gameActivityFrom(playerEntity));
    }

    private ResponseEntity<List<GameActivity>> getGameActivitiesCachedData(GameActivityFilter gameActivityFilter) {
        List<GameActivityEntity> gameActivities = gameActivityRepository.findAllByPlayerIds(gameActivityFilter.getPlayerIds());
        return ResponseEntity.ok(gameActivityMapper.gameActivitiesFrom(gameActivities));
    }
}
