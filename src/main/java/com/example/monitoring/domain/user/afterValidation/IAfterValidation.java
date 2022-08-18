package com.example.monitoring.domain.user.afterValidation;

public interface IAfterValidation<T> {
  void execute(T object);
}
