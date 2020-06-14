package com.me.repository;

import com.me.entity.Course;
import com.me.entity.Tkmetrics;

import javax.print.DocFlavor;
import java.util.List;

public interface CourseRepository {
    public List<Course> findAll(String username);
    public List<Tkmetrics> findAllByTeacherId(String username,Integer index,Integer limit);
    public int count(String username);
    public List<Course> findAllByLno(Integer lno);
}
