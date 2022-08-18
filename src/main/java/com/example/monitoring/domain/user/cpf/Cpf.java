package com.example.monitoring.domain.user.cpf;

import com.example.monitoring.domain.ValueObject;

import java.util.Objects;

public class Cpf extends ValueObject implements ICpf {

  private final String value;

  private Cpf(String value) {
    this.value = value;
  }

  public static Cpf of(String value) {
    return new Cpf(value);
  }

  public static Cpf format(String value) {
    return new Cpf(value.trim().replaceAll("[^\\d ]", ""));
  }

  @Override
  public String getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cpf cpf = (Cpf) o;
    return getValue().equals(cpf.getValue());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getValue());
  }

  @Override
  public String toString() {
    return "Cpf{" +
            "value='" + value + '\'' +
            '}';
  }
}
