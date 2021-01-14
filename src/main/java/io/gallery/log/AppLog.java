package io.gallery.log;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(value = {"io.gallery.db.mapper"})
@ComponentScan({"io.gallery"})
public class AppLog {
    public static void main(String[] args) {
        SpringApplication.run(AppLog.class, args);
    }
}
