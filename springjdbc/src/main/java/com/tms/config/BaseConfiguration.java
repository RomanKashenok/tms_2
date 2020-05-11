package com.tms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:database.properties")
public class BaseConfiguration {

    @Autowired
    private Environment environment;

//    @Bean
//    DataSource getDataSource() {
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//                ds.setUrl("jdbc:mysql://localhost:3306/lesson4");
//                ds.setUsername("lesson4");
//                ds.setPassword("lesson4");
//                return ds;
//    }

    @Bean
    DataSource getDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(environment.getProperty("url"));
        ds.setUsername(environment.getProperty("login"));
        ds.setPassword(environment.getProperty("password"));
        return ds;
    }

    @Bean
    JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
