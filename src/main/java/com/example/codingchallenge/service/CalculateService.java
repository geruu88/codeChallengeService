package com.example.codingchallenge.service;


import com.coding.challenge.model.PlayerGGR;

public interface CalculateService {

    PlayerGGR getPlayerWithLargestGGR(Integer page, Integer pageSize);
}
