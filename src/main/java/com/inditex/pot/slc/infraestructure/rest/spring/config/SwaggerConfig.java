package com.inditex.pot.slc.infraestructure.rest.spring.config;

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

/**
 * Configuration class, to manage swagger configuration
 *
 * @author slc
 * @since 1.0.0
 */
//@Configuration
//@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return
            new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.inditex.pot.slc.infraestructure.rest.spring.controller"))
                .paths(PathSelectors.any())
                .build()
                .groupName("InditexPoT")
                .apiInfo( apiInfo() );
    }

    private ApiInfo apiInfo() {
        return
            new ApiInfo(
                "API Inditex" ,
                "API to obtain product prices of Inditex products",
                "1.0.0",
                "",
                new Contact(
                        "Inditext PoT",
                        "http://www.inditext.com",
                        ""),
                "",
                "",
                Collections.emptyList());
    }

}
