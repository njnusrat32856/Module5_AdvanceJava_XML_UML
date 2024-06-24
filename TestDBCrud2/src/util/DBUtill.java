
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtill {

    private String url= "jdbc:mysql://localhost:3306/dbcrud2";
    private String user = "root";
    private String password = "1234";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private Connection con= null;
    
    public Connection getCon(){
    
        try {
            Class.forName(driver);
            
            con = DriverManager.getConnection(url, user, password);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBUtill.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
}
