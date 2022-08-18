package com.example.monitoring.shared.notification;

import java.util.ArrayList;

public class Notification implements INotification {

  private ArrayList<NotificationErrorProps> errors = new ArrayList<NotificationErrorProps>();

  @Override
  public void append(NotificationErrorProps error) {
    this.errors.add(error);
  }

  @Override
  public void append(String message, String context) {
    this.errors.add(new NotificationErrorProps(message, context));
  }

  @Override
  public boolean hasErrors() {
    return this.errors.size() > 0;
  }

  @Override
  public ArrayList<NotificationErrorProps> getErrors() {
    return this.errors;
  }

  @Override
  public String messages(String context) {
    String message = "";
    for (NotificationErrorProps error: this.errors) {
      if (context.isEmpty() || error.context().equals(context))
        message = message.concat(String.format("[%s]: %s", error.context(), error.message()));
    }
    return message;
  }
}
