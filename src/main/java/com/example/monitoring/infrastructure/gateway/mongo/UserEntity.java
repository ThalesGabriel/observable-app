package com.example.monitoring.infrastructure.gateway.mongo;

import com.example.monitoring.application.user.IUserEntity;
import com.example.monitoring.application.user.UserDto;
import com.example.monitoring.shared.notification.INotification;
import org.springframework.data.annotation.Id;

import java.time.Instant;

public class UserEntity implements IUserEntity {

  @Id
  private String id;
  private String cpf;
  private String name;
  private Boolean isAdm;
  private Instant created_at;
  private Instant updated_at;
  private Instant deleted_at;

  private UserEntity() {
  }

  private UserEntity(String id, String cpf, String name, Boolean isAdm, Instant created_at, Instant updated_at, Instant deleted_at) {
    this.id = id;
    this.cpf = cpf;
    this.name = name;
    this.isAdm = isAdm;
    this.created_at = created_at;
    this.updated_at = updated_at;
    this.deleted_at = deleted_at;
  }

  public static UserEntity of(IUserEntity iUserEntity) {
    return new UserEntity(
            iUserEntity.id(),
            iUserEntity.cpf(),
            iUserEntity.name(),
            iUserEntity.isAdm(),
            iUserEntity.createdAt(),
            iUserEntity.updatedAt(),
            iUserEntity.deletedAt());
  }

  public UserDto toAggregate() {
    return UserDto.of(this);
  }

  @Override
  public String name() {
    return this.name;
  }

  @Override
  public String cpf() {
    return this.cpf;
  }

  @Override
  public String id() {
    return this.id;
  }

  @Override
  public Boolean isAdm() {
    return this.isAdm;
  }

  @Override
  public Instant createdAt() {
    return this.created_at;
  }

  @Override
  public Instant updatedAt() {
    return this.updated_at;
  }

  @Override
  public Instant deletedAt() {
    return this.deleted_at;
  }

  @Override
  public INotification notification() {
    return null;
  }

  @Override
  public String toString() {
    return "UserJpaEntity{" +
            "id='" + id + '\'' +
            ", cpf='" + cpf + '\'' +
            ", name='" + name + '\'' +
            ", isAdm=" + isAdm +
            ", created_at=" + created_at +
            ", updated_at=" + updated_at +
            ", deleted_at=" + deleted_at +
            '}';
  }
}
