package class12.jdbc;

import class12.model.StudentHomework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentHomeworkJdbc {

    public static void main(String[] args) {
        List<StudentHomework> list = selectAll();

        for (StudentHomework sh : list){
            System.out.println(sh.getHomeworkContent());
        }
    }

    public static boolean addStudentHomework(StudentHomework sh){
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

        String sqlString = "insert into s_student_homework (student_id,homework_id,homework_title,homework_content,create_time) values(?,?,?,?,?)";

        int resultSet = 0;
        try (Connection connection = DriverManager.getConnection(url,userName,password)) {
            try (PreparedStatement ps = connection.prepareStatement(sqlString)) {
                ps.setString(1,sh.getStudentId());
                ps.setString(2,sh.getHomeworkId());
                ps.setString(3,sh.getHomeworkTitle());
                ps.setString(4,sh.getHomeworkContent());
                ps.setTimestamp(5,new Timestamp(sh.getCreateTime().getTime()));
                resultSet = ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet > 0;
    }

    public static List<StudentHomework> selectAll(){

        String driverClassName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/homework?&useSSL=false&serverTimezone=UTC";
        String userName = "root";
        String password = "990328";

        String sqlString = "SELECT * FROM s_student_homework";

        try {
            // 加载驱动
            Class.forName(driverClassName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<StudentHomework> list = new ArrayList<>();
        try(Connection connection =  DriverManager.getConnection(url,userName,password)) {
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    // 获取执行结果
                    while (resultSet.next()){
                        StudentHomework sh = new StudentHomework();
                        sh.setId(resultSet.getLong("id"));
                        sh.setStudentId(resultSet.getString("student_id"));
                        sh.setHomeworkId(resultSet.getString("homework_id"));
                        sh.setHomeworkTitle(resultSet.getString("homework_title"));
                        sh.setHomeworkContent(resultSet.getString("homework_content"));
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
