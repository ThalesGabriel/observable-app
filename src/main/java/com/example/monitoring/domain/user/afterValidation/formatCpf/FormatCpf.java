package com.example.monitoring.domain.user.afterValidation.formatCpf;

import com.example.monitoring.domain.user.User;
import com.example.monitoring.domain.user.afterValidation.IAfterValidation;

public class FormatCpf implements IAfterValidation<User> {

  public FormatCpf() {}

  @Override
  public void execute(User user) {
    user.formatCpf();
  }

}
