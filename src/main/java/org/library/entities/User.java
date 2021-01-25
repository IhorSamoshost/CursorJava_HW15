package org.library.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "readers")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreader")
    private int userId;

    @Column(name = "reader_name")
    private String userName;

    @JoinColumn(name = "idreader")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Book> userBooks;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<Book> getUserBooks() {
        return userBooks;
    }

    public void setUserBooks(Set<Book> userBooks) {
        this.userBooks = userBooks;
    }

    public void addBook(Book book) {
        if (userBooks == null) {
            userBooks = new HashSet<>();
        }
        userBooks.add(book);
    }

    public void removeBook(Book book) {
        userBooks.remove(book);
    }

    @Override
    public String toString() {
        return "User{" +
                "id = " + userId +
                ", name = " + userName +
                ", books = " + userBooks +
                '}';
    }
}
