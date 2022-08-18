package com.example.monitoring.domain.user;

import com.example.monitoring.domain.Validator;
import com.example.monitoring.domain.user.afterValidation.IAfterValidation;
import com.example.monitoring.domain.user.cpf.ICpfValidator;

import java.util.List;

import static com.example.monitoring.shared.utils.Constants.*;
import static com.example.monitoring.shared.utils.ErrorConstants.*;

public class UserValidator extends Validator<User> {

  private final ICpfValidator cpfValidator;

  private final List<IAfterValidation<User>> validationHandlers;

  public UserValidator(ICpfValidator cpfValidator, List<IAfterValidation<User>> validationHandlers) {
    this.cpfValidator = cpfValidator;
    this.validationHandlers = validationHandlers;
  }

  @Override
  public void validate(User user) {
    this.checkNameConstraints(user);

    this.cpfValidator.validate(user.getCpf(), user.getNotification());

    if(!user.getNotification().hasErrors())
      this.validationHandlers.forEach(handler -> handler.execute(user));
  }

  private void checkNameConstraints(User user) {
    if (user.getName() == null) {
      user.getNotification().append(STRING_SHOULD_NOT_BE_NULL.replace("{}", NAME_STR), USER_STR);
      return;
    } else if (user.getName().isEmpty()) {
      user.getNotification().append(STRING_SHOULD_NOT_BE_BLANK.replace("{}", NAME_STR), USER_STR);
    }

    final String name = user.getName().trim();
    if ((name.length() < MIN_NAME_LEN) || (name.length() > MAX_NAME_LEN)) {
      user.getNotification().append(NAME_LENGTH_INVALID.replace("{}", NAME_STR), USER_STR);
    }
  }

}
