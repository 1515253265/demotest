package com.me.repository;

import com.me.entity.Teacher;

public interface TeacherRepository {
    public Teacher login(String username,String password);
}
