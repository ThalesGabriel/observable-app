package com.example.monitoring.application.user.list;

import com.example.monitoring.application.user.IUserEntity;

import java.time.Instant;

public record ListUsersOutput(String id, String name, String cpf, Boolean isAdm, Instant createdAt, Instant updatedAt, Instant deletedAt) {

  public static ListUsersOutput of(IUserEntity user) {
    return new ListUsersOutput(user.id(), user.name(), user.cpf(), user.isAdm(), user.createdAt(), user.updatedAt(), user.deletedAt());
  }
}