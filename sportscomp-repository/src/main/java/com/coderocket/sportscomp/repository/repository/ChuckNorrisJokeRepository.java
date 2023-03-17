package com.coderocket.sportscomp.repository.repository;

import com.coderocket.sportscomp.repository.entity.ChuckNorrisJokeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChuckNorrisJokeRepository extends JpaRepository<ChuckNorrisJokeEntity, Integer> {
}
