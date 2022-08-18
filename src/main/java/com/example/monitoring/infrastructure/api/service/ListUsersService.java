package com.example.monitoring.infrastructure.api.service;

import com.example.monitoring.application.user.list.ListUsersOutput;
import com.example.monitoring.application.user.list.ListUsersUseCase;
import com.example.monitoring.infrastructure.api.pagination.Pagination;
import com.example.monitoring.infrastructure.api.pagination.SearchQuery;
import org.springframework.stereotype.Service;

@Service
public class ListUsersService {

  private final ListUsersUseCase listUsersUseCase;

  public ListUsersService(ListUsersUseCase listUsersUseCase) {
    this.listUsersUseCase = listUsersUseCase;
  }

  public Pagination<ListUsersOutput> execute(SearchQuery searchQuery) {
    return listUsersUseCase.execute(searchQuery);
  }
}
