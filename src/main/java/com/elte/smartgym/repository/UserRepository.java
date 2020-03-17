package com.elte.smartgym.repository;

import com.elte.smartgym.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
