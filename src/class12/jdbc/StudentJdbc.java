package class12.jdbc;

import class12.model.student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentJdbc {

    public static void main(String[] args) {

        List<student> list = selectAll();

    }

    public static boolean addstudent(student h){
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/homework?&useSSL=false&serverTimezone=UTC";
        String userName = "root";
        String password = "990328";

        try {
            // 加载驱动
            Class.forName(driverClassName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "insert into s_student (id,name,create_time) values(?,?,?)";

        int resultSet = 0;
        try (Connection connection = DriverManager.getConnection(url,userName,password)) {
            try (PreparedStatement ps = connection.prepareStatement(sqlString)) {
                ps.setString(1,h.getId());
                ps.setString(2,h.getName());
                ps.setTimestamp(3,new Timestamp(h.getCreateTime().getTime()));
                resultSet = ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet > 0;

    }

    public static List<student> selectAll(){

        String driverClassName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/homework?&useSSL=false&serverTimezone=UTC";
        String userName = "root";
        String password = "990328";

        try {
            // 加载驱动
            Class.forName(driverClassName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sqlString = "SELECT * FROM s_student";



        List<student> list = new ArrayList<>();
        try(Connection connection =  DriverManager.getConnection(url,userName,password)) {
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    // 获取执行结果
                    while (resultSet.next()){
                        student sh = new student();
                        sh.setId(resultSet.getString("id"));
                        sh.setName(resultSet.getString("name"));
                        sh.setCreateTime(resultSet.getTimestamp("create_time"));
                        list.add(sh);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}
