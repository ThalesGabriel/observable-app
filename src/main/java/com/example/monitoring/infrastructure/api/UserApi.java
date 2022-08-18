package com.example.monitoring.infrastructure.api;

import com.example.monitoring.application.user.list.ListUsersOutput;
import com.example.monitoring.infrastructure.api.pagination.Pagination;
import com.example.monitoring.infrastructure.api.request.CreateUserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "users")
@Tag(name = "Users")
public interface UserApi {

  @PostMapping(
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(summary = "Create a new user")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "201", description = "Created successfully"),
          @ApiResponse(responseCode = "422", description = "A validation error was thrown"),
          @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
  })
  ResponseEntity<?> createUser(@RequestBody CreateUserRequest input) throws JsonProcessingException;

  @GetMapping
  @Operation(summary = "List all users paginated")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Listed successfully"),
          @ApiResponse(responseCode = "422", description = "A invalid parameter was received"),
          @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
  })
  Pagination<ListUsersOutput> listCompanies(
          @RequestParam(name = "page", required = false, defaultValue = "0") final int page,
          @RequestParam(name = "perPage", required = false, defaultValue = "10") final int perPage
  );

  @GetMapping(
          value = "{cpf}",
          produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(summary = "Get a user by it's cpf")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "User found"),
          @ApiResponse(responseCode = "422", description = "Unprocessable Entity. User already exists."),
  })
  ResponseEntity<?> findByCPF(@PathVariable(name = "cpf") String cpf);

}

