package tech.jitao.dubbodemo.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jitao.dubbodemo.service.util.crypto.bcrypt.BCryptPasswordEncoder;
import tech.jitao.dubbodemo.service.util.crypto.password.PasswordEncoder;

@Configuration
public class ServiceConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
