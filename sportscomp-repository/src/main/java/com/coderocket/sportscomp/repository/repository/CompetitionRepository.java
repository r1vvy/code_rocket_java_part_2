package com.coderocket.sportscomp.repository.repository;

import com.coderocket.sportscomp.repository.entity.CompetitionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends CrudRepository<CompetitionEntity, Integer> {

}
