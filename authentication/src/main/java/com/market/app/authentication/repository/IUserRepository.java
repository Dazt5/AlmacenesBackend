package com.market.app.authentication.repository;

import com.market.app.authentication.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository  extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username);

}
