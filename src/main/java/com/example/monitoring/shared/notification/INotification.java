package com.example.monitoring.shared.notification;

import java.util.ArrayList;

public interface INotification {
  void append(NotificationErrorProps error);
  void append(String message, String context);
  boolean hasErrors();
  ArrayList<NotificationErrorProps> getErrors();
  String messages(String context);
}