package com.me.service.Impl;

import com.me.entity.Course;
import com.me.entity.Tkmetrics;
import com.me.repository.CourseRepository;
import com.me.repository.impl.CourseRepositoryImpl;
import com.me.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository = new CourseRepositoryImpl();
    @Override
    public List<Course> findAll(String username) {
        return courseRepository.findAll(username);
    }

    @Override
    public List<Tkmetrics> findAllByTeacher(String username) {
        return courseRepository.findAllByTeacherId(username);
    }
}
