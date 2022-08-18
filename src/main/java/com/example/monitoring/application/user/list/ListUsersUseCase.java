package com.example.monitoring.application.user.list;

import com.example.monitoring.application.user.IUserEntity;
import com.example.monitoring.application.user.IUserGateway;
import com.example.monitoring.infrastructure.api.pagination.Pagination;
import com.example.monitoring.infrastructure.api.pagination.SearchQuery;
import com.example.monitoring.shared.log.ILog;
import com.example.monitoring.shared.log.Log;

import java.util.ArrayList;

import static com.example.monitoring.shared.utils.ActionConstants.FIND_ALL_USERS;
import static com.example.monitoring.shared.utils.SuccessConstants.FOUND_X_USERS;

public class ListUsersUseCase {

  private final IUserGateway<IUserEntity, IUserEntity> iUserGateway;

  private static final ILog log = new Log(ListUsersUseCase.class);

  private ListUsersUseCase(IUserGateway iUserGateway) {
    this.iUserGateway = iUserGateway;
  }

  public static ListUsersUseCase of(IUserGateway iUserGateway) {
    return new ListUsersUseCase(iUserGateway);
  }

  public Pagination<ListUsersOutput> execute(SearchQuery searchQuery) {
    log.info(FIND_ALL_USERS);
    try {
      Pagination<ListUsersOutput> outputPagination = this.iUserGateway.findAll(searchQuery).map(ListUsersOutput::of);
      log.info(FOUND_X_USERS, outputPagination.items().size());
      return outputPagination;
    } catch (Exception e) {
      log.error(e.getMessage());
      return new Pagination<>(searchQuery.page(), searchQuery.perPage(), 0, new ArrayList<>());
    }
  }
}
