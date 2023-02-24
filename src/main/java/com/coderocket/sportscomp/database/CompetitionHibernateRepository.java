package com.coderocket.sportscomp.database;

import com.coderocket.sportscomp.database.converter.CompetitionDomainToCompetitionEntityConverter;
import com.coderocket.sportscomp.database.converter.CompetitionEntityToCompetitionDomainConverter;
import com.coderocket.sportscomp.domain.Competition;
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
    public void save(Competition competition) {
        var entity = domainToEntityConverter.convert(competition);

        sessionFactory.getCurrentSession().persist(entity);
    }

    @Override
    public void delete(Competition competition) {
        var entity = domainToEntityConverter.convert(competition);
        //sessionFactory.getCurrentSession().find(CompetitionEntity.class, );
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
    // TODO
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
