package org.library.repositories;

//import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.library.entities.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BookDao extends AnyDao<Book>{

    public BookDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Book getById(Integer entityId) {
        Session session = sessionFactory.openSession();
        Book entity = session.get(Book.class, entityId);
        session.close();
        return entity;
    }

//    @Transactional
    public List<Book> getAll() {
        Session session = sessionFactory.openSession();
        List<Book> booksFromDB = session.createQuery("SELECT b FROM Book b", Book.class).getResultList();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
//        Root<Book> rootEntry = cq.from(Book.class);
//        CriteriaQuery<Book> all = cq.select(rootEntry);
//        TypedQuery<Book> allQuery = session.createQuery(all);
//        List<Book> booksFromDB = allQuery.getResultList();
        session.close();
        return booksFromDB;
    }
}
