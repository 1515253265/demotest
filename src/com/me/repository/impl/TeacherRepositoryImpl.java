package com.me.repository.impl;

import com.me.entity.Student;
import com.me.entity.Teacher;
import com.me.entity.Tkmetrics;
import com.me.repository.TeacherRepository;
import com.mysql.cj.jdbc.JdbcConnection;
import utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    @Override
    public void updateByTno(Integer tno,Integer state) {
        Connection connection = JDBCTools.getConnection();
        String sql = "update tkmetrics set state = ? where tno = ?";
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(sql);
            statement.setInt(1,state);
            statement.setInt(2,tno);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,statement,null);
        }

    }

    @Override
    public void deleteByTno(Integer tno) {
        Connection connection = JDBCTools.getConnection();
        String sql="delete from tkmetrics where tno = ?";
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(sql);
            statement.setInt(1,tno);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,statement,null);
        }

    }
}
