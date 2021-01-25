package org.library.entities;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "author_table")
//@Proxy(lazy = false)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idauthor")
    private int authorId;

    @Column(name = "name_author")
    private String authorName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_written_book")
    private Book writtenBook;

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

    public Book getWrittenBook() {
        return writtenBook;
    }

    public void setWrittenBook(Book book) {
        this.writtenBook = book;
    }

    public void removeWritenBook () {
        writtenBook = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return getAuthorId() == author.getAuthorId() && Objects.equals(getAuthorName(), author.getAuthorName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthorId(), getAuthorName());
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + authorId +
                ", name='" + authorName + '\'' +
                '}';
    }
}
