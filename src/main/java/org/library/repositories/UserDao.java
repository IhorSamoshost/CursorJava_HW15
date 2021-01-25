package org.library.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.library.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDao extends AnyDao<User> {

    public UserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public User getById(Integer entityId) {
        Session session = sessionFactory.openSession();
        User entity = session.get(User.class, entityId);
        session.close();
        return entity;
    }

    public List<User> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> rootEntry = cq.from(User.class);
        CriteriaQuery<User> all = cq.select(rootEntry);
        TypedQuery<User> allQuery = session.createQuery(all);
        List<User> usersFromDB = allQuery.getResultList();
        session.close();
        return usersFromDB;
    }
}
