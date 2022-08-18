package com.example.monitoring.application.user.create;

import com.example.monitoring.application.user.IUserEntity;
import com.example.monitoring.shared.notification.INotification;
import com.example.monitoring.shared.notification.Notification;

import java.time.Instant;

import static com.example.monitoring.shared.utils.Constants.USER_STR;

public record CreateUserOutput(String id, String name, String cpf, Boolean isAdm, Instant createdAt, Instant updatedAt, Instant deletedAt, INotification notificationErrors) {

  public static CreateUserOutput of(IUserEntity user) {
    return new CreateUserOutput(user.id(), user.name(), user.cpf(), user.isAdm(), user.createdAt(), user.updatedAt(), user.deletedAt(), null);
  }

  public static CreateUserOutput of(INotification notification) {
    return new CreateUserOutput(null, null, null, null, null, null, null, notification);
  }

  public static CreateUserOutput of() {
    return new CreateUserOutput(null, null, null, null, null, null, null, null);
  }

  public static CreateUserOutput of(String message) {
    INotification notification = new Notification();
    notification.append(message, USER_STR);
    return new CreateUserOutput(null, null, null, null, null, null, null, notification);
  }
}