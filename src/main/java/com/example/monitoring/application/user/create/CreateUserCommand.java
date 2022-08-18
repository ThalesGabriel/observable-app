package com.example.monitoring.application.user.create;

public record CreateUserCommand(String name, String cpf, Boolean isAdm) {

  public static CreateUserCommand of(String name, String cpf, Boolean isAdm) {
    return new CreateUserCommand(name, cpf, isAdm);
  }

}