package com.example.monitoring.infrastructure.api.request;

public record CreateUserRequest(String name, String cpf, boolean isAdm) {
  public static CreateUserRequest of(String name, String cpf, boolean isAdm) {
    return new CreateUserRequest(name, cpf, isAdm);
  }
}
