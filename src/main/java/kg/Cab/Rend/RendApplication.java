package kg.Cab.Rend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("kg.Cab.Rend.microservice")
@EnableDiscoveryClient
public class RendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RendApplication.class, args);
    }

}
