package com.finanace.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.finanace.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}