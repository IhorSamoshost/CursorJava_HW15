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
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        AuthorDao authorDao = applicationContext.getBean(AuthorDao.class);
        UserDao userDao = applicationContext.getBean(UserDao.class);
        BookDao bookDao = applicationContext.getBean(BookDao.class);

        Author author1 = new Author("O. Wilde");
        Author author2 = new Author("M. Twain");
        Author author3 = new Author("H.G. Wells");
        Author author4 = new Author("T. Pratchett");
        Author author5 = new Author("N. Gaiman");
        Author author6 = new Author("S. E. King");
        Author author7 = new Author("R. Chizmar");

        Integer author1_id = authorDao.create(author1);
        Integer author2_id = authorDao.create(author2);
        Integer author3_id = authorDao.create(author3);
        Integer author4_id = authorDao.create(author4);
        Integer author5_id = authorDao.create(author5);
        Integer author6_id = authorDao.create(author6);
        Integer author7_id = authorDao.create(author7);

        Book book1 = new Book("The Picture of Dorian Gray");
        book1.addAuthor(author1);
        Book book2 = new Book("The Adventures of Tom Sawyer");
        book2.addAuthor(author2);
        Book book3 = new Book("The Invisible Man");
        book3.addAuthor(author3);
        Book book4 = new Book("Good Omens");
        book4.addAuthor(author4);
        book4.addAuthor(author5);
        Book book5 = new Book("Gwendy's Button Box");
        book5.addAuthor(author6);
        book5.addAuthor(author7);

        Integer book1_id = bookDao.create(book1);
        Integer book2_id = bookDao.create(book2);
        Integer book3_id = bookDao.create(book3);
        Integer book4_id = bookDao.create(book4);
        Integer book5_id = bookDao.create(book5);

        User user1 = new User("ihor");
        user1.addBook(book1);
        user1.addBook(book5);
        User user2 = new User("ivan");
        user2.addBook(book2);
        user2.addBook(book3);
        User user3 = new User("illija");
        user3.addBook(book4);

        Integer user1_id = userDao.create(user1);
        Integer user2_id = userDao.create(user2);
        Integer user3_id = userDao.create(user3);

        System.out.println("Get all authors from DB: ");
        authorDao.getAll().forEach(System.out::println);
        System.out.println("===========================================================");

        System.out.println("Get one author from DB: ");
        Author foundAuthor = authorDao.getById(author3_id);
        System.out.println(foundAuthor);
        System.out.println("His/her written books: " + foundAuthor.getWrittenBooks());
        System.out.println("===========================================================");

        System.out.println("Get all books from DB: ");
        bookDao.getAll().forEach(System.out::println);
        System.out.println("===========================================================");

        System.out.println("Get one book from DB: ");
        Book foundBook = bookDao.getById(book4_id);
        System.out.println(foundBook);
        System.out.println("It's author(s): " + foundBook.getAuthors());
        System.out.println("===========================================================");

        System.out.println("Get all users from DB: ");
        userDao.getAll().forEach(System.out::println);
        System.out.println("===========================================================");

        System.out.println("Get one user from DB: ");
        User userForUpdate = userDao.getById(user1_id);
        System.out.println(userForUpdate);
        Book newBookForOurUser = new Book(book4.getBookTitle(), book4.getAuthors());
        userForUpdate.addBook(newBookForOurUser);
        System.out.println("Added book " + newBookForOurUser.getBookTitle() + " for this user:");
        userDao.update(userForUpdate);
        User userAfterUpdate = userDao.getById(user1_id);
        System.out.println(userAfterUpdate);
        System.out.println("===========================================================");
    }
}
