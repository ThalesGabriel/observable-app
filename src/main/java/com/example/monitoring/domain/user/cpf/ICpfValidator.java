package com.example.monitoring.domain.user.cpf;


import com.example.monitoring.shared.notification.INotification;

public interface ICpfValidator {

  // https://gist.github.com/igorcosta/3a4caa954a99035903ab
  String CPF_REGEX = "[0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}[-]?[0-9]{2}";
  public abstract void validate(ICpf cpf, INotification notification);

}
