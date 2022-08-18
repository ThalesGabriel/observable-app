package com.example.monitoring.application.user;

import com.example.monitoring.domain.user.IUser;
import com.example.monitoring.shared.notification.INotification;

import java.time.Instant;

public record UserDto(String id, String cpf, Boolean isAdm, String name, Instant createdAt, Instant updatedAt, Instant deletedAt, INotification notification) implements IUserEntity {

  public static UserDto of(String id, String cpf, Boolean isAdm, String name, INotification notification) {
    return new UserDto(id, cpf, isAdm, name, null, null, null, notification);
  }

  public static UserDto of(String id, String cpf, String name, Boolean isAdm) {
    return new UserDto(id, cpf, isAdm, name, null, null, null, null);
  }

  public static UserDto of(IUser iUser) {
    return new UserDto(
            iUser.getIdStr(),
            iUser.getCpfStr(),
            iUser.getAdm(),
            iUser.getName(),
            iUser.getCreatedAt(),
            iUser.getUpdatedAt(),
            iUser.getDeletedAt(),
            iUser.getNotification());
  }

  public static UserDto of(IUserEntity iUserEntity) {
    return new UserDto(iUserEntity.id(), iUserEntity.cpf(), iUserEntity.isAdm(), iUserEntity.name(), iUserEntity.createdAt(), iUserEntity.updatedAt(), iUserEntity.deletedAt(), null);
  }
}
