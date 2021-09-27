package kg.Cab.Rend.configuretions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    public static final String CAR = "Cars";
    public static final String CAR_DESCRIPTION = "Car_description";
    public static final String CATEGORY_CAR = "Category_car";
    public static final String LOCATION_REND = "Location_rend";
    public static final String USER = "User";
    public static final String ORDER = "Order";
    public static final String REND_PRICE = "Rend_price";
    public static final String WALLET_USER = "Wallet_users";


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("kg.Cab.Rend.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiEndPointsInfo())
                .tags(new Tag(CAR, ""))
                .tags(new Tag(CAR_DESCRIPTION,""))
                .tags(new Tag(CATEGORY_CAR,""))
                .tags(new Tag(LOCATION_REND ,""))
                .tags(new Tag(USER, ""))
                .tags(new Tag(WALLET_USER,""))
                .tags(new Tag(ORDER, ""))
                .tags(new Tag(REND_PRICE, ""));
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("")
                .description("Бэкенд для каршеринга")
                .version("1.0.0")
                .contact(new Contact("Denis kim", "http://www.megacom.kg", "kimden57@gmail.com"))
                .build();
    }
}

