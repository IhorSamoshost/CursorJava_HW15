package org.library;

import org.library.entities.Author;
import org.library.entities.Book;
import org.library.entities.User;
import org.library.repositories.AuthorDao;
import org.library.repositories.BookDao;
import org.library.repositories.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        AuthorDao authorDao = applicationContext.getBean(AuthorDao.class);
        UserDao userDao = applicationContext.getBean(UserDao.class);
        BookDao bookDao = applicationContext.getBean(BookDao.class);

        User user1 = new User("ihor");
        User user2 = new User("ivan");
        User user3 = new User("Illia");

        Author author1 = new Author("O. Wilde");
        Author author2 = new Author("M. Twain");
        Author author3 = new Author("H.G. Wells");
        Author author4 = new Author("T. Pratchett");
        Author author5 = new Author("N. Gaiman");
        Author author6 = new Author("S. E. King");
        Author author7 = new Author("R. Chizmar");

        Book book1 = new Book("The Picture of Dorian Gray", 3);
        book1.addAuthor(author1);
        Book book2 = new Book("The Adventures of Tom Sawyer", 5);
        book2.addAuthor(author2);
        Book book3 = new Book("The Invisible Man", 2);
        book3.addAuthor(author3);
        Book book4 = new Book("Good Omens", 2);
        book4.addAuthor(author4);
        book4.addAuthor(author5);
        Book book5 = new Book("Gwendy's Button Box", 2);
        book5.addAuthor(author6);
        book5.addAuthor(author7);

        author1.addWritenBook(book1);
        author2.addWritenBook(book2);
        author3.addWritenBook(book3);
        author4.addWritenBook(book4);
        author5.addWritenBook(book4);
        author6.addWritenBook(book5);
        author7.addWritenBook(book5);

        user1.addBook(book1);
        user1.addBook(book5);
        user2.addBook(book2);
        user2.addBook(book3);
        user3.addBook(book4);
        user3.addBook(book2);

        Integer user1_id = userDao.create(user1);
        Integer user2_id = userDao.create(user1);
        Integer user3_id = userDao.create(user1);
        userDao.getAll().forEach(System.out::println);
        System.out.println(userDao.read(user1_id).getUserBooks());

        Integer author1_id = authorDao.create(author1);
        Integer author2_id = authorDao.create(author2);
        Integer author3_id = authorDao.create(author3);
        Integer author4_id = authorDao.create(author4);
        Integer author5_id = authorDao.create(author5);
        Integer author6_id = authorDao.create(author6);
        Integer author7_id = authorDao.create(author7);
        authorDao.getAll().forEach(System.out::println);
        System.out.println(authorDao.read(author3_id));

        Integer book1_id = bookDao.create(book1);
        Integer book2_id = bookDao.create(book2);
        Integer book3_id = bookDao.create(book3);
        Integer book4_id = bookDao.create(book4);
        Integer book5_id = bookDao.create(book5);
        bookDao.getAll().forEach(System.out::println);
        System.out.println(bookDao.read(book4_id));
    }
}
