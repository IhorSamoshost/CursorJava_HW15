package org.library.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "readers")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreader")
    private int userId;

    @Column(name = "reader_name")
    private String userName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Book> userBooks;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
        this.userBooks = new ArrayList<>();
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

    public List<Book> getUserBooks() {
        return userBooks;
    }

    public void setUserBooks(List<Book> userBooks) {
        this.userBooks = userBooks;
    }

    public void addBook(Book book) {
        userBooks.add(book);
        book.setUser(this);
    }

    public void removeBook(Book book) {
        userBooks.remove(book);
        book.removeUser();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUserId() == user.getUserId() && Objects.equals(getUserName(), user.getUserName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUserName());
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
