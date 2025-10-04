package com.study.MongoSpring.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MongoSpring REST API")
                        .description("Spring Boot + MongoDB 기반 REST API 문서입니다.")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("박민준")
                                .email("example@email.com")
                                .url("https://github.com/mj4863")))
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("로컬 서버")
                ));
    }
}
