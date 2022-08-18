package com.example.monitoring.domain.user;

import com.example.monitoring.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

public class UserId extends Identifier {

  private final String value;

  public UserId(String value) {
    this.value = Objects.requireNonNull(value);
  }

  public static UserId unique() {
    return UserId.from(UUID.randomUUID());
  }

  public static UserId from(String id) {
    return new UserId(id);
  }

  public static UserId from(UUID id) {
    return new UserId(id.toString().toLowerCase());
  }

  public String getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserId userID = (UserId) o;
    return getValue().equals(userID.getValue());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getValue());
  }

  @Override
  public String toString() {
    return "UserId{" +
            "value='" + value + '\'' +
            '}';
  }
}