package com.example.sms.mapper;

import com.example.sms.dto.CourseCreateRequest;
import com.example.sms.dto.CourseResponse;
import com.example.sms.entity.Course;

public class CourseMapper {

    public Course mapToCourse(CourseCreateRequest courseCreateRequest){
        Course course = new Course();
        course.setName(courseCreateRequest.getName());
        course.setCode(courseCreateRequest.getCode());
        course.setDescription(courseCreateRequest.getDescription());
        return course;
    }

    public CourseResponse mapToResponse(Course course){
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setId(course.getId());
        courseResponse.setName(course.getName());
        courseResponse.setCode(course.getCode());
        courseResponse.setDescription(course.getDescription());
        return courseResponse;
    }
}
