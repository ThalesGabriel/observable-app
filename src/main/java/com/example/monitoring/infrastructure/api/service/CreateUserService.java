package com.example.monitoring.infrastructure.api.service;

import com.example.monitoring.application.user.create.CreateUserCommand;
import com.example.monitoring.application.user.create.CreateUserOutput;
import com.example.monitoring.application.user.create.CreateUserUseCase;
import com.example.monitoring.shared.log.ILog;
import com.example.monitoring.shared.log.Log;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {

  private final CreateUserUseCase useCase;

  private static final ObjectMapper mapper = new ObjectMapper();

  private static final ILog log = new Log(CreateUserService.class);

  public CreateUserService(CreateUserUseCase useCase) {
    this.useCase = useCase;
  }

  public CreateUserOutput execute(String name, String cpf, Boolean isAdm) throws JsonProcessingException {
    final var command = CreateUserCommand.of(name, cpf, isAdm);

    return this.useCase.execute(command);
  }
}
