package com.me.repository;

import com.me.entity.Student;

public interface StudentRepository {
    public Student login(String username,String password);
}
