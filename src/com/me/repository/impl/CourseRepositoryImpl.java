package com.me.repository.impl;

import com.me.entity.Course;
import com.me.entity.Student;
import com.me.entity.Teacher;
import com.me.entity.Tkmetrics;
import com.me.repository.CourseRepository;
import utils.JDBCTools;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {
    @Override
    //查找学生的所有课程
    public List<Course> findAll(String username) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select c.Cno,c.Cname,h.lname,s.sno from course c,cs s, student t,teacher h where t.username = ? AND c.Cno = s.cno and s.sno = t.sno and h.cno = c.Cno";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Course> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Teacher teacher = new Teacher(resultSet.getString(3));
                Student student = new Student((resultSet.getInt(4)));
                list.add(new Course(resultSet.getInt(1),resultSet.getString(2),teacher,student));
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public List<Tkmetrics> findAllByTeacherId(String username) {
        Connection connection = JDBCTools.getConnection();
        String sql = "SELECT te.lname,tk.tno,c.Cname,st.sno,st.sname,tk.Time,tk.state\n" +
                "FROM course c,student st,teacher te,tkmetrics tk WHERE te.username = ? AND tk.teacherid = te.lno AND st.sno = tk.sno\n" +
                "and c.Cno = tk.cno";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Tkmetrics> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Teacher teacher = new Teacher(resultSet.getString(1));
                Student student = new Student(resultSet.getInt(4),resultSet.getString(5));
                Course course = new Course(resultSet.getString(3));
                Tkmetrics tkmetrics = new Tkmetrics(resultSet.getInt(2),student,course,teacher,resultSet.getString(6),resultSet.getString(7));
            list.add(tkmetrics);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return list;
    }


}
