package com.example.monitoring.infrastructure.api.service;

import com.example.monitoring.application.user.find.FindUserByCpfCommand;
import com.example.monitoring.application.user.find.FindUserByCpfOutput;
import com.example.monitoring.application.user.find.FindUserByCpfUseCase;
import org.springframework.stereotype.Service;

@Service
public class FindUserByCpfService {

  private final FindUserByCpfUseCase useCase;

  public FindUserByCpfService(FindUserByCpfUseCase useCase) {
    this.useCase = useCase;
  }

  public FindUserByCpfOutput execute(String cpf) {
    final var command = FindUserByCpfCommand.of(cpf);
    return this.useCase.execute(command);
  }
}
