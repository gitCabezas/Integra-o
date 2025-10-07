package com.projetolivro.gerenciador_autores_obras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
	org.springframework.boot.actuate.autoconfigure.metrics.SystemMetricsAutoConfiguration.class
})
public class GerenciadorAutoresObrasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorAutoresObrasApplication.class, args);
	}

}
