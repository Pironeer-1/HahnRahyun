package com.pironeer.week2.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Pironeer Week2 API 명세서",
                description = "API 명세서",
                version = "v1",
                contact = @Contact(
                        name = "한라현",
                        email = "hanrahyun@naver.com"
                )
        )
)
@Configuration
public class OpenApiConfig {
}
