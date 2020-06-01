package com.me.repository.impl;

import com.me.entity.Student;
import com.me.entity.Teacher;
import com.me.repository.TeacherRepository;
import utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherRepositoryImpl implements TeacherRepository {
    @Override
    public Teacher login(String username, String password) {
        Connection connection= JDBCTools.getConnection();
        String sql ="select * from teacher where username = ? and password = ?";//判断老师是否在表中
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Teacher teacher = null;
        try{
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,password);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                teacher = new Teacher(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getString(3),resultSet.getString(4));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,statement,resultSet);//释放
        }
        return teacher;

    }
}
