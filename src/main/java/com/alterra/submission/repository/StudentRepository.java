package com.alterra.submission.repository;

import com.alterra.submission.domain.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<StudentModel, Long> {

    @Modifying
    @Query(value = "update student set is_deleted = :flag where id = :id", nativeQuery = true)
    void deleteOne(@Param("flag") boolean flagDeleted, @Param("id") Long id);
}
