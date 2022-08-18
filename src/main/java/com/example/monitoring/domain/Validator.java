package com.example.monitoring.domain;

public abstract class Validator <T extends Aggregate> {
  public abstract void validate(T object);
}
