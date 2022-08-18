package com.example.monitoring.application.user.find;

public record FindUserByCpfCommand (String cpf) {

  public static FindUserByCpfCommand of(String cpf) {
    return new FindUserByCpfCommand(cpf);
  }

}
