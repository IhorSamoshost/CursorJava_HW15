package org.library.repositories;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.library.entities.Author;
import org.library.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDao extends AnyDao<Author>{

    public AuthorDao() {
    }

    public AuthorDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Author read(Integer entityId) {
        Session session = sessionFactory.openSession();
        Author entity = session.get(Author.class, entityId);
        session.close();
        return entity;
    }

    public List<Author> getAll() {
        Session session = sessionFactory.openSession();
        List<Author> authorsFromDB = session.createCriteria(Author.class).list();
        session.close();
        return authorsFromDB;
    }
}
