package com.me.entity;

import java.util.Date;

//逃课信息记录
public class Tkmetrics {
    private Integer tno;//编号
    private Student student;
    private Course course;
    private Teacher teacher;
    private String date;//日期
    private String state;//状态
    private String reason;

    public Tkmetrics(Integer tno, Student student, Course course, Teacher teacher, String date, String state) {
        this.tno = tno;
        this.student = student;
        this.course = course;
        this.teacher = teacher;
        this.date = date;
        this.state = state;
    }

    public Tkmetrics(Integer tno, Course course, Teacher teacher, String date, String state) {
        this.tno = tno;
        this.course = course;
        this.teacher = teacher;
        this.date = date;
        this.state = state;
    }

    public Integer getTno() {
        return tno;
    }

    public void setTno(Integer tno) {
        this.tno = tno;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
