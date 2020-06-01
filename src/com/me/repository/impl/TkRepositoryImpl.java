package com.me.repository.impl;

import com.me.entity.Course;
import com.me.entity.Student;
import com.me.entity.Teacher;
import com.me.entity.Tkmetrics;
import com.me.repository.TkRepository;
import utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//根据课程号和学号查找该课程的逃课信息
public class TkRepositoryImpl implements TkRepository {
    @Override
    public List<Tkmetrics> findAllTk(Integer sno,Integer cno) {
        Connection connection = JDBCTools.getConnection();
        String sql="select tk.tno,c.Cname,t.lname,tk.Time,tk.state,st.sno,c.Cno\n" +
                "FROM course c,student st,teacher t,tkmetrics tk WHERE st.sno = ? AND c.Cno = ? and c.Cno = tk.cno and tk.teacherid = t.lno AND\n" +
                "tk.sno = st.sno";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Tkmetrics> list = new ArrayList<>();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,sno);
            preparedStatement.setInt(2,cno);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int tkId = resultSet.getInt(1);
                String courseName = resultSet.getString(2);
                String teacherName = resultSet.getString(3);
                String time = resultSet.getString(4);
                String state = resultSet.getString(5);
                int snoStr = resultSet.getInt(6);
                int cnoStr = resultSet.getInt(7);
                Student student = new Student(snoStr);
                Course course = new Course(cnoStr,courseName,student);
                Teacher teacher = new Teacher(teacherName);
                Tkmetrics tkmetrics = new Tkmetrics(tkId,course,teacher,time,state);
                list.add(tkmetrics);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return list;
    }

    //修改逃课信息的状态
    @Override
    public void handle(Integer state,Integer tno) {
        Connection connection = JDBCTools.getConnection();
        String sql = "UPDATE tkmetrics set state = ? where tno = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,state);
            statement.setInt(2,tno);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,statement,null);
        }
    }
}
