package org.exampledriven.sidecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@SpringBootApplication
@EnableSidecar
public class SampleSidecarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleSidecarApplication.class, args);
	}
}