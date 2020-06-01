package com.me.service.Impl;

import com.me.repository.StudentRepository;
import com.me.repository.TeacherRepository;
import com.me.repository.impl.StudentRepositoryImpl;
import com.me.repository.impl.TeacherRepositoryImpl;
import com.me.service.LoginService;

public class LoginServiceImpl implements LoginService {
    private StudentRepository studentRepository = new StudentRepositoryImpl();
    private TeacherRepository teacherRepository = new TeacherRepositoryImpl();
    @Override
    public Object login(String username, String password, String type) {
        Object object = null;
        switch (type){
            case "student":
                object = studentRepository.login(username,password);
                break;
            case "teacher":
                object = teacherRepository.login(username, password);
                break;
        }
        return object;
    }
}
