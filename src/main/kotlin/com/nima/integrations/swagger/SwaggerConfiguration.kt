package com.nima.integrations.swagger

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import java.util.Collections

@Configuration
class SwaggerConfiguration {

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.nima.integrations"))
            .build()
            .apiInfo(this.apiDetail())
    }

    private fun apiDetail(): ApiInfo {
        return ApiInfo(
            "Integrations with external apis",
            "Demo for training basic kotlin for backend",
            "1.0.0",
            "Free to use",
            Contact("Nima Abdollahi", "url", "a@b.com"),
            "APi Licence",
            "Licence Url",
            Collections.emptyList()
        )
    }
}