package StudentRepository;

import java.sql.*;
import java.util.Set;

public class StudentRepository {
    private String url = "jdbc:oracle:thin:@192.168.100.121:1521/lcdev";
    private String username = "train";
    private String password = "train";

    private Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet selectAll() {
        try {
            Connection conn = this.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from student");
            ResultSet rs = ps.executeQuery();
            return rs;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertStudent(int id, String firtsname, String lastname, int stu_age){
        try {
            Connection conn = this.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into student values (id, firstname, lastname, stu_age)");
            ResultSet rs = ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
