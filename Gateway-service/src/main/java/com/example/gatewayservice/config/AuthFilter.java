package com.example.gatewayservice.config;

import com.example.gatewayservice.Dto.UserDto;
import org.apache.http.HttpHeaders;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.config> {


    private final WebClient.Builder webClientBuilder;

    public AuthFilter(WebClient.Builder webClientBuilder) {
        super(config.class);
        this.webClientBuilder = webClientBuilder;
    }


    @Override
    public GatewayFilter apply(AuthFilter.config config) {

        return ((exchange, chain) ->{
                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                    throw  new RuntimeException("Missing auth information");
                }
                String authHeader=exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                String[] part=authHeader.split(" ");
                if(part.length!=2 || !"Bearer".equals(part[0])){

                    throw new RuntimeException("Incorrect auth structure");
                }
            System.out.println("part 1 ====== "+part[1]);
                return webClientBuilder.build()
                        .post()
                        .uri("http://USER-SERVICE/api/v1/users/validateToken?token="+part[1])
                        .retrieve().bodyToMono(UserDto.class)
                        .map(userDto->{
                            exchange.getRequest()
                                    .mutate()
                                    .header("x-auth-user-email",String.valueOf(userDto.getEmail()));
                            return exchange;
                        }).flatMap(chain::filter);
        });
    }

    public  static class config{

    }
}
