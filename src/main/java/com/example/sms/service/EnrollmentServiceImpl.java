package com.example.sms.service;

import com.example.sms.dto.EnrollmentRequest;
import com.example.sms.entity.Course;
import com.example.sms.entity.Enrollment;
import com.example.sms.entity.Student;
import com.example.sms.repository.CourseRepository;
import com.example.sms.repository.EnrollmentRepository;
import com.example.sms.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService{

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Enrollment enrollStudent(EnrollmentRequest enrollmentRequest) {
        Student student =
                studentRepository.findById(enrollmentRequest.getStudentId())
                        .orElseThrow(() -> new EntityNotFoundException("Student not found with given id"));

        Course course = courseRepository.findById(enrollmentRequest.getCourseId())
                .orElseThrow(() -> new EntityNotFoundException("Course not found with given id"));

        Optional<Enrollment> byStudentAndCourse = enrollmentRepository.findByStudentAndCourse(student, course);

        if (byStudentAndCourse.isPresent()){
            throw new RuntimeException("Already enrolled");
        }
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        Enrollment saved = enrollmentRepository.save(enrollment);
        return saved;
    }

    @Override
    public List<Enrollment> coursesByStudentId(Long id) {
        return enrollmentRepository.findByCourseId(id);
    }

    @Override
    public List<Enrollment> studentsByCourseId(Long id) {
        return enrollmentRepository.findByStudentId(id);
    }
}
