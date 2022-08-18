package com.example.monitoring.infrastructure.gateway.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity, String> {

  Optional<UserEntity> findByCpf(String cpf);

}
