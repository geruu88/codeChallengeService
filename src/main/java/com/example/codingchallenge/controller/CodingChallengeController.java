package com.example.codingchallenge.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

import com.coding.challenge.api.CodingChallengeControllerApi;
import com.coding.challenge.model.PlayerGGR;
import com.example.codingchallenge.service.CalculateService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CodingChallengeController implements CodingChallengeControllerApi {

    private final CalculateService calculateService;

    @Override
    public ResponseEntity<PlayerGGR> getPlayerWithLargestGGR(Integer page, Integer pageSize) {
        PlayerGGR playerGgr = calculateService.getPlayerWithLargestGGR(page, pageSize);
        return status(OK).body(playerGgr);
    }
}
