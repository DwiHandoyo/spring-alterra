package com.alterra.submission.service;

import com.alterra.submission.form.StudentForm;
import org.springframework.http.ResponseEntity;

public interface StudentService {

    ResponseEntity<Object> create(StudentForm form);

    ResponseEntity<Object> getAll();

    ResponseEntity<Object> findById(Long id);

    ResponseEntity<Object> updateById(StudentForm form, Long id);

    ResponseEntity<Object> deleteById(Long id);
}
