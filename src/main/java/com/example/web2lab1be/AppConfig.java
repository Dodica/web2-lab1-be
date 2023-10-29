package com.example.web2lab1be;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver"); // Set your database driver
        dataSource.setUrl("jdbc:postgresql://localhost:5432/web2-lab1"); // Set your database URL
        dataSource.setUsername("postgres"); // Set your database username
        dataSource.setPassword("bazepodataka"); // Set your database password
        return dataSource;
    }
}
