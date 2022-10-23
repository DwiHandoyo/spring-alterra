package com.clean.architecture.repository;

import com.clean.architecture.domain.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel getDistinctTopByUsername(String username);
}
