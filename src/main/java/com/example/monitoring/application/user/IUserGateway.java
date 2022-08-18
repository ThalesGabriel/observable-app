package com.example.monitoring.application.user;

import com.example.monitoring.infrastructure.api.pagination.Pagination;
import com.example.monitoring.infrastructure.api.pagination.SearchQuery;

import java.util.Optional;

public interface IUserGateway<I extends IUserEntity, O extends IUserEntity> {
  Optional<O> findByCpf(String cpf);
  O save(I user);

  Pagination<O> findAll(SearchQuery searchQuery);
}
