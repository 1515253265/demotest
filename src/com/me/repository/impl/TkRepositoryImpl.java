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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//根据课程号和学号查找该课程的逃课信息
public class TkRepositoryImpl implements TkRepository {
    @Override
    public List<Tkmetrics> findAllTk(Integer sno,Integer cno) {
        Connection connection = JDBCTools.getConnection();
        String sql="select tk.tno,tk.Time,tk.state,st.sno,c.Cno,c.Cname,t.lname,st.username,st.password\n" +
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
                Student student = new Student(resultSet.getInt(4),resultSet.getString(8),resultSet.getString(9));
                Course course = new Course(resultSet.getInt(5),resultSet.getString(6));
                Teacher teacher = new Teacher(resultSet.getString(7));
                Tkmetrics tkmetrics = new Tkmetrics(resultSet.getInt(1),student,course,teacher,resultSet.getString(2),resultSet.getString(3));
                list.add(tkmetrics);
                System.out.println(resultSet.getString(6));
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

    @Override
    public void insert(Integer cno, Integer sno, Integer lno) {
        Connection connection = JDBCTools.getConnection();
        Date date = new Date();//获取时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy--MM-dd");
        String sdf = simpleDateFormat.format(date);
        System.out.println(sdf);
        String sql = "insert into tkmetrics(cno,sno,Time,teacherid,state) values(?,?,?,?,0)";
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(sql);
            statement.setInt(1,cno);
            statement.setInt(2,sno);
            statement.setString(3,sdf);
            statement.setInt(4,lno);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,statement,null);
        }
    }

    @Override
    public int count(Integer sno,Integer cno) {
        Connection connection = JDBCTools.getConnection();
        String sql ="select count(*) FROM course c,student st,teacher t,tkmetrics tk WHERE st.sno = ? AND c.Cno = ? and c.Cno = tk.cno and tk.teacherid = t.lno AND tk.sno = st.sno";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,sno);
            preparedStatement.setInt(2,cno);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                count = resultSet.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return count;
    }

}
