package com.me.repository;

import com.me.entity.Course;
import com.me.entity.Tkmetrics;

import java.util.List;

public interface CourseRepository {
    public List<Course> findAll(String username);
    public List<Tkmetrics> findAllByTeacherId(String username);
}
