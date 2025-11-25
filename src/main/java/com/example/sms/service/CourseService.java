package com.example.sms.service;


import com.example.sms.dto.CourseCreateRequest;
import com.example.sms.dto.CourseResponse;

public interface CourseService {

    public CourseResponse createCourse(CourseCreateRequest courseCreateRequest);
}
