package com.clean.architecture.service;

import com.clean.architecture.form.StudentForm;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    ResponseEntity<Object> create(StudentForm form);

    ResponseEntity<Object> getAll();

    ResponseEntity<Object> findById(Long id);

    ResponseEntity<Object> updateById(StudentForm form, Long id);

    ResponseEntity<Object> deleteById(Long id);
}
