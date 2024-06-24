
package dbcrudforevidence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBUtill;


public class DbcrudForEvidence {
    
    public static DBUtill db = new DBUtill();
    public static PreparedStatement ps;
    public static ResultSet rs;
    public static String sql = "";

    public static void main(String[] args) {
        
//        saveData("Nusrat", "nusrat@gmail.com", "Mirpur", "2432434");
//        deleteInfo(2);
        updateInfo("Nusrat Jahan", "njNusrat@gmail.com", "Mirpur", "656454", 1);
        showInfo();
        
    }
    
    public static void saveData(String name, String email, String address, String cell){
    
        sql = "insert into student(name,email,address,cell) values(?,?,?,?)";
        
        try {
            ps = db.getCon().prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, cell);
            
            ps.executeUpdate();
            
            ps.close();
            db.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DbcrudForEvidence.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public static void showInfo(){
    
        sql = "select * from student";
        
        try {
            ps = db.getCon().prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                String id = rs.getString("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String cell = rs.getString("cell");
                
                System.out.println("ID: " + id+ "\t Name: "+name + "\t Email: "
                        + email+ "\t Address: " + address + "\t Cell: " + cell);
            
            }
            ps.close();
            rs.close();
            db.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DbcrudForEvidence.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public static void deleteInfo(int id){
    
        sql = "delete from student where id=?";
        
        try {
            ps = db.getCon().prepareStatement(sql);
            
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
            ps.close();
            db.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DbcrudForEvidence.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public static void updateInfo(String name, String email, String address, String cell, int id){
    
        sql = "update student set name=?, email=?, address=?, cell=? where id=?";
        
        try {
            ps = db.getCon().prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, cell);
            ps.setInt(5, id);
            
            ps.executeUpdate();
            
            ps.close();
            db.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DbcrudForEvidence.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
