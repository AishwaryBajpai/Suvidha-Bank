package project1;


import java.sql.*;

public class User {
    static int accno;
    static int pin;
    static int regno;
    
    public static void getnums() throws Exception{
        Developconn dp=new Developconn();
       Statement st=dp.conn.createStatement();
        ResultSet rs=st.executeQuery("Select * from forms");
        int one=0,two=0,three=0;
        while(rs.next())
        {
            one=rs.getInt(1);
            two=rs.getInt(2);
            three=rs.getInt(3);
        }
        
        regno=one++;
        accno=two++;
        pin=three;
       PreparedStatement str=dp.conn.prepareStatement("Update forms set reg=?,acc=?,pin=? where reg=?");
       str.setInt(1,one);
       str.setInt(2,two);
       str.setInt(3,three+2);
       str.setInt(4,regno);
       
       str.execute();
    }
    
    public static boolean Insert(String am,String name,Date dob,String mob,String add,String gen,String Acc) throws Exception {
           
     Developconn dp=new Developconn();
     String qu="Insert into user values(?,?,?,?,?,?,?,?,'')";
     PreparedStatement st=dp.conn.prepareStatement(qu);
     st.setInt(1, regno);
     st.setString(2, name);
     st.setDate(3, dob);
     st.setString(4, mob);
     st.setString(5, Acc);
     st.setInt(6, accno);
     st.setString(7, gen);
     st.setString(8, add);
     st.executeUpdate();
     st.close();
     
     qu="Insert into accounts values(?,?,?,?)";
     PreparedStatement st1=dp.conn.prepareStatement(qu);
     st1.setInt(1,accno);
     st1.setInt(2,pin);
     st1.setString(3,am);
     st1.setInt(4,regno);
     st1.executeUpdate();
     st1.close();
     dp.conn.close();
     
     return true; 
    }
}


