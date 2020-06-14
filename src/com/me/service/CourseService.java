package com.me.service;

import com.me.entity.Course;
import com.me.entity.Tkmetrics;

import java.util.List;

public interface CourseService {
    public List<Course> findAll(String username);
    public List<Tkmetrics> findAllByTeacher(String username,Integer page);
    public int getTeacherPages(String username);
    public List<Course> findAllByLno(Integer lno);
}
