package com.example.codingchallenge.mapper;

import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.amusnet.service.model.GameActivity;
import com.amusnet.service.model.GameActivityFilter;
import com.amusnet.service.model.Player;
import com.amusnet.service.model.PlayersFilter;
import com.coding.challenge.model.PlayerGGR;
import com.example.codingchallenge.client.GameActivityFeignClient;
import com.example.codingchallenge.client.PlayersFeignClient;
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
public class PlayerMapperTest {

    @InjectMocks
    private PlayerMapper playerMapper;

    @Test
    void find_PlayerWithLargestGGR_happyFlow() {
        Map<Long, BigDecimal> playerGGRMap = new HashMap<>();
        playerGGRMap.put(2L, valueOf(500));

        PlayerGGR actualResult = playerMapper.playerGGRFrom(playerGGRMap.entrySet().iterator().next());

        PlayerGGR expectedResult = PlayerGGR.builder().id(2L).ggr(valueOf(500)).build();
        assertEquals(actualResult, expectedResult);
    }
}
