package com.coderocket.sportscomp.repository.repository;

import com.coderocket.sportscomp.repository.entity.CompetitionEntity;
import com.coderocket.sportscomp.repository.entity.CompetitionPlayerEntity;
import com.coderocket.sportscomp.repository.entity.CompetitionPlayerKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetitionPlayerRepository extends JpaRepository<CompetitionPlayerEntity, CompetitionPlayerKey> {
    List<CompetitionPlayerEntity> findAllByCompetitionEntity(CompetitionEntity competitionEntity);
    List<CompetitionPlayerEntity> findAllByIdCompetitionEntityId(Integer competitionEntityId);
}
