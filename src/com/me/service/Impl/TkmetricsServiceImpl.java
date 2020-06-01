package com.me.service.Impl;

import com.me.entity.Tkmetrics;
import com.me.repository.CourseRepository;
import com.me.repository.TeacherRepository;
import com.me.repository.TkRepository;
import com.me.repository.impl.TkRepositoryImpl;
import com.me.service.TkmetricsService;

import java.util.List;

public class TkmetricsServiceImpl implements TkmetricsService {
    private TkRepository tkRepository = new TkRepositoryImpl();
    @Override
    public List<Tkmetrics> findAllTk(Integer sno, Integer cno) {
        return tkRepository.findAllTk(sno,cno);
    }

    @Override
    public void handleTk(Integer state, Integer tno) {
        tkRepository.handle(state,tno);
    }
}
