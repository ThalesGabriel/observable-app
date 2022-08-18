package com.example.monitoring.application.user.find;

import com.example.monitoring.application.user.IUserEntity;
import com.example.monitoring.shared.notification.INotification;
import com.example.monitoring.shared.notification.Notification;
import com.example.monitoring.shared.notification.NotificationErrorProps;

import java.time.Instant;

import static com.example.monitoring.shared.utils.Constants.USER_STR;

public record FindUserByCpfOutput(String id, String name, String cpf, Boolean isAdm, Instant createdAt, Instant updatedAt, Instant deletedAt, INotification notificationErrors) {

  public static FindUserByCpfOutput of(IUserEntity user) {
    return new FindUserByCpfOutput(user.id(), user.name(), user.cpf(), user.isAdm(), user.createdAt(), user.updatedAt(), user.deletedAt(),  null);
  }

  public static FindUserByCpfOutput of(INotification notification) {
    return new FindUserByCpfOutput(null, null, null, null, null, null, null, notification);
  }

  public static FindUserByCpfOutput of(String message) {
    Notification notification = new Notification();
    NotificationErrorProps userAlreadyExists = new NotificationErrorProps(message, USER_STR);
    notification.append(userAlreadyExists);
    return new FindUserByCpfOutput(null, null, null, null, null, null, null, notification);
  }
}