package org.library.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.library.entities.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDao extends AnyDao<Book> {

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

    public List<Book> getAll() {
        Session session = sessionFactory.openSession();
        List<Book> booksFromDB = session.createQuery("SELECT b FROM Book b", Book.class).getResultList();
        session.close();
        return booksFromDB;
    }
}
