package com.coderocket.sportscomp.repository.repository;

import com.coderocket.sportscomp.domain.Competition;
import com.coderocket.sportscomp.repository.entity.CompetitionEntity;
import com.coderocket.sportscomp.repository.converter.CompetitionDomainToCompetitionEntityConverter;
import com.coderocket.sportscomp.repository.converter.CompetitionEntityToCompetitionDomainConverter;
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
