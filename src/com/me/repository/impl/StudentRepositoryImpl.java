package com.me.repository.impl;

import com.me.entity.Student;
import com.me.repository.StudentRepository;
import utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRepositoryImpl implements StudentRepository {
    @Override
    public Student login(String username, String password) {
        Connection connection= JDBCTools.getConnection();
        String sql ="select * from student where username = ? and password = ?";//判断学生是否在表中
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Student student = null;
        try{
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,password);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                student = new Student(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),
                        resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,statement,resultSet);//释放
        }
        return student;

    }
}
