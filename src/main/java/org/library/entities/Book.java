package org.library.entities;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "book_table")
//@Proxy(lazy = false)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbook")
    private int bookId;

    @Column(name = "book_title")
    private String bookTitle;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "writtenBook")
    private Set<Author> authors = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idreader")
    private User user;

    public Book() {
    }

    public Book(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addAuthor(Author author) {
        authors.add(author);
        author.setWrittenBook(this);
    }

    public void removeAuthor(Author author) {
        authors.remove(author);
        author.removeWritenBook();
    }

    public void removeUser() {
       user = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getBookId() == book.getBookId() && Objects.equals(getBookTitle(), book.getBookTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getBookTitle());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + bookId +
                ", title='" + bookTitle + '\'' +
                ", authors=" + authors +
                '}';
    }
}
