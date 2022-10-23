package com.clean.architecture.controller;

import com.clean.architecture.form.StudentForm;
import com.clean.architecture.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/student")
public class StudentController {
    private final StudentService studentSvc;
    @Autowired
    public StudentController(StudentService studentSvc) {
        this.studentSvc = studentSvc;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody StudentForm form){
        return studentSvc.create(form);
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        return studentSvc.getAll();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> getById(@PathVariable  Long id){
        return studentSvc.findById(id);
    }

    @PostMapping(value = "{id}")
    public ResponseEntity<Object> update(@RequestBody StudentForm form, @PathVariable Long id){
        return studentSvc.updateById(form, id);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id){
        return studentSvc.deleteById(id);
    }

}
