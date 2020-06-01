package com.me.entity;

public class Course {
    private Integer cno;//课程号
    private String cname;//课程名
    private Teacher teacher;//授课老师
    private Student student;//学生

    public Course(Integer cno, String cname, Student student) {
        this.cno = cno;
        this.cname = cname;
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course(Integer cno,String cname, Teacher teacher, Student student) {
        this.cno = cno;
        this.cname = cname;
        this.teacher = teacher;
        this.student= student;
    }

    public Course(Integer cno) {
        this.cno = cno;
    }

    public Course(String cname) {
        this.cname = cname;
    }

    public Course(Integer cno, String cname) {
        cno = cno;
        cname = cname;
    }

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cno=" + cno +
                ", cname='" + cname + '\'' +
                '}';
    }
}
