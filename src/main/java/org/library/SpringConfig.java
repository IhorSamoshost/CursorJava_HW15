package org.library;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("org.library")
@PropertySource(value = {"classpath:application.properties"})
public class SpringConfig {

    @Bean
    public org.hibernate.SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration().buildSessionFactory();
    }

//    @Bean
//    SessionFactory getSessionFactory() {
//        SessionFactory sessionFactory = null;
//        try {
//            org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
//            configuration.configure();
//            sessionFactory = configuration.buildSessionFactory();
//        } catch (Throwable e) {
//            System.out.println("Something goes wrong " + e);
//        }
//        return sessionFactory;
//    }

}
