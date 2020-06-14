package com.me.service.Impl;

import com.me.entity.Course;
import com.me.entity.Tkmetrics;
import com.me.repository.CourseRepository;
import com.me.repository.impl.CourseRepositoryImpl;
import com.me.service.CourseService;

import javax.print.DocFlavor;
import java.util.List;

public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository = new CourseRepositoryImpl();
    private final int LIMIT = 10;
    @Override
    public List<Course> findAll(String username) {
        return courseRepository.findAll(username);
    }

    @Override
    public List<Tkmetrics> findAllByTeacher(String username,Integer page) {

        int index = (page-1)*LIMIT;
        return courseRepository.findAllByTeacherId(username,index,LIMIT);
    }

    @Override
    public int getTeacherPages(String username) {
        int count = courseRepository.count(username);
        int pages=0;
        if(count%LIMIT==0){
            pages = count/LIMIT;
        }else{
            pages = count/LIMIT+1;
        }
        return pages;
    }

    @Override
    public List<Course> findAllByLno(Integer lno) {
        return courseRepository.findAllByLno(lno);
    }
}
