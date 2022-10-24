package com.alterra.submission.service;

import com.alterra.submission.repository.StudentRepository;
import com.alterra.submission.domain.common.ResponseUtil;
import com.alterra.submission.constant.MessageConstant;
import com.alterra.submission.form.StudentForm;
import com.alterra.submission.domain.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService {

    private final StudentRepository studentRepo;

    @Autowired
    public StudentServiceImplementation(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public ResponseEntity<Object> create(StudentForm form) {
        try {
            StudentModel student = student(form);
            studentRepo.save(student);
            return ResponseUtil.build(MessageConstant.SUCCESS, student, HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> getAll() {
        try {
            List<StudentModel> students =  studentRepo.findAll();
            return ResponseUtil.build(MessageConstant.SUCCESS, students, HttpStatus.OK);
        }catch (Exception e){
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> findById(Long id) {
        try {
            Optional<StudentModel> getById = studentRepo.findById(id);
            return getById.map(studentModel -> ResponseUtil.build(MessageConstant.SUCCESS, studentModel, HttpStatus.OK))
                    .orElseGet(() -> ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> updateById(StudentForm form, Long id) {
        try {
            Optional<StudentModel> getById = studentRepo.findById(id);
            if (!getById.isPresent()) return ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND);
            StudentModel student = getById.get();
            student.setName(form.getName());
            student.setAddress(form.getAddress());
            student.setNim(form.getNim());
            studentRepo.save(student);
            return ResponseUtil.build(MessageConstant.SUCCESS_UPDATE, studentRepo.save(student), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> deleteById(Long id) {
        try {
            Optional<StudentModel> data = studentRepo.findById(id);
            if (!data.isPresent()) return ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND);
            System.out.println(data.get().getName());
            studentRepo.deleteOne(true, data.get().getId());
            return ResponseUtil.build(MessageConstant.SUCCESS_DELETE, null, HttpStatus.OK);
        }catch (Exception e){
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private StudentModel student(StudentForm form) {
        StudentModel student = new StudentModel();
        student.setName(form.getName());
        student.setNim(form.getNim());
        student.setAddress(form.getAddress());
        return student;
    }
}
