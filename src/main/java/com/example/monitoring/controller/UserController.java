package com.example.monitoring.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

  Map<String, String> map = Map.of("Thales", "Gabriel", "Lidia", "Albuquerque");

  @GetMapping
  @Operation(summary = "List all users paginated")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Listed successfully"),
          @ApiResponse(responseCode = "422", description = "A invalid parameter was received"),
          @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
  })
  public ResponseEntity<?> findAll() {
    return ResponseEntity.ok(Map.of("Thales", "Gabriel", "Lidia", "Albuquerque"));
  }

  @PostMapping
  public ResponseEntity<?> create() {
    return ResponseEntity.ok(Map.of("Thales", "Gabriel"));
  }
}
