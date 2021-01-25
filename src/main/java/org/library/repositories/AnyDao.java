package org.library.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public abstract class AnyDao<T> {
    protected SessionFactory sessionFactory;

//    @Autowired
    public AnyDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public Integer create(T newEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Integer newEntityId = (Integer) session.save(newEntity);
        transaction.commit();
        session.close();
        return newEntityId;
    }

    @Transactional
    public abstract T getById(Integer entityId);

    @Transactional
    public void update(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    @Transactional
    public void delete(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

//    @Transactional
//    public List<T> getAll() {
//        Session session = sessionFactory.openSession();
//        List<Book> booksFromDB = session.createQuery("from Book", Book.class).getResultList();
//        session.close();
//        return booksFromDB;

//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        Class tClass = typedObject.getClass();
//        CriteriaQuery<T> cq = cb.createQuery(tClass);
//        Root<T> rootEntry = cq.from(tClass);
//        CriteriaQuery<T> all = cq.select(rootEntry);
//        TypedQuery<T> allQuery = session.createQuery(all);
//        List<T> booksFromDB = allQuery.getResultList();
//        session.close();
//        return booksFromDB;
//    }
}
