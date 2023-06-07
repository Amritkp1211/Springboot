package com.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerApplication.class, args);
	}
	
	@Bean
   public Docket myApi() {
	   return new Docket(DocumentationType.SWAGGER_2).select()
			   .apis(RequestHandlerSelectors.basePackage("com"))
			   .build()
			   .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
    	
    	//ApiInfo ap = new ApiInfo("21-spring-tue-sat-sun", "dummy rest api", "1",
    	        //"www.tos.com","Tejas Shah", "Apache 2.0", "www.apache.com");
    	ApiInfo ap=new ApiInfo("21-spring-tue-sat-sun", "dummy rest api", "1",
    			                  "www.tos.com","Amrit", "Apache 2.0", "www.apache.com");
	//http://localhost:8080/swagger-ui.html#/
    	return ap;
    	
    }
   }
