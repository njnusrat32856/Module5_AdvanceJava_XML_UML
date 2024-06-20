
package dbcrud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBUtill;

public class DBCrud {
    
    static PreparedStatement ps;
    static ResultSet rs;

    public static void main(String[] args) {
        
        DBUtill dbu = new DBUtill();
        
        String insertSql = " insert into student(name, email, address, cellNo)"
                + "values(?,?,?,?)";
        
        try {
            ps = dbu.getConnect().prepareStatement(insertSql);
            
            ps.setString(1, "Nusrat Jahan");
            ps.setString(2, "nusrat@gamil.com");
            ps.setString(3, "Mirpur, Dhaka");
            ps.setString(4, "23423312");
            
            ps.executeUpdate();
            
            ps.close();
            dbu.getConnect().close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
            Logger.getLogger(DBCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
