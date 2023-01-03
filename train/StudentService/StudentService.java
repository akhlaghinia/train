package StudentService;

import StudentRepository.StudentRepository;
import java.util.Scanner;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class StudentService {
    StudentRepository sr = new StudentRepository();
    ResultSet rs = sr.selectAll();
    public void listAllStudent() {
        while (true) {
            try {
                if (!rs.next()) break;
                System.out.println(rs.getInt(1) + "|" +
                                   rs.getString(2) + "|" +
                                   rs.getString(3) + "|" +
                                   rs.getInt(4));
                System.out.print("--------------------------------" + "\r\n");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void insertStudent(){
        Scanner scan = new Scanner(System.in);
        System.out.println("please insert student information");
        try {
            System.out.println("id:");
            int id = System.in.read();
            scan.nextLine();
            System.out.println("firstname:");
            String firstname = String.valueOf(System.in.read());
            scan.nextLine();
            System.out.println("lastname:");
            String lastname = String.valueOf(System.in.read());
            scan.nextLine();
            System.out.println("age:");
            int stu_age = System.in.read();
            sr.insertStudent(id, firstname, lastname, stu_age);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
