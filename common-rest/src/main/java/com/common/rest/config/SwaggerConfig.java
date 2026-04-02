package com.common.rest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Value("${api.contact.name}")
    private String contactName;

    @Value("${api.contact.url}")
    private String contactUrl;

    @Value("${swagger.title}")
    private String swaggerTitle;

    @Value("${swagger.description}")
    private String swaggerDescription;

    @Bean
    public OpenAPI customOpenAPI(@Value("${api.version}") String appVersion) {
        Contact contact = new Contact();
        contact.setName(contactName);
        contact.setUrl(contactUrl);
        return new OpenAPI()
                .info(
                        new Info()
                                .title(swaggerTitle).version(appVersion)
                                .contact(contact)
                                .description(swaggerDescription)
                                .license(new License()
                                        .name("Apache 2.0")
                                        .url("https://www.apache.org/licenses/LICENSE-2.0")
                                )
                );
    }
}
