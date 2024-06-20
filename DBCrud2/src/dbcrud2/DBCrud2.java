
package dbcrud2;

import entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBUtill;

public class DBCrud2 {
    
    static PreparedStatement ps;
    static ResultSet rs;
    static DBUtill dbu = new DBUtill();

    public static void main(String[] args) {
        
        Student student = new Student();
        
        List<Student> studentList = getById(2);
        
        student.setName("Mostofa Rezvi");
        student.setEmail("rezvi@gmail.com");
        student.setAddress("Azimpur, Dhaka");
        student.setCellNo("18976689");
        student.setId(studentList.get(0).getId());
        
        
//        saveData();
//        editData(student);
//        deleteData(1);
        showData();
        
        
    }
    public static void saveData(){
    
        String insertSql = " insert into student(name, email, address, cellNo)"
                + "values(?,?,?,?)";
    
        try {
            ps = dbu.getConnect().prepareStatement(insertSql);
            
            ps.setString(1, "Raju Ahmed");
            ps.setString(2, "raju@gamil.com");
            ps.setString(3, "Azimpur, Dhaka");
            ps.setString(4, "09873312");
            
            ps.executeUpdate();
            
            ps.close();
            dbu.getConnect().close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBCrud2.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public static void showData(){
    
        String selectSql = "select * from student";
        
        try {
            ps = dbu.getConnect().prepareStatement(selectSql);
            
            rs =ps.executeQuery();
            
            while(rs.next()){
            
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String cell = rs.getString("cellNo");
                
                System.out.println("Id is " + id + " Name: " + name + " Email: " + email + " Address: " + address
                        + " Cell no: " + cell);
            }
            
            ps.close();
            rs.close();
            
            dbu.getConnect().close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBCrud2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void editData(Student stu){
    
        String editSql = "update student set name=?, email=?, address=?, cellNo=? "
                + "where id=?";
        
        try {
            ps = dbu.getConnect().prepareStatement(editSql);
            
            ps.setString(1, stu.getName());
            ps.setString(2, stu.getEmail());
            ps.setString(3, stu.getAddress());
            ps.setString(4, stu.getCellNo());
            ps.setInt(5, stu.getId());
            
            ps.executeUpdate();
            ps.close();
            dbu.getConnect().close();
            
            System.out.println("Edit Successfull");
            
        } catch (SQLException ex) {
            Logger.getLogger(DBCrud2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static List<Student> getById(int id){
    
        List<Student> studentList = new ArrayList<>();
        
        String sql = "select * from student where id=?";
        
        try {
            ps = dbu.getConnect().prepareStatement(sql);
            
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                Student s = new Student(
                
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("cellNo")
                );
                
                studentList.add(s);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBCrud2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return studentList;
    }
    public static void deleteData(int id){
    
        String deleteSql = "delete from student where id=?";
        
        try {
            ps = dbu.getConnect().prepareStatement(deleteSql);
            
            ps.setInt(1, id);
            
            ps.executeUpdate();
            ps.close();
            
            dbu.getConnect().close();
            
            System.out.println("Data Deleted");
            
        } catch (SQLException ex) {
            Logger.getLogger(DBCrud2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}
