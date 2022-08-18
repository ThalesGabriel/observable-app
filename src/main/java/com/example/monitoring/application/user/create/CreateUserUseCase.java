package com.example.monitoring.application.user.create;

import com.example.monitoring.application.user.IUserEntity;
import com.example.monitoring.application.user.IUserGateway;
import com.example.monitoring.application.user.UserDto;
import com.example.monitoring.application.user.find.FindUserByCpfCommand;
import com.example.monitoring.application.user.find.FindUserByCpfUseCase;
import com.example.monitoring.domain.user.User;
import com.example.monitoring.shared.log.ILog;
import com.example.monitoring.shared.log.Log;

import java.util.Objects;

import static com.example.monitoring.shared.utils.ActionConstants.CREATE_USER;
import static com.example.monitoring.shared.utils.ErrorConstants.*;
import static com.example.monitoring.shared.utils.SuccessConstants.USER_INSERTED_ON_GATEWAY;
import static com.example.monitoring.shared.utils.SuccessConstants.USER_VALIDATED;

public class CreateUserUseCase {

  private static final ILog log = new Log(CreateUserUseCase.class);

  private final IUserGateway userGateway;
  private final FindUserByCpfUseCase findUserByCpfUseCase;

  private CreateUserUseCase(IUserGateway userGateway, FindUserByCpfUseCase findUserByCpfUseCase) {
    this.userGateway = Objects.requireNonNull(userGateway);
    this.findUserByCpfUseCase = findUserByCpfUseCase;
  }

  public static CreateUserUseCase of(IUserGateway userGateway, FindUserByCpfUseCase findUserByCpfUseCase) {
    return new CreateUserUseCase(userGateway, findUserByCpfUseCase);
  }

  public CreateUserOutput execute(CreateUserCommand createUserCommand) {
    UserDto user = this.createUser(createUserCommand);

    if (user.notification().hasErrors()) {
      log.info(USER_VALIDATION_ERRORS, user.name(), user.notification().messages(""));
      return CreateUserOutput.of(user.notification());
    }

    log.info(USER_VALIDATED, user.name());

    if (!this.hasUser(user.cpf())) {
      String message = USER_ALREADY_EXISTS.replace("{}", user.cpf());
      log.info(message);
      return CreateUserOutput.of(message);
    }

    return this.insertUser(UserDto.of(user));
  }

  private CreateUserOutput insertUser(IUserEntity user) {
    try {
      this.userGateway.save(user);
      log.info(USER_INSERTED_ON_GATEWAY, user.cpf());
      return CreateUserOutput.of(user);
    } catch (Exception e) {
      log.error(e.getMessage());
      return  CreateUserOutput.of(GATEWAY_INSERT_STR.replace("{}", user.cpf()));
    }
  }

  private boolean hasUser(String cpf) {
    return findUserByCpfUseCase.execute(new FindUserByCpfCommand(cpf)).notificationErrors() != null;
  }

  private UserDto createUser(CreateUserCommand createUserCommand) {
    final String name = createUserCommand.name();
    final String cpf = createUserCommand.cpf();
    final Boolean isAdm = createUserCommand.isAdm();

    User user = User.of(name, cpf, isAdm);
    log.info(CREATE_USER, user.toString());

    user.validate();

    return UserDto.of(user);
  }

}
