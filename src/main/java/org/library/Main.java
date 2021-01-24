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

//        User user1 = new User("ihor");
//        User user2 = new User("ivan");
//        User user3 = new User("Illia");

//        Author author1 = new Author("O. Wilde");
//        Author author2 = new Author("M. Twain");
//        Author author3 = new Author("H.G. Wells");
//        Author author4 = new Author("T. Pratchett");
//        Author author5 = new Author("N. Gaiman");
//        Author author6 = new Author("S. E. King");
//        Author author7 = new Author("R. Chizmar");

//        Book book1 = new Book("The Picture of Dorian Gray", 3);
//        book1.addAuthor(author1);
//        book1.addUser(user1);
//        Book book2 = new Book("The Adventures of Tom Sawyer", 5);
//        book2.addAuthor(author2);
//        book2.addUser(user2);
//        book2.addUser(user3);
//        Book book3 = new Book("The Invisible Man", 2);
//        book3.addAuthor(author3);
//        book3.addUser(user2);
//        Book book4 = new Book("Good Omens", 2);
//        book4.addAuthor(author4);
//        book4.addAuthor(author5);
//        book4.addUser(user3);
//        Book book5 = new Book("Gwendy's Button Box", 2);
//        book5.addAuthor(author6);
//        book5.addAuthor(author7);
//        book5.addUser(user1);

//        Integer book1_id = bookDao.create(book1);
//        Integer book2_id = bookDao.create(book2);
//        Integer book3_id = bookDao.create(book3);
//        Integer book4_id = bookDao.create(book4);
//        Integer book5_id = bookDao.create(book5);
//
//        Integer user1_id = userDao.create(user1);
//        Integer user2_id = userDao.create(user2);
//        Integer user3_id = userDao.create(user3);
//
//        Integer author1_id = authorDao.create(author1);
//        Integer author2_id = authorDao.create(author2);
//        Integer author3_id = authorDao.create(author3);
//        Integer author4_id = authorDao.create(author4);
//        Integer author5_id = authorDao.create(author5);
//        Integer author6_id = authorDao.create(author6);
//        Integer author7_id = authorDao.create(author7);

        System.out.println("Get all books from DB: ");
        bookDao.getAll().forEach(System.out::println);
        System.out.println("===========================================================");

        System.out.println("Get one book from DB: ");
//        System.out.println(bookDao.read(book4_id));
        System.out.println(bookDao.read(53));
        System.out.println("===========================================================");

        System.out.println("Get all users from DB: ");
//        userDao.getAll().forEach(u->System.out.println(u + " user's books: " + u.getUserBooks()));
        userDao.getAll().forEach(System.out::println);
        System.out.println("===========================================================");

        System.out.println("Get one user from DB: ");
//        System.out.println(userDao.read(user1_id));
        User foundUser = userDao.read(33);
        System.out.println(foundUser + " user's books: " + foundUser.getUserBooks());
        System.out.println("===========================================================");

        System.out.println("Get all authors from DB: ");
//        authorDao.getAll().forEach(a->System.out.println(a + " written books: " + a.getAuthorBooks()));
        authorDao.getAll().forEach(System.out::println);
        System.out.println("===========================================================");

        System.out.println("Get one author from DB: ");
//        System.out.println(authorDao.read(author3_id));
        Author foundAuthor = authorDao.read(69);
        System.out.println(foundAuthor + " written books: " + foundAuthor.getAuthorBooks());
    }
}
