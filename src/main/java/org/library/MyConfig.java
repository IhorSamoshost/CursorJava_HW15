package org.library;

import org.hibernate.SessionFactory;
import org.library.entities.Author;
import org.library.entities.Book;
import org.library.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Properties;

@Configuration
@ComponentScan("org.library")
@PropertySource(value = {"classpath:application.properties"})
public class MyConfig {

    @Bean
    public Properties getHibernateProperties(Environment environment) {
        Properties properties = new Properties();
        properties.put("hibernate.connection.driver_class", environment.getProperty("hibernate.connection.driver_class"));
        properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.put("hibernate.connection.url", environment.getProperty("hibernate.connection.url"));
        properties.put("hibernate.connection.username", environment.getProperty("hibernate.connection.username"));
        properties.put("hibernate.connection.password", environment.getProperty("hibernate.connection.password"));
        properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.entitymanager.packages.to.scan", environment.getProperty("hibernate.entitymanager.packages.to.scan"));
        return properties;
    }

    @Bean
    public SessionFactory sessionFactory(Properties getHibernateProperties) {
        return new org.hibernate.cfg.Configuration()
                .addProperties(getHibernateProperties)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Author.class)
                .buildSessionFactory();
    }
}
