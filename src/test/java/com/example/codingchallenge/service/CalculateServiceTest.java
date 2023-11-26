package com.example.codingchallenge.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static java.math.BigDecimal.valueOf;

import com.amusnet.service.model.GameActivity;
import com.amusnet.service.model.GameActivityFilter;
import com.amusnet.service.model.Player;
import com.amusnet.service.model.PlayersFilter;
import com.coding.challenge.model.PlayerGGR;
import com.example.codingchallenge.client.GameActivityFeignClient;
import com.example.codingchallenge.client.PlayersFeignClient;
import com.example.codingchallenge.mapper.PlayerMapper;
import com.example.codingchallenge.service.impl.CalculateServiceImpl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {

    @Mock
    private PlayersFeignClient playersFeignClient;
    @Mock
    private GameActivityFeignClient gameActivityFeignClient;
    @InjectMocks
    private CalculateServiceImpl calculateService;
    @Mock
    private PlayerMapper playerMapper;

    @Test
    void find_PlayerWithLargestGGR_happyFlow() {
        PlayersFilter playersFilter = PlayersFilter.builder()
                .page(1)
                .pageSize(30)
                .build();

        List<Player> players = new ArrayList<>(Arrays.asList(
                Player.builder().id(1L).name("Petar").surname("Petrov").build(),
                Player.builder().id(2L).name("Nikola").surname("Ivanov").build(),
                Player.builder().id(3L).name("Georgi").surname("Todorov").build()));

        GameActivityFilter gameActivityFilter = GameActivityFilter.builder().playerIds(new ArrayList<>(Arrays.asList(1L, 2L, 3L))).build();

        List<GameActivity> gameActivities = new ArrayList<>(Arrays.asList(
                GameActivity.builder().id(1L).playerId(1L).betAmount(valueOf(100)).winAmount(valueOf(0)).build(),
                GameActivity.builder().id(2L).playerId(1L).betAmount(valueOf(100)).winAmount(valueOf(100)).build(),
                GameActivity.builder().id(3L).playerId(1L).betAmount(valueOf(100)).winAmount(valueOf(0)).build(),
                GameActivity.builder().id(4L).playerId(2L).betAmount(valueOf(50)).winAmount(valueOf(500)).build(),
                GameActivity.builder().id(5L).playerId(2L).betAmount(valueOf(50)).winAmount(valueOf(100)).build(),
                GameActivity.builder().id(6L).playerId(3L).betAmount(valueOf(100)).winAmount(valueOf(100)).build(),
                GameActivity.builder().id(7L).playerId(3L).betAmount(valueOf(100)).winAmount(valueOf(0)).build()));

        Map<Long, BigDecimal> playerGGRMap = new HashMap<>();
        playerGGRMap.put(2L, valueOf(500));

        when(playersFeignClient.getPlayersByFilter(playersFilter)).thenReturn(players);
        when(gameActivityFeignClient.getGameActivityByFilter(gameActivityFilter)).thenReturn(gameActivities);
        when(playerMapper.playerGGRFrom(playerGGRMap.entrySet().iterator().next())).thenReturn(
                PlayerGGR.builder().id(2L).ggr(valueOf(500)).build());

        PlayerGGR actualResult = calculateService.getPlayerWithLargestGGR(1, 30);

        PlayerGGR expectedResult = PlayerGGR.builder().id(2L).ggr(valueOf(500)).build();

        assertEquals(actualResult, expectedResult);
    }

    //TODO: Correct result multiple players has same GGR

}
