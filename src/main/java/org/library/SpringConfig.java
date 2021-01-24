package org.library;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;

@Configuration
@ComponentScan("org.library")
@PropertySource(value = {"classpath:application.properties"})
public class SpringConfig {

//    @Value("${db.url}")
//    private String url;
//    @Value("${db.user}")
//    private String user;
//    @Value("${db.password}")
//    private String password;

//    @Bean
//    public org.hibernate.SessionFactory sessionFactory() {
//        return new org.hibernate.cfg.Configuration().buildSessionFactory();
//    }

//    @Bean
//    SessionFactory getSessionFactory() {
//        SessionFactory sessionFactory = null;
//        try {
//            org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
////            configuration.configure();
//            sessionFactory = configuration.buildSessionFactory();
//        } catch (Throwable e) {
//            System.out.println("Something goes wrong " + e);
//        }
//        return sessionFactory;
//    }

//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan("org.library.entities");
//        sessionFactory.setHibernateProperties(hibernateProperties());
//        return sessionFactory;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("sa");
//
//        return dataSource;
//    }
}
