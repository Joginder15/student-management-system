package com.example.sms.controller;

import com.example.sms.dto.EnrollmentRequest;
import com.example.sms.entity.Enrollment;
import com.example.sms.service.EnrollmentService;
import jakarta.persistence.Access;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public Enrollment enrollStudent(@Valid @RequestBody EnrollmentRequest enrollmentRequest){
        return enrollmentService.enrollStudent(enrollmentRequest);
    }

    @GetMapping("/{id}")
    public List<Enrollment> coursesByStudentId(@PathVariable Long id) {
        return enrollmentService.coursesByStudentId(id);
    }

    @GetMapping("/{id}")
    public List<Enrollment> studentsByCourseId(@PathVariable Long id){
        return enrollmentService.studentsByCourseId(id);
    }
}
