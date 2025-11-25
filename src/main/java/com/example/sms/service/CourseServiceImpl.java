package com.example.sms.service;

import com.example.sms.dto.CourseCreateRequest;
import com.example.sms.dto.CourseResponse;
import com.example.sms.entity.Course;
import com.example.sms.mapper.CourseMapper;
import com.example.sms.repository.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public CourseResponse createCourse(CourseCreateRequest courseCreateRequest) {
        Optional<Course> byCode = courseRepository.findByCode(courseCreateRequest.getCode());
        if (byCode.isPresent()){
            throw new IllegalArgumentException("Course already exists with given code");
        }

        Course course = courseMapper.mapToCourse(courseCreateRequest);
        Course saveCourse = courseRepository.save(course);
        return courseMapper.mapToResponse(saveCourse);
    }
}
