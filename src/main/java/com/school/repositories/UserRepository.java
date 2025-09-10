package com.school.repositories;

import com.school.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

   Optional<User> findByUsername(String username);
  //  UserDetails findByUsername(String username);
}
