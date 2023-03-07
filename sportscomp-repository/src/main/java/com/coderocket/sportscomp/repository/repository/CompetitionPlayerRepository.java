package com.coderocket.sportscomp.repository.repository;

import com.coderocket.sportscomp.repository.entity.PlayerInCompetition;
import com.coderocket.sportscomp.repository.entity.PlayerInCompetitionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionPlayerRepository extends JpaRepository<PlayerInCompetition, PlayerInCompetitionKey> {
}
