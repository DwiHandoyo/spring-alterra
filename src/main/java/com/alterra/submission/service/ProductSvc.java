package com.alterra.submission.service;

import com.alterra.submission.form.ProductForm;
import org.springframework.http.ResponseEntity;

public interface ProductSvc {

    ResponseEntity<Object> create(ProductForm form);

    ResponseEntity<Object> getAll();

    ResponseEntity<Object> findById(Long id);

    ResponseEntity<Object> updateById(ProductForm form, Long id);

    ResponseEntity<Object> deleteById(Long id);
}
