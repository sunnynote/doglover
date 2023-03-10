package com.mytest.doglover.configure;

import com.fasterxml.classmate.TypeResolver;
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
public class SwaggerConfiguration {

  @Bean
  public Docket api(){
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .paths(PathSelectors.any())
            .apis(RequestHandlerSelectors.basePackage("com.mytest.doglover.controller"))
            .build()
            .apiInfo(apiInfo())
            .useDefaultResponseMessages(false);
  }

  private ApiInfo apiInfo(){
    return new ApiInfoBuilder()
            .title("Dog Lover-SERVER")
            .description("Dog Lover-SERVER 입니다.")
            .contact(new Contact("sunny", null, "sunny@sunny.com"))
            .license("LICENSE")
            .termsOfServiceUrl("https://github.com/sunnynote/doglover.git")
            .version("1.0.0")
            .build();
  }
}
