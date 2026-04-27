package se.jensen.charitha.ccp.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.customizers.OpenApiCustomizer;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI ccpOpenApi() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("SafeTrack API")
                        .description("API documentation for the CCP application")
                        .version("v1"));
    }

    @Bean
    public OpenApiCustomizer openApiBasicAuthCustomizer() {
        return openApi -> {
            if (openApi.getPaths() == null) {
                return;
            }

            openApi.getPaths().forEach((path, pathItem) -> {
                if ("/users/login".equals(path)) {
                    return;
                }

                Stream.of(
                                pathItem.getGet(),
                                pathItem.getPut(),
                                pathItem.getPost(),
                                pathItem.getDelete(),
                                pathItem.getOptions(),
                                pathItem.getHead(),
                                pathItem.getPatch(),
                                pathItem.getTrace()
                        )
                        .filter(Objects::nonNull)
                        .forEach(operation -> operation.addSecurityItem(
                                new SecurityRequirement().addList("bearerAuth")
                        ));
            });
        };
    }

    @Bean
    public OpenApiCustomizer openApiPageableSortCustomizer() {
        return openApi -> {
            if (openApi.getPaths() == null) {
                return;
            }

            openApi.getPaths().values().forEach(pathItem -> Stream.of(
                            pathItem.getGet(),
                            pathItem.getPut(),
                            pathItem.getPost(),
                            pathItem.getDelete(),
                            pathItem.getOptions(),
                            pathItem.getHead(),
                            pathItem.getPatch(),
                            pathItem.getTrace()
                    )
                    .filter(Objects::nonNull)
                    .forEach(operation -> {
                        if (operation.getParameters() == null) {
                            return;
                        }

                        operation.getParameters().stream()
                                .filter(parameter -> "sort".equals(parameter.getName()))
                                .forEach(parameter -> {
                                    if (parameter.getSchema() != null) {
                                        parameter.getSchema().setDefault(List.of());
                                        parameter.getSchema().setExample(List.of());
                                    }

                                    if (parameter.getDescription() == null || parameter.getDescription().isBlank()) {
                                        parameter.setDescription("Repeat `sort` like `sort=username,asc`.");
                                    }
                                });
                    }));
        };
    }
}
