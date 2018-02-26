package cn.boot.onlyo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("cn.boot.onlyo.dao")
@EnableAutoConfiguration
@ImportResource({ "classpath:spring-shiro.xml" })
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
