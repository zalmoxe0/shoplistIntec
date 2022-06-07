package com.example.shoplist.config.dataSource;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    public DataSource getDataSource(){
        DataSource dataSource = null;

        DataSourceBuilder builder = DataSourceBuilder.create();

        builder.url("jdb:mysql://localhost:3306/eshoplistdb");
        builder.username("alecs");
        builder.password("meh");
        builder.driverClassName("com.mysql.jdbc.Driver");

        dataSource = builder.build();

        return dataSource;





    }

}
