package org.exampledriven.zuul;

import com.netflix.zuul.context.RequestContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class SpringCloudZuulExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuulExampleApplication.class, args);
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
}
