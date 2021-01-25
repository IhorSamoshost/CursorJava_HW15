package org.library.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AnyDao<T> {
    protected SessionFactory sessionFactory;

    public AnyDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Integer create(T newEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Integer newEntityId = (Integer) session.save(newEntity);
        transaction.commit();
        session.close();
        return newEntityId;
    }

    public abstract T getById(Integer entityId);

    public void update(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    public void delete(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }
}