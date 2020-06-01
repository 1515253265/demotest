package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.security.sasl.SaslException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//数据库连接池
public class JDBCTools {
    private static DataSource dataSource;
    static {
        dataSource = new ComboPooledDataSource("c3p0");
    }
    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = dataSource.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
    //释放数据库
    public static void release(Connection connection, Statement statement,
                               ResultSet resultSet){

            try {
                if(connection != null) {
                    connection.close();
                }
                if(statement != null){
                    statement.close();
                }
                if(resultSet != null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
