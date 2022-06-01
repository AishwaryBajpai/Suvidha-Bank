package project1;
import java.sql.*;
import javax.swing.JFrame;

public class Project1 {

     
    public static void main(String[] args) throws Exception {
       login log=new login();
       log.setSize(415, 440);
       log.setLocation(400, 150);
       log.setVisible(true);
       log.setResizable(false);
      log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
