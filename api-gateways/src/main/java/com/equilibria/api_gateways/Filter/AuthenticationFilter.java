package com.equilibria.api_gateways.Filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import com.equilibria.api_gateways.Util.JwtUtil;


@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config>  {


     @Autowired
    private RouteValidator validator;

    //    @Autowired
//    private RestTemplate template;
    @Autowired
    private JwtUtil jwtUtil;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            if (validator.isSecured.test(exchange.getRequest())) {
                //header contains token or not
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("missing authorization header");
                }
                List<String> authHeaders = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION);
                if (authHeaders == null || authHeaders.isEmpty()) {
                    throw new RuntimeException("Authorization header is empty");
                }
                String authHeader = authHeaders.get(0);

                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
                }else {
                    throw new RuntimeException("Invalid Authorization header format");
                }
                try {
//                    //REST call to AUTH service
//                    template.getForObject("http://IDENTITY-SERVICE//validate?token" + authHeader, String.class);
                    jwtUtil.validateToken(authHeader);

                } catch (Exception e) {
                    System.out.println("invalid access...!");
                    throw new RuntimeException("un authorized access to application");
                }
            }
            return chain.filter(exchange);
        });
    }


    public static class Config {

    }
}
