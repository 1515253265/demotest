package com.me.service.Impl;

import com.me.repository.TeacherRepository;
import com.me.repository.impl.TeacherRepositoryImpl;
import com.me.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
    private TeacherRepository teacherRepository = new TeacherRepositoryImpl();
    @Override
    public void updateByTno(Integer tno, Integer state) {
      teacherRepository.updateByTno(tno,state);
    }

    @Override
    public void deleteByTno(Integer tno) {
      teacherRepository.deleteByTno(tno);
    }
}
