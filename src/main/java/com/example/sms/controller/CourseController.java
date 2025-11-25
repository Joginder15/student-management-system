package com.example.sms.controller;

import com.example.sms.dto.CourseCreateRequest;
import com.example.sms.dto.CourseResponse;
import com.example.sms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public CourseResponse createCourse(@RequestBody CourseCreateRequest courseCreateRequest){
        return courseService.createCourse(courseCreateRequest);
    }
}
