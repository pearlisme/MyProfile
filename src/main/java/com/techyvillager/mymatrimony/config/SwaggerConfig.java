package com.techyvillager.mymatrimony.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

/**
 * @author pearl
 */
@SuppressWarnings("WeakerAccess")
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * @return
     */
    @Bean
    public Docket profileAPI(){
        return new Docket(DocumentationType.SWAGGER_2)
        .select().apis(RequestHandlerSelectors.basePackage("com.techyvillager.mymatrimony.controller"))
        .build()
        .apiInfo(metaData());
    }

    /**
     * @return
     */
    private ApiInfo metaData() {

        return new ApiInfo("Profile Application",
                "Maintain Profiles",
                "1.0",
                "tos",
                new Contact("Admin","","admin@gmail.com"),
                "",
                "",
                Arrays.asList());
    }
}
