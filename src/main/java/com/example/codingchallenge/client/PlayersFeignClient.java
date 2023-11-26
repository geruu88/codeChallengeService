package com.example.codingchallenge.client;

import com.amusnet.service.model.Player;
import com.amusnet.service.model.PlayersFilter;
import com.example.codingchallenge.api.PlayersApi;
import com.example.codingchallenge.client.fallback.PlayersFeignClientFallback;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

@FeignClient(name = "players", url = "https://challenge.dev.amusnetgaming.net", fallback = PlayersFeignClientFallback.class)
public interface PlayersFeignClient extends PlayersApi {

    @Cacheable(cacheNames = "playersByFilter")
    default List<Player> getPlayersByFilter(PlayersFilter playersFilter) {
        ResponseEntity<List<Player>> players = getPlayers(playersFilter);
        if (players == null || players.getBody() == null || players.getBody().isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Players not found.");
        }
        return players.getBody();
    }
}
