package com.example.sms.service;

import com.example.sms.dto.StudentCreateRequest;
import com.example.sms.dto.StudentResponse;
import com.example.sms.entity.Student;
import com.example.sms.mapper.StudentMapper;
import com.example.sms.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudentResponse createStudent(StudentCreateRequest request) {
        if (studentRepository.existsByEmail(request.getEmail())){
            throw new IllegalArgumentException("Email already exists");
        }
        Student student = studentMapper.mapInput(request);
        Student saveStudent = studentRepository.save(student);
        StudentResponse studentResponse = studentMapper.mapToResponse(saveStudent);
        return studentResponse;
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        Student student =
                studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student not found"));
        return studentMapper.mapToResponse(student);
    }

    @Override
    public Page getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable).map(student -> studentMapper.mapToResponse(student));
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentCreateRequest request) {
        Student student =
                studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student not found"));

        student.setFirstName(request.getFirstName());
        student.setFirstName(request.getLastName());
        student.setEmail(request.getEmail());

        Student updated = studentRepository.save(student);
        return studentMapper.mapToResponse(updated);
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)){
            throw new EntityNotFoundException("Student not found");
        }

        studentRepository.deleteById(id);
    }
}
