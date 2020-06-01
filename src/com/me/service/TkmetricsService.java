package com.me.service;

import com.me.entity.Tkmetrics;

import java.util.List;

public interface TkmetricsService {
    public List<Tkmetrics> findAllTk(Integer sno,Integer cno);
    public void handleTk(Integer state,Integer tno);
}
