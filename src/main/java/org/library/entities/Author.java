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

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "authors")
    private Set<Book> writtenBooks;

    public Author() {
    }

    public Author(String authorName) {
        this.authorName = authorName;
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

    public Set<Book> getWrittenBooks() {
        return writtenBooks;
    }

    public void setWrittenBooks(Set<Book> books) {
        this.writtenBooks = books;
    }

    public void removeWritenBooks() {
        writtenBooks = null;
    }

    public void addWrittenBook(Book book) {
        if (writtenBooks == null) {
            writtenBooks = new HashSet<>();
        }
        writtenBooks.add(book);
    }

    public void removeWrittenBook(Book book) {
        writtenBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id = " + authorId +
                ", name = " + authorName +
                '}';
    }
}
