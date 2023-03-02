package com.coderocket.sportscomp.repository.repository;

import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.repository.converter.CompetitionDomainToCompetitionEntityConverter;
import com.coderocket.sportscomp.repository.converter.CompetitionEntityToCompetitionDomainConverter;
import com.coderocket.sportscomp.repository.entity.CompetitionEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Transactional
@AllArgsConstructor
public class CompetitionHibernateRepository implements CompetitionRepository {

    private final SessionFactory sessionFactory;
    private final CompetitionEntityToCompetitionDomainConverter entityToDomainConverter;
    private final CompetitionDomainToCompetitionEntityConverter domainToEntityConverter;

    @Override
    public Competition save(Competition competition) {
        var entity = domainToEntityConverter.convert(competition);
        sessionFactory.getCurrentSession().persist(entity);

        return entityToDomainConverter.convert(entity);
    }

    @Override
    public Competition update(Competition updatedCompetition, Integer id) {
        var entityFromRepo = sessionFactory.getCurrentSession().get(CompetitionEntity.class, id);
        //sessionFactory.getCurrentSession().evict(entityFromRepo);

        if(!updatedCompetition.getTitle().equals(null))
            entityFromRepo.setTitle(updatedCompetition.getTitle());
        if(!updatedCompetition.getCapacity().equals(null))
            entityFromRepo.setCapacity(updatedCompetition.getCapacity());
        if(updatedCompetition.getRegistrationOpen() != null)
            entityFromRepo.setRegistrationOpen(updatedCompetition.getRegistrationOpen());
        if(updatedCompetition.getRegistrationClose() != null)
            entityFromRepo.setRegistrationClose(updatedCompetition.getRegistrationClose());
        if(updatedCompetition.getStartDate() != null)
            entityFromRepo.setStartDate(updatedCompetition.getStartDate());
        if(updatedCompetition.getEndDate() != null)
            entityFromRepo.setEndDate(updatedCompetition.getStartDate());

        sessionFactory.getCurrentSession().merge(domainToEntityConverter.convert(updatedCompetition));

        return entityToDomainConverter.convert(entityFromRepo);
    }


    @Override
    public void delete(Competition competition) {
        var entity = domainToEntityConverter.convert(competition);
        entity.setId(competition.getId());

        sessionFactory.getCurrentSession().remove(entity);
    }

    @Override
    public List<Competition> findAllCompetitions() {
        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CompetitionEntity> criteriaQuery = builder.createQuery(CompetitionEntity.class);

        Root<CompetitionEntity> root = criteriaQuery.from(CompetitionEntity.class);
        criteriaQuery.select(root);
        Query<CompetitionEntity> sessionQuery = session.createQuery(criteriaQuery);

        return sessionQuery.getResultList()
                .stream()
                .map(entityToDomainConverter::convert)
                .collect(Collectors.toList());
    }
    @Override
    public Optional<Competition> findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CompetitionEntity> criteriaQuery = builder.createQuery(CompetitionEntity.class);

        Root<CompetitionEntity> root = criteriaQuery.from(CompetitionEntity.class);
        criteriaQuery.select(root).where(builder.equal(root.get("id"), id));

        Query<CompetitionEntity> sessionQuery = session.createQuery(criteriaQuery);

        return sessionQuery.uniqueResultOptional().map(entityToDomainConverter::convert);
    }
}
