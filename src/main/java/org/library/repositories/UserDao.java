package org.library.repositories;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.library.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao extends AnyDao<User> {

    public UserDao() {
    }

    public UserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public User read(Integer entityId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User entity = session.get(User.class, entityId);
        transaction.commit();
        session.close();
        return entity;
    }

    public List<User> getAll() {
        Session session = sessionFactory.openSession();
        List<User> usersFromDB = session.createCriteria(User.class).list();
        session.close();
        return usersFromDB;
    }
}
