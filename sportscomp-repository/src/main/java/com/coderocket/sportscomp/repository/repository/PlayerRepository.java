package com.coderocket.sportscomp.repository.repository;

import com.coderocket.sportscomp.repository.entity.PlayerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<PlayerEntity, Integer> {
}
