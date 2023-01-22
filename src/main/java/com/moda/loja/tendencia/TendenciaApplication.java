package com.moda.loja.tendencia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TendenciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TendenciaApplication.class, args);
	}

}
