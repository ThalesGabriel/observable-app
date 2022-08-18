package com.example.monitoring.domain.user;

import com.example.monitoring.shared.notification.INotification;

import java.time.Instant;

public interface IUser {
  String getIdStr();
  String getCpfStr();
  INotification getNotification();
  Instant getCreatedAt();
  Instant getUpdatedAt();
  Instant getDeletedAt();
  Boolean getAdm();
  String getName();
}
