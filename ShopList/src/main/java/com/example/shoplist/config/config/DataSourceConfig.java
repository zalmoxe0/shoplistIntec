package com.example.shoplist.config.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Date;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource() {
        DataSource dataSource = null;

        // create data source object

        DataSourceBuilder builder = DataSourceBuilder.create();

        builder.url("jdbc:mysql://localhost:3306/eshoplistsdb");
        builder.username("alecs");
        builder.password("meh");
        builder.driverClassName("com.mysql.jdbc.Driver");

        dataSource = builder.build();

        return dataSource;

    }
}

