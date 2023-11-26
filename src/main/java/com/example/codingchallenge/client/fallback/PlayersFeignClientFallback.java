package com.example.codingchallenge.client.fallback;

import com.amusnet.service.model.Player;
import com.amusnet.service.model.PlayersFilter;
import com.example.codingchallenge.client.PlayersFeignClient;
import com.example.codingchallenge.entity.PlayerEntity;
import com.example.codingchallenge.mapper.PlayerMapper;
import com.example.codingchallenge.repository.PlayerRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlayersFeignClientFallback implements PlayersFeignClient {
    //TODO: improve this and make this logic more Generic. Decide how to sync DB records

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Override
    public ResponseEntity<Player> getPlayerById(Long playerId) {
        try {
            // Return cached or default data
            return getPlayerByIdCachedData(playerId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve data from external API and no fallback available.", e);
        }
    }

    @Override
    public ResponseEntity<List<Player>> getPlayers(PlayersFilter playersFilter) {
        try {
            // Return cached or default data
            return getPlayersCachedData(playersFilter);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve data from external API and no fallback available.", e);
        }
    }

    private ResponseEntity<Player> getPlayerByIdCachedData(Long playerId) {
        PlayerEntity playerEntity = playerRepository.findById(playerId).orElse(new PlayerEntity());
        return ResponseEntity.ok(playerMapper.playerFrom(playerEntity));
    }

    private ResponseEntity<List<Player>> getPlayersCachedData(PlayersFilter playersFilter) {
        List<PlayerEntity> players = playerRepository.findAllByLimit(playersFilter.getPageSize());
        return ResponseEntity.ok(playerMapper.playersFrom(players));
    }
}
