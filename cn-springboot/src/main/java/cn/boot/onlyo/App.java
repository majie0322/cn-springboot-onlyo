package cn.boot.onlyo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.boot.onlyo.dao")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
