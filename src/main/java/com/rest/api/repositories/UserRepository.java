package com.rest.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.api.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
