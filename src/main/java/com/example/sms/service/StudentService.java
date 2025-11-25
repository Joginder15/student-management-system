package com.example.sms.service;

import com.example.sms.dto.StudentCreateRequest;
import com.example.sms.dto.StudentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {

    StudentResponse createStudent(StudentCreateRequest request);
    StudentResponse getStudentById(Long id);
    Page getAllStudents(Pageable pageable);
    StudentResponse updateStudent(Long id, StudentCreateRequest request);
    void deleteStudent(Long id);
}
