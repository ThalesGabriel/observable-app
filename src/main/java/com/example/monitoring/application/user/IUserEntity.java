package com.example.monitoring.application.user;

import com.example.monitoring.shared.notification.INotification;

import java.time.Instant;

public interface IUserEntity {
  String name();
  String cpf();
  String id();
  Boolean isAdm();

  Instant createdAt();
  Instant updatedAt();
  Instant deletedAt();
  INotification notification();

  String toString();
}
