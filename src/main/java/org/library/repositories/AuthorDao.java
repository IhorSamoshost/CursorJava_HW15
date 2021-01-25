package org.library.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.library.entities.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AuthorDao extends AnyDao<Author> {

    public AuthorDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Author getById(Integer authorId) {
        Session session = sessionFactory.openSession();
        Author entity = session.get(Author.class, authorId);
        session.close();
        return entity;
    }

    public List<Author> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Author> cq = cb.createQuery(Author.class);
        Root<Author> rootEntry = cq.from(Author.class);
        CriteriaQuery<Author> all = cq.select(rootEntry);
        TypedQuery<Author> allQuery = session.createQuery(all);
        List<Author> authorsFromDB = allQuery.getResultList();
        session.close();
        return authorsFromDB;
    }
}
