package com.zyj.druiddemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Slf4j
public class DruidDemoApplication implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DruidDemoApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        log.info(dataSource.toString());

        showData();
    }

    public void showData() {
        jdbcTemplate.queryForList("select * from word_info").forEach(row -> System.out.println(row.toString()));
    }
}
