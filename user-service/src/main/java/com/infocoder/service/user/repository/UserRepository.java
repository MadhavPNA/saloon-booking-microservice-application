package com.infocoder.service.user.repository;

import com.infocoder.service.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
