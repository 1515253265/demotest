package com.me.repository;

import com.me.entity.Teacher;
import com.me.entity.Tkmetrics;

import java.util.List;

public interface TeacherRepository {
    public Teacher login(String username,String password);
    public void updateByTno(Integer tno,Integer state);
    public void deleteByTno(Integer tno);
}
