package com.example.codingchallenge.repository;

import com.example.codingchallenge.entity.PlayerEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

    @Query(value = "SELECT p.* FROM players p LIMIT :fetchSize", nativeQuery = true)
    List<PlayerEntity> findAllByLimit(int fetchSize);
}
