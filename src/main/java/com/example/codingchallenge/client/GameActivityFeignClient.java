package com.example.codingchallenge.client;

import com.amusnet.service.model.GameActivity;
import com.amusnet.service.model.GameActivityFilter;
import com.amusnet.service.model.Player;
import com.example.codingchallenge.api.GameActivityApi;
import com.example.codingchallenge.client.fallback.GameActivityFeignClientFallback;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

@FeignClient(name = "gameActivity", url = "https://challenge.dev.amusnetgaming.net", fallback = GameActivityFeignClientFallback.class)
public interface GameActivityFeignClient extends GameActivityApi {

    @Cacheable(cacheNames = "gameActivityByFilter")
    default List<GameActivity> getGameActivityByFilter(GameActivityFilter gameActivityFilter) {
        ResponseEntity<List<GameActivity>> gameActivities = getGameActivity(gameActivityFilter);
        if (gameActivities == null || gameActivities.getBody() == null || gameActivities.getBody().isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Game activities not found.");
        }
        return gameActivities.getBody();
    }
}
