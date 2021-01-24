package org.library.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "title")
    private String bookTitle;

    @Column(name = "total_count")
    private int bookTotalCount;

    @Column(name = "remain_count")
    private int remainCount;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "authorBooks")
    private Set<Author> authors;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "userBooks")
    private List<User> users;

    public Book() {
    }

    public Book(String bookTitle, int bookTotalCount) {
        this.bookTitle = bookTitle;
        this.bookTotalCount = bookTotalCount;
        this.remainCount = this.bookTotalCount;
        this.authors = new HashSet<>();
        this.users = new ArrayList<>();
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

    public int getBookTotalCount() {
        return bookTotalCount;
    }

    public void setBookTotalCount(int bookTotalCount) {
        this.bookTotalCount = bookTotalCount;
    }

    public int getRemainCount() {
        return remainCount;
    }

    public void setRemainCount(int remainCount) {
        this.remainCount = remainCount;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addAuthor(Author author) {
        authors.add(author);
        author.addWritenBook(this);
    }

    public void removeAuthor(Author author) {
        authors.remove(author);
        author.removeWritenBook(this);
    }

    public void addUser(User user) {
        if (remainCount > 0) {
            users.add(user);
            remainCount--;
            user.addBook(this);
        } else {
            System.out.println("There are no available books in library!");
        }
    }

    public void removeUser(User user) {
        if (users.contains(user)) {
            users.remove(user);
            remainCount++;
            user.removeBook(this);
        } else System.out.println("There is not such user for this book!");
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookTotalCount=" + bookTotalCount +
                ", remainCount=" + remainCount +
                ", authors=" + authors +
                ", users=" + users +
                '}';
    }
}
