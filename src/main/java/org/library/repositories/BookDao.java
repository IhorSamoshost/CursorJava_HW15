package org.library.repositories;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.library.entities.Author;
import org.library.entities.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDao extends AnyDao<Book>{

    public BookDao() {
    }

    public BookDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Book read(Integer entityId) {
        Session session = sessionFactory.openSession();
        Book entity = session.get(Book.class, entityId);
        session.close();
        return entity;
    }

    public List<Book> getAll() {
        Session session = sessionFactory.openSession();
        List<Book> booksFromDB = session.createCriteria(Book.class).list();
        session.close();
        return booksFromDB;
    }
}
