package com.me.entity;

public class Teacher {
    private Integer lno;//老师编号
    private String lname;//老师姓名
    private Course course;
    private String username;
    private String password;

    public Teacher(Integer lno, String lname, String username,String password) {
        this.lno = lno;
        this.lname = lname;
        this.username = username;
        this.password = password;
    }

    public Teacher(Integer lno, String lname, String username) {
        this.lno = lno;
        this.lname = lname;
        this.username = username;
    }

    public Teacher(String lname) {
        this.lname = lname;
    }

    public Teacher(String lname, String username) {
        this.lname = lname;
        this.username = username;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher(String lname,Course course) {
        this.lname = lname;
        this.course = course;
    }

    public Integer getLno() {
        return lno;
    }

    public void setLno(Integer lno) {
        this.lno = lno;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
