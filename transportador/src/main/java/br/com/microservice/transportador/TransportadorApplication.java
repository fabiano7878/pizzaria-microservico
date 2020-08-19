package br.com.microservice.transportador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class TransportadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransportadorApplication.class, args);
	}

}
