package altria.blog_server.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Blog Platform API")
                        .description("API documentation for the Blog Platform backend.")
                        .version("1.0.0"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("blog-user")
                .packagesToScan("altria.blog_server.controller.user")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group("blog-admin")
                .packagesToScan("altria.blog_server.controller.admin")
                .pathsToMatch("/**")
                .build();
    }
}
