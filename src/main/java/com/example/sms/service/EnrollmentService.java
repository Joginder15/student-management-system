package com.example.sms.service;

import com.example.sms.dto.EnrollmentRequest;
import com.example.sms.entity.Enrollment;

import java.util.List;

public interface EnrollmentService {

    public Enrollment enrollStudent(EnrollmentRequest enrollmentRequest);
    public List<Enrollment> coursesByStudentId(Long id);
    public List<Enrollment> studentsByCourseId(Long id);
}
