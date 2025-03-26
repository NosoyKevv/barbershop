package com.barbershop.learnCriteria.repository.Impl;

import com.barbershop.learnCriteria.entity.Book;
import com.barbershop.learnCriteria.repository.BookRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Book> findBookByAuthorNameAndTitle(String authorName, String title) {
        CriteriaBuilder cb = em.getCriteriaBuilder(); // instanciamos criteryBuilder
        CriteriaQuery<Book> cq = cb.createQuery(Book.class); // lo que queremos hacer o devolver en la consulta

        Root<Book> book = cq.from(Book.class);
        Predicate authorNamePredicate = cb.equal(book.get("author"), authorName);//condiciones predicate se usan en el where
        Predicate titlePredicate = cb.like(book.get("title"), "%" + title + "%");
        cq.where(authorNamePredicate, titlePredicate); //aplicamos nuestras condiciones en la consulta cb

        TypedQuery<Book> query = em.createQuery(cq);
        return query.getResultList();
    }
}
