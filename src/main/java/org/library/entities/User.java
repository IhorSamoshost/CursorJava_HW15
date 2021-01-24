package org.library.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_book",
            joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "id_book", referencedColumnName = "book_id")
    )
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
    }

    public void removeBook(Book book) {
        userBooks.remove(book);
    }

    @Override
    public String toString() {
        return "User{" +
                "id = " + userId +
                ", name = " + userName +
//                ", books = " + userBooks +
                '}';
    }
}
