package com.me.entity;

public class Student {
    private Integer sno;//学号s
    private String name;//姓名
    private String age;//年龄
    private String sex;//性别
    private String scar;//班级
    private String grade;//年级
    private String dept;//系别
    private String username;//登录名
    private String password;//密码

    public Student(Integer sno, String name, String scar, String grade) {
        this.sno = sno;
        this.name = name;
        this.scar = scar;
        this.grade = grade;
    }

    public Student(Integer sno, String username, String password) {
        this.sno = sno;
        this.username = username;
        this.password = password;
    }
    public Student(Integer sno, String name) {
        this.sno = sno;
        this.name = name;
    }

    public Student(Integer sno, String name, String age, String sex, String grade, String dept, String username, String password) {
        this.sno = sno;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.grade = grade;
        this.dept = dept;
        this.username = username;
        this.password = password;
    }

    public String getScar() {
        return scar;
    }

    public void setScar(String scar) {
        this.scar = scar;
    }

    public Student(Integer sno) {
        this.sno = sno;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
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
