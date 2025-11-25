package com.example.sms.mapper;

import com.example.sms.dto.StudentCreateRequest;
import com.example.sms.dto.StudentResponse;
import com.example.sms.entity.Student;

public class StudentMapper {

    public Student mapInput(StudentCreateRequest studentCreateRequest){
        Student student = new Student();
        student.setFirstName(studentCreateRequest.getFirstName());
        student.setLastName(studentCreateRequest.getLastName());
        student.setEmail(studentCreateRequest.getEmail());
        student.setDateOfBirth(studentCreateRequest.getDateOfBirth());
        return student;
    }
    public StudentResponse mapToResponse(Student student){
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(studentResponse.getId());
        studentResponse.setFullName(student.getFirstName() + " " + student.getLastName());
        studentResponse.setEmail(student.getEmail());
        studentResponse.setDateOfBirth(student.getDateOfBirth());
        studentResponse.setCreatedAt(student.getCreatedAt());
        return studentResponse;
    }
}
