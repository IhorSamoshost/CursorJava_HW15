package org.library.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "book_table")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbook")
    private int bookId;

    @Column(name = "book_title")
    private String bookTitle;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "idbook"),
            inverseJoinColumns = @JoinColumn(name = "id_author", referencedColumnName = "author_id")
    )
    private Set<Author> authors = new HashSet<>();

    public Book() {
    }

    public Book(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Book(String bookTitle, Set<Author> authors) {
        this.bookTitle = bookTitle;
        this.authors = authors;
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

    public void addAuthor(Author author) {
        authors.add(author);
        author.addWrittenBook(this);
    }

    public void removeAuthor(Author author) {
        authors.remove(author);
        author.removeWrittenBook(this);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + bookId +
                ", title='" + bookTitle + '\'' +
                '}';
    }
}
