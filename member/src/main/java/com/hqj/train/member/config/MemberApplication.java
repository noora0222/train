package com.hqj.train.member.config;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan("com.hqj")
public class MemberApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MemberApplication.class);
        app.run(args);

    }
}
