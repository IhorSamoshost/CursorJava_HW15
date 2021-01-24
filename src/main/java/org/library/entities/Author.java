package org.library.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int authorId;

    @Column(name = "author_name")
    private String authorName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "id_author", referencedColumnName = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "id_book", referencedColumnName = "book_id")
    )
    private Set<Book> authorBooks;

    public Author() {
    }

    public Author(String authorName) {
        this.authorName = authorName;
        this.authorBooks = new HashSet<>();
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Set<Book> getAuthorBooks() {
        return authorBooks;
    }

    public void setAuthorBooks(Set<Book> authorBooks) {
        this.authorBooks = authorBooks;
    }

    public void addWritenBook (Book book) {
        authorBooks.add(book);
    }

    public void removeWritenBook (Book book) {
        authorBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id = " + authorId +
                ", name = " + authorName +
                '}';
    }
}
