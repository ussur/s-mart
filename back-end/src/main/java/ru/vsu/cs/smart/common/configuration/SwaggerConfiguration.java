package ru.vsu.cs.smart.common.configuration;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static org.assertj.core.util.Lists.newArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET,
                        newArrayList(
                                new ResponseMessageBuilder().code(500)
                                        .message("Internal Server Error")
                                        .responseModel(new ModelRef("string"))
                                        .build(),
                                new ResponseMessageBuilder().code(403)
                                        .message("Access Denied")
                                        .responseModel(new ModelRef("string"))
                                        .build(),
                                new ResponseMessageBuilder().code(401)
                                        .message("Unauthorized")
                                        .responseModel(new ModelRef("string"))
                                        .build(),
                                new ResponseMessageBuilder().code(404)
                                        .message("Resource Not Found")
                                        .responseModel(new ModelRef("string"))
                                        .build()))
                .globalResponseMessage(RequestMethod.POST,
                        newArrayList(
                                new ResponseMessageBuilder().code(500)
                                        .message("Internal Server Error")
                                        .responseModel(new ModelRef("string"))
                                        .build(),
                                new ResponseMessageBuilder().code(403)
                                        .message("Access Denied")
                                        .responseModel(new ModelRef("string"))
                                        .build(),
                                new ResponseMessageBuilder().code(401)
                                        .message("Unauthorized")
                                        .responseModel(new ModelRef("string"))
                                        .build(),
                                new ResponseMessageBuilder().code(404)
                                        .message("Resource Not Found")
                                        .responseModel(new ModelRef("string"))
                                        .build()))
                .globalResponseMessage(RequestMethod.PUT,
                        newArrayList(
                                new ResponseMessageBuilder().code(500)
                                        .message("Internal Server Error")
                                        .responseModel(new ModelRef("string"))
                                        .build(),
                                new ResponseMessageBuilder().code(403)
                                        .message("Access Denied")
                                        .responseModel(new ModelRef("string"))
                                        .build(),
                                new ResponseMessageBuilder().code(401)
                                        .message("Unauthorized")
                                        .responseModel(new ModelRef("string"))
                                        .build(),
                                new ResponseMessageBuilder().code(404)
                                        .message("Resource Not Found")
                                        .responseModel(new ModelRef("string"))
                                        .build()))
                .globalResponseMessage(RequestMethod.DELETE,
                        newArrayList(
                                new ResponseMessageBuilder().code(500)
                                        .message("Internal Server Error")
                                        .responseModel(new ModelRef("string"))
                                        .build(),
                                new ResponseMessageBuilder().code(403)
                                        .message("Access Denied")
                                        .responseModel(new ModelRef("string"))
                                        .build(),
                                new ResponseMessageBuilder().code(401)
                                        .message("Unauthorized")
                                        .responseModel(new ModelRef("string"))
                                        .build(),
                                new ResponseMessageBuilder().code(404)
                                        .message("Resource Not Found")
                                        .responseModel(new ModelRef("string"))
                                        .build()))
                .select()
                .apis(Predicates.not(
                        RequestHandlerSelectors.basePackage("org.springframework.boot")
                ))
                .paths(Predicates.not(PathSelectors.regex("/oauth.*")))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("S-Mart API")
                .description("Здесь задокументирован API приложения S-Mart. Все запросы к API анонимны.")
                .version("0.0.1-SNAPSHOT")
                .build();
    }
}
