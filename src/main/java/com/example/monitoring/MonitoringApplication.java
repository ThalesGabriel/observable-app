package com.example.monitoring;

import com.example.monitoring.infrastructure.config.WebServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MonitoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServerConfig.class, args);
	}

}

// TODO melhorar gráfico do grafana com informações úteis e não genéricas.
// TODO Centralizar logs
// TODO Configurar k8s
// TODO Melhorar health check
// TODO API Gateway - Kong
// TODO Service mesh ou Event mesh
// TODO configurar Sonarcloud
// TODO configurar GitLab CI/CD
// TODO Teste de performance com fortio
// TODO Deploy em algum lugar que aceite o k8s gratuitamente
