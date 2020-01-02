package com.maxhyeon.ndays.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
//@EnableSwagger2
public class SwaggerConfiguration {
//    @Bean
//    public Docket swaggerApi() {
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(swaggerInfo()).select()
//                .apis(RequestHandlerSelectors.basePackage("com.maxhyeon.ndays.controller"))
//                .paths(PathSelectors.any())
//                .build()
//                .useDefaultResponseMessages(false); // 기본으로 세팅되는 200,401,403,404 메시지를 표시 하지 않음
//    }
//
//    private ApiInfo swaggerInfo() {
//        return new ApiInfoBuilder().title("Spring API Documentation")
//                .description("앱 개발시 사용되는 서버 API에 대한 연동 문서입니다")
//                .license("happydaddy").licenseUrl("http://daddyprogrammer.org").version("1").build();
//    }
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Contact Application API").description(
                        "This is a sample Spring Boot RESTful service using springdoc-openapi and OpenAPI 3."));
    }
}

