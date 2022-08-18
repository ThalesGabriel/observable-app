package com.example.monitoring.application.user.find;

import com.example.monitoring.application.user.IUserEntity;
import com.example.monitoring.application.user.IUserGateway;
import com.example.monitoring.domain.user.cpf.CpfValidator;
import com.example.monitoring.shared.log.ILog;
import com.example.monitoring.shared.log.Log;

import java.util.Optional;

import static com.example.monitoring.shared.utils.ActionConstants.FIND_BY_CPF;
import static com.example.monitoring.shared.utils.ErrorConstants.*;
import static com.example.monitoring.shared.utils.SuccessConstants.USER_FOUND;

public class FindUserByCpfUseCase {

  private static final ILog log = new Log(FindUserByCpfUseCase.class);

  private final IUserGateway userGateway;

  private FindUserByCpfUseCase(IUserGateway gateway) {
    this.userGateway = gateway;
  }

  public static FindUserByCpfUseCase of(IUserGateway gateway) {
    return new FindUserByCpfUseCase(gateway);
  }

  public FindUserByCpfOutput execute(FindUserByCpfCommand command) {
    log.info(FIND_BY_CPF, command.cpf());

    if (!CpfValidator.isCPF(command.cpf())) {
      log.info(CPF_INVALID.replace("{}", command.cpf()));
      return FindUserByCpfOutput.of(CPF_INVALID.replace("{}", command.cpf()));
    }

    try {
      Optional<IUserEntity> actualUser = this.userGateway.findByCpf(command.cpf());

      if(actualUser.isEmpty()) {
        log.info(USER_DOES_NOT_EXISTS, command.cpf());
        return FindUserByCpfOutput.of(USER_DOES_NOT_EXISTS.replace("{}", command.cpf()));
      }

      log.info(USER_FOUND, actualUser.get().toString());
      return FindUserByCpfOutput.of(actualUser.get());

    } catch (Exception e) {
      log.error(e.getMessage());
      return FindUserByCpfOutput.of(GATEWAY_FIND_STR.replace("{}", command.cpf()));
    }

  }
}
