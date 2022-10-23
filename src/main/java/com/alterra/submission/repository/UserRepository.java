package com.alterra.submission.repository;

import com.alterra.submission.domain.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel getDistinctTopByUsername(String username);
}
