package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // Server URL (use your application port)
                .servers(List.of(
                        new Server().url("https://9133.pro604cr.amypo.ai/")
                ))
                .info(new Info()
                        .title("Asset Lifecycle Tracking API")
                        .version("1.0")
                        .description(
                                "API documentation for Asset Lifecycle Tracking system " +
                                "including assets, vendors, depreciation rules, lifecycle events, and disposals"
                        ));
    }
}
