package org.library;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Properties;

@Configuration
@ComponentScan("org.library")
@PropertySource(value = {"classpath:application.properties"})
public class MyConfig {

    @Bean
    public Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.connection.driver_class", "${hibernate.connection.driver_class}");
//        properties.put("spring.jpa.database-platform", "${spring.jpa.database-platform}");
        properties.put("hibernate.dialect", "${hibernate.dialect}");
        properties.put("hibernate.connection.url", "${hibernate.connection.url}");
        properties.put("hibernate.connection.username", "${hibernate.connection.username}");
        properties.put("hibernate.connection.password", "${hibernate.connection.password}");
        properties.put("hibernate.show_sql", "${hibernate.show_sql}");
        properties.put("hibernate.hbm2ddl.auto", "${hibernate.hbm2ddl.auto}");
        properties.put("hibernate.entitymanager.packages.to.scan", "${hibernate.entitymanager.packages.to.scan}");
        return properties;
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration()
                .addProperties(getHibernateProperties()).buildSessionFactory();
    }
}
