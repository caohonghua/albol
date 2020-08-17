package org.caohh.albol.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        Contact contact = new Contact("caohh", "www.caohh.cn", "1010590379@qq.com");
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("ALBOL")
                .description("A Litter Bit Of Lift")
                .version("1.0")
                .contact(contact)
                .license("The Apache License")
                .build();
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.caohh.albol.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo);
    }

}
