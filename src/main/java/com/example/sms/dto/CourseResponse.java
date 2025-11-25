package com.example.sms.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CourseResponse {

    private Long id;
    private String name;
    private String code;
    private String description;
}
