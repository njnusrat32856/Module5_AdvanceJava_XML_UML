
package jdbcapplicationgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCApplicationGui {
    
    private static Connection connect = null;
    private static String url = "jdbc:mysql://localhost:3306/test_jdbc";
    private static String user = "root";
    private static String password = "1234";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    
    
    public static void main(String[] args) {
        
        
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            Class.forName(driver);
            
            connect = DriverManager.getConnection(url, user, password);
            
            String sql = "select * from student";
            
            ps = connect.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String cell = rs.getString("cell");
                
                System.out.println("Id: "+ id + "\nName: " + name +
                        "\nEmail: " + email + "\nCell no: " + cell);
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            
            System.out.println("Driver not found");
            System.out.println("SQL Exception" + ex.getMessage());
            
            Logger.getLogger(JDBCApplicationGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
