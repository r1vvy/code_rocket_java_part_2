package com.coderocket.sportscomp.repository.repository;

import com.coderocket.sportscomp.domain.Player;
import com.coderocket.sportscomp.repository.entity.PlayerEntity;
import com.coderocket.sportscomp.repository.converter.PlayerDomainToPlayerEntityConverter;
import com.coderocket.sportscomp.repository.converter.PlayerEntityToPlayerDomainConverter;
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
public class PlayerHibernateRepository implements PlayerRepository {
    private final SessionFactory sessionFactory;
    private final PlayerEntityToPlayerDomainConverter entityToPlayerDomainConverter;
    private final PlayerDomainToPlayerEntityConverter domainToPlayerEntityConverter;

    @Override
    public void save(Player player) {
        var entity = domainToPlayerEntityConverter.convert(player);

        sessionFactory.getCurrentSession().persist(entity);
    }

    @Override
    public void delete(Player player) {
        var entity = domainToPlayerEntityConverter.convert(player);
        System.out.println(player.getId().toString());
        entity.setId(player.getId());

        sessionFactory.getCurrentSession().remove(entity);
    }

    @Override
    public Optional<Player> findPlayerById(Integer id) {
        Session session = sessionFactory.openSession();

        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<PlayerEntity> criteriaQuery = builder.createQuery(PlayerEntity.class);

            Root<PlayerEntity> root = criteriaQuery.from(PlayerEntity.class);
            criteriaQuery.select(root);

            criteriaQuery.select(root).where(builder.equal(root.get("id"), id));


            Query<PlayerEntity> sessionQuery = session.createQuery(criteriaQuery);

            return sessionQuery
                    .uniqueResultOptional()
                    .map(entityToPlayerDomainConverter::convert);
        } finally {
            session.close();
        }
    }

    @Override
    public List<Player> findAllPlayers() {
        Session session = sessionFactory.openSession();
        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<PlayerEntity> query = builder.createQuery(PlayerEntity.class);

            Root<PlayerEntity> root = query.from(PlayerEntity.class);
            query.select(root);
            Query<PlayerEntity> q = session.createQuery(query);

            return q.getResultList()
                    .stream()
                    .map(entityToPlayerDomainConverter::convert)
                    .collect(Collectors.toList());
        } finally {
            session.close();
        }
    }


}
