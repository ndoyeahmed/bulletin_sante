package com.bulletin.sante.bulletinsante.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final String CLIENT_SECRET = "secret";
    private static final String CLIENT_ID = "1";
    private static final String AUTH_SERVER = "/";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Bulletin de sante REST API",
                "API de gestion des consultations et rendez-vous des patients.",
                "API 1.0",
                "Open source",
                new Contact("Mouhamed NDOYE", "www.example.com", "ndoyeahmed2602@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}