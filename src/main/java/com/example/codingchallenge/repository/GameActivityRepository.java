package com.example.codingchallenge.repository;

import com.example.codingchallenge.entity.GameActivityEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GameActivityRepository extends JpaRepository<GameActivityEntity, Long> {
    @Query(value = "SELECT g.* FROM game_activity g WHERE g.player_id IN :playerIds", nativeQuery = true)
    List<GameActivityEntity> findAllByPlayerIds(List<Long> playerIds);
}
