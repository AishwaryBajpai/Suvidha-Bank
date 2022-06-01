package project1;
import java.sql.*;
public class Developconn {
    Connection conn;
    Statement st;
    PreparedStatement stm;
     public Developconn() throws Exception{
         conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root", "007@A151");
       
         if(conn!=null)
             System.out.println("Connection establish from database");
         else
             System.out.println("No connection from database"); 
     }
}
