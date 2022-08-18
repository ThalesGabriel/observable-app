package com.example.monitoring.infrastructure.gateway.mongo;

import com.example.monitoring.application.user.IUserGateway;
import com.example.monitoring.application.user.UserDto;
import com.example.monitoring.infrastructure.api.pagination.Pagination;
import com.example.monitoring.infrastructure.api.pagination.SearchQuery;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserGateway implements IUserGateway<UserDto, UserEntity> {

  private final UserRepository userRepository;

  public UserGateway(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Optional<UserEntity> findByCpf(String cpf) {
    final var optionalUserJpaEntity = this.userRepository.findByCpf(cpf);

    if(optionalUserJpaEntity.isEmpty())
      return Optional.empty();

    return Optional.of(optionalUserJpaEntity.get());
  }

  @Override
  public UserEntity save(UserDto user) {
    return this.userRepository.save(UserEntity.of(user));
  }

  @Override
  public Pagination<UserEntity> findAll(SearchQuery searchQuery) {
    final var page = PageRequest.of(
            searchQuery.page(),
            searchQuery.perPage()
    );

    final var pageResult =
            this.userRepository.findAll(page);

    return new Pagination<>(
            pageResult.getNumber(),
            pageResult.getSize(),
            pageResult.getTotalElements(),
            pageResult.toList()
    );
  }
}
