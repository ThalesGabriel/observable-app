package com.example.monitoring.domain.user;

import com.example.monitoring.domain.Aggregate;
import com.example.monitoring.domain.user.afterValidation.IAfterValidation;
import com.example.monitoring.domain.user.afterValidation.formatCpf.FormatCpf;
import com.example.monitoring.domain.user.cpf.Cpf;
import com.example.monitoring.domain.user.cpf.CpfValidator;
import com.example.monitoring.domain.user.cpf.ICpf;
import com.example.monitoring.shared.notification.INotification;
import com.example.monitoring.shared.notification.Notification;

import java.time.Instant;
import java.util.List;

public class User extends Aggregate<UserId> implements IUser {

  private final String name;
  private ICpf cpf;
  private final Boolean isAdm;
  private final Instant createdAt;
  private final Instant updatedAt;
  private final Instant deletedAt;

  protected User(String id, String name, ICpf cpf, Boolean isAdm, Instant createdAt, Instant updatedAt, Instant deletedAt, INotification notification) {
    super(id == null? UserId.unique() : UserId.from(id), notification);
    this.name = name;
    this.cpf = cpf;
    this.isAdm = isAdm;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.deletedAt = deletedAt;
  }

  public static User of(String name, String cpf, Boolean isAdm) {
    INotification notification = new Notification();
    Cpf cpfObj = Cpf.of(cpf);
    Instant now = Instant.now();
    return new User(null, name, cpfObj, isAdm, now, now, null, notification);
  }

  public static User of(String id, String name, String cpf, Boolean isAdm) {
    INotification notification = new Notification();
    Cpf cpfObj = Cpf.of(cpf);
    Instant now = Instant.now();
    return new User(id, name, cpfObj, isAdm, now, now, null, notification);
  }

  public ICpf getCpf() {
    return cpf;
  }

  @Override
  public String getIdStr() {
    return id.getValue();
  }

  @Override
  public String getCpfStr() {
    return cpf.getValue();
  }

  public String getName() {
    return name;
  }

  public Boolean getAdm() {
    return isAdm;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public Instant getDeletedAt() {
    return deletedAt;
  }

  public void formatCpf() {
    this.cpf = Cpf.format(this.cpf.getValue());
  }

  @Override
  public void validate() {
    List<IAfterValidation<User>> validationHandlers = List.of(new FormatCpf());
    new UserValidator(new CpfValidator(), validationHandlers).validate(this);
  }

  @Override
  public String toString() {
    return "User{" +
            "name='" + name + '\'' +
            ", cpf=" + cpf +
            ", isAdm=" + isAdm +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            ", deletedAt=" + deletedAt +
            ", id=" + id.getValue() +
            '}';
  }
}
