package sqlproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Student {

    Scanner sc = new Scanner(System.in);
    String name, phone, query;
    private int id;
    private int age;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost/school";
    private final String USER = "mohamed";
    private final String PASSWORD = "root";
    private Connection con;
    private Statement stmt;

    Student() {
        con = null;
        stmt = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            if (con != null) {
                System.out.println("Connected");
            }
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int Insert(String name ,int age , String phone) {
       this.name = name;
       this.age = age;
       this.phone = phone;

        try {
            query = "INSERT INTO student (id,name,age,phone) "
                    + "VALUES (null,'" + name + "','" + age + "','" + phone + "')";
           int ch = stmt.executeUpdate(query);
           return ch;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Conecting"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
           return 0;
        }
    }

    public ResultSet showAll() throws SQLException {
        ResultSet res = null;
        try {
            query = "select* from student";
            res = stmt.executeQuery(query);
//            while (res.next()) {
//                id = res.getInt("id");
//                name = res.getString("name");
//                age = res.getInt("age");
//                phone = res.getString("phone");
//                System.out.println(id + " - " + name + " - " + age + " - " + phone);
////            stmt.executeQuery(query);
//            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return res;
    }

    public ResultSet search(int id) {
        //this.id = id;
//        System.out.println("Please Enter Student ID");
       // id = sc.nextInt();
        ResultSet res = null;
        try {
            query = "select* from student where id='" + id + "'";
            res = stmt.executeQuery(query);
            
//            while (res.next()) {
//                id = res.getInt("id");
//                name = res.getString("name");
//                age = res.getInt("age");
//                phone = res.getString("phone");
//                System.out.println(id + " - " + name + " - " + age + " - " + phone);
////            stmt.executeQuery(query);
//            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return res;
    }
  
//    public void Update() throws SQLException {
//        //search();
//        System.out.println("what do you want to update \n1- name 2- age 3- phone 4- all");
//        int ch = sc.nextInt();
//        switch (ch) {
//            case 1:
//                updateName();
//                break;
//            case 2:
//                updateAge();
//                break;
//            case 3:
//                updatePhone();
//                break;
//            case 4:
//                updateAll();
//                break;
//            default:
//                System.out.println("Invalid Choice");
//        }
//    }
//
//    public void updateName() throws SQLException {
//        System.out.println("Please Enter new Student name:");
//        name = sc.next();
//        query = "update student set name ='" + name + "'"
//                + "where id = '" + id + "'";
//
//        stmt.executeUpdate(query);
//        System.out.println("Name is Updated");
//
//    }
//
//    public void updateAge() throws SQLException {
//        System.out.println("Please Enter new Student age:");
//        age = sc.nextInt();
//        query = "update student set age = '" + age + "' "
//                + "where id = '" + id + "'";
//
//        stmt.executeUpdate(query);
//        System.out.println("Age is Updated");
//    }
//
//    public void updatePhone() throws SQLException {
//        System.out.println("Please Enter new Student phone:");
//        phone = sc.next();
//
//        query = "update student set  phone = '" + phone + "' "
//                + "where id = '" + id + "'";
//
//        stmt.executeUpdate(query);
//        System.out.println("Phone is Updated");
//    }

//    public void updateAll() throws SQLException {
//    try{
//        System.out.println("Please Enter new Student name:");
//        name = sc.next();
//        System.out.println("Please Enter new Student age:");
//        age = sc.nextInt();
//        System.out.println("Please Enter new Student phone:");
//        phone = sc.next();
//
//        query = "update student set name ='" + name + "' , age = '" + age + "' , phone = '" + phone + "' "
//                + "where id = '" + id + "'";
//
//        stmt.executeUpdate(query);
//        System.out.println("Data Updated");
//        }
//           catch(Exception e){
//                System.out.println(e);
//            }
//
//    }
    public void update(int id, String name , int age, String phone) throws SQLException {
        try{
        query = "update student set name ='" + name + "' , age = '" + age + "' , phone = '" + phone + "' "
                + "where id = '" + id + "'";

        stmt.executeUpdate(query);
         JOptionPane.showMessageDialog(null, "Updated", " Data Updated ", JOptionPane.INFORMATION_MESSAGE);
        
    }catch(Exception e){
         JOptionPane.showMessageDialog(null, "Error"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void delete() {
        int ch = 0;
        System.out.println("What do you need\n1- Delete All Student __ 2- Delete by ID");
        ch = sc.nextInt();
        switch(ch){
            case 1: deleteAll(); break;
            //case 2: deleteById(); break;
            default:System.out.println("Invalid Choice");
        }

    }

    public void deleteAll() {
        try {
            query = "delete from student";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, " All data deleted ", "Error", JOptionPane.INFORMATION_MESSAGE);
       
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteById(int id) {
        //search();
        try {
            query = "delete from student where id='" + id + "'";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, " Select data deleted ", "Error", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        
        }
    }
    public void Exit(){
        System.out.println("Bye Bye ...");
        System.exit(0);
    }

}
