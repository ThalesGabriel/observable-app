package com.example.monitoring.domain;

import com.example.monitoring.shared.notification.INotification;

public abstract class Aggregate<ID extends Identifier> extends Entity<ID> {

  private final INotification notification;

  protected Aggregate(ID id, INotification notification) {
    super(id);
    this.notification = notification;
  }

  public INotification getNotification() {
    return notification;
  }

  public abstract void validate();


}
