package com.me.repository;

import com.me.entity.Tkmetrics;

import java.util.List;

public interface TkRepository {
    public List<Tkmetrics> findAllTk(Integer sno,Integer cno);
    public void handle(Integer state,Integer tno);
    public void insert(Integer cno,Integer sno,Integer lno);
    public int count(Integer sno,Integer cno);
}
