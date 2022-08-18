package com.example.monitoring.infrastructure.api.controller;

import com.example.monitoring.application.user.list.ListUsersOutput;
import com.example.monitoring.infrastructure.api.UserApi;
import com.example.monitoring.infrastructure.api.pagination.Pagination;
import com.example.monitoring.infrastructure.api.pagination.SearchQuery;
import com.example.monitoring.infrastructure.api.request.CreateUserRequest;
import com.example.monitoring.infrastructure.api.service.CreateUserService;
import com.example.monitoring.infrastructure.api.service.FindUserByCpfService;
import com.example.monitoring.infrastructure.api.service.ListUsersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class UserController implements UserApi {

  @Autowired
  private CreateUserService createUserService;

  @Autowired
  private FindUserByCpfService findUserByCPFService;

  @Autowired
  private ListUsersService listUsersService;

  @Override
  public ResponseEntity<?> createUser(@RequestBody CreateUserRequest input) throws JsonProcessingException {
    final String inputName = input.name();
    final String inputCpf = input.cpf();
    final boolean inputIsAdm = input.isAdm();

    final var response = createUserService.execute(inputName, inputCpf, inputIsAdm);

    if (response.notificationErrors() != null)
      return ResponseEntity.unprocessableEntity().body(response);

    final String userLocation = "/users/".concat(response.cpf());
    return ResponseEntity.created(URI.create(userLocation)).body(response);
  }

  @Override
  public Pagination<ListUsersOutput> listCompanies(int page, int perPage) {
    return listUsersService.execute(new SearchQuery(page, perPage));
  }


  @Override
  public ResponseEntity<?> findByCPF(@PathVariable(name = "cpf") String cpf) {
    final var response = findUserByCPFService.execute(cpf);

    if (response.notificationErrors() != null)
      return ResponseEntity.unprocessableEntity().body(response.notificationErrors());

    return ResponseEntity.ok().body(response);
  }

}
