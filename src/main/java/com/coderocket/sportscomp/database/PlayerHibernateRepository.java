package com.coderocket.sportscomp.database;

import com.coderocket.sportscomp.database.converter.PlayerDomainToPlayerEntityConverter;
import com.coderocket.sportscomp.database.converter.PlayerEntityToPlayerDomainConverter;
import com.coderocket.sportscomp.domain.Player;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public List<Player> findAllPlayers() {
        Session session = sessionFactory.openSession();
        try {
            var builder = session.getCriteriaBuilder();
            var query = builder.createQuery(Player.class);

            var root = query.from(Player.class);
            query.select(root);

            Query<Player> q = session.createQuery(query);

            return q.getResultList();
        } finally {
            session.close();
        }
    }
}
