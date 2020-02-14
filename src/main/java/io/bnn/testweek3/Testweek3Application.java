package io.bnn.testweek3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("io.bnn.testweek3.dao")
@EnableSwagger2
public class Testweek3Application {

    public static void main(String[] args) {
        SpringApplication.run(Testweek3Application.class, args);
    }

}
