/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gems;
import java.sql.*;
/**
 *
 * @author ASUS
 */
public class ConnectionProvider {
    public static Connection getCon()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GEMS;selectMethod=cursor;" + "encrypt=true;trustServerCertificate=true;", "sa", "123456");
            
            return con;
        } catch (Exception e) {
            return null;
        }
    }
}