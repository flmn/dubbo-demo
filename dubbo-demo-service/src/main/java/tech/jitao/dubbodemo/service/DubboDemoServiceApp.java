package tech.jitao.dubbodemo.service;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "tech.jitao.dubbodemo.service.service")
public class DubboDemoServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(DubboDemoServiceApp.class, args);
    }
}
