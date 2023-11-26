package com.example.codingchallenge.service.impl;

import com.amusnet.service.model.GameActivity;
import com.amusnet.service.model.GameActivityFilter;
import com.amusnet.service.model.Player;
import com.amusnet.service.model.PlayersFilter;
import com.coding.challenge.model.PlayerGGR;
import com.example.codingchallenge.client.GameActivityFeignClient;
import com.example.codingchallenge.client.PlayersFeignClient;
import com.example.codingchallenge.mapper.PlayerMapper;
import com.example.codingchallenge.service.CalculateService;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@AllArgsConstructor
public class CalculateServiceImpl implements CalculateService {

    private final PlayersFeignClient playersFeignClient;
    private final GameActivityFeignClient gameActivityFeignClient;
    private final PlayerMapper playerMapper;

    @Override
    @Cacheable(value = "externalApiCache", key = "'externalApiData'")
    public PlayerGGR getPlayerWithLargestGGR(Integer page, Integer pageSize) {
        PlayersFilter playersFilter = PlayersFilter.builder()
                .page(page)
                .pageSize(pageSize)
                .build();

        List<Player> players = playersFeignClient.getPlayersByFilter(playersFilter);

        List<Long> playersIds = players.stream().map(Player::getId).toList();

        //TODO: external API is not filtering correctly by playersIds.Check this with API provider.
        List<GameActivity> filteredPlayersGameActivities = gameActivityFeignClient.getGameActivityByFilter(
                GameActivityFilter.builder().playerIds(playersIds).build());

        return calculatePlayerWithLargestGGR(filteredPlayersGameActivities);
    }

    private PlayerGGR calculatePlayerWithLargestGGR(List<GameActivity> filteredPlayersGameActivities) {
        Map<Long, BigDecimal> totalGGRByPlayer = filteredPlayersGameActivities.stream()
                .collect(Collectors.groupingBy(
                        GameActivity::getPlayerId,
                        Collectors.mapping(
                                gameActivity -> gameActivity.getWinAmount().subtract(gameActivity.getBetAmount()),
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                        )
                ));

        Map.Entry<Long, BigDecimal> maxGGREntry = totalGGRByPlayer.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .orElse(null);

        return playerMapper.playerGGRFrom(maxGGREntry);
    }


}
