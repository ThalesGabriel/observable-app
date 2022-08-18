package com.example.monitoring.infrastructure.config;

import com.example.monitoring.application.user.create.CreateUserUseCase;
import com.example.monitoring.application.user.find.FindUserByCpfUseCase;
import com.example.monitoring.application.user.list.ListUsersUseCase;
import com.example.monitoring.infrastructure.gateway.mongo.UserGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfig {

  private final UserGateway userGateway;

  public ContextConfig(UserGateway userGateway) {
    this.userGateway = userGateway;
  }

  @Bean
  public FindUserByCpfUseCase findUserByCpfUseCase() {
    return FindUserByCpfUseCase.of(this.userGateway);
  }

  @Bean
  public CreateUserUseCase createUserUseCase() {
    return CreateUserUseCase.of(this.userGateway, findUserByCpfUseCase());
  }

  @Bean
  public ListUsersUseCase listUsersUseCase() {
    return ListUsersUseCase.of(this.userGateway);
  }
}
