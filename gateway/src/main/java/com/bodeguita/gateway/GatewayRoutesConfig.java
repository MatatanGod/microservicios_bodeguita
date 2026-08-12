package com.bodeguita.gateway;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.stripPrefix;
import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.uri;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;

@Configuration
public class GatewayRoutesConfig {

    RouterFunction<ServerResponse> gatewayRoutes() {

        return route("ms-venta_routes")
                .GET("ms-ventas/v1/**", http())
                .POST("ms-ventas/v1/**", http())
                .DELETE("ms-ventas/v1/**", http())
                .PUT("ms-ventas/v1/**", http())
                .before(uri("http://localhost:8081"))
                .before(stripPrefix(1))
                .build()

                .and(route("ms-proveedor_routes")
                        .GET("ms-proveedor/v1/**", http())
                        .POST("ms-proveedor/v1/**", http())
                        .PUT("ms-proveedor/v1/**", http())
                        .DELETE("ms-proveedor/v1/**", http())
                        .before(uri("http://localhost:8083"))
                        .before(stripPrefix(1))
                        .build())

                .and(route("ms-producto_routes")
                        .GET("ms-producto/v1/**", http())
                        .POST("ms-producto/v1/**", http())
                        .PUT("ms-producto/v1/**", http())
                        .DELETE("ms-producto/v1/**", http())
                        .before(uri("http://localhost:8085"))
                        .before(stripPrefix(1))
                        .build())

                .and(route("ms-detalleventa_routes")
                        .GET("ms-detalleventa/v1/**", http())
                        .POST("ms-detalleventa/v1/**", http())
                        .DELETE("ms-detalleventa/v1/**", http())
                        .before(uri("http://localhost:8086"))
                        .before(stripPrefix(1))
                        .build())

                .and(route("ms-categoria_routes")
                        .GET("ms-categoria/v1/**", http())
                        .POST("ms-categoria/v1/**", http())
                        .DELETE("ms-categoria/v1/**", http())
                        .before(uri("http://localhost:8087"))
                        .before(stripPrefix(1))
                        .build());
    }
}