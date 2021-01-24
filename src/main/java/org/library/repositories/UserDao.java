package org.library.repositories;

//import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.criterion.Restrictions;
import org.library.entities.Book;
import org.library.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDao extends AnyDao<User> {

    public UserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public User getById(Integer entityId) {
        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
        User entity = session.get(User.class, entityId);
//        transaction.commit();
        session.close();
        return entity;
    }

    @Transactional
    public List<User> getAll() {
        Session session = sessionFactory.openSession();
//        List<User> usersFromDB = session.createCriteria(User.class).list();
//        List<User> usersFromDB = session.createQuery("from User", User.class).getResultList();
//        session.close();
//        return usersFromDB;

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
