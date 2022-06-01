package project1;
import java.sql.*;
public class loggedUser {
    static int userid,pin,regno,bl;
    static String acctype,balance;
    static String address,email,name,dob,mobno;
     PreparedStatement smt;
 
    loggedUser(){}
    public static boolean check(int userid,int pin) throws Exception
    {
       Developconn dt=new Developconn(); 
       dt.stm=dt.conn.prepareStatement("Select * from accounts where accno=?");
       dt.stm.setInt(1, userid);
       ResultSet rs=dt.stm.executeQuery();
       int s=0;
       while(rs.next())
       { 
         loggedUser.userid=rs.getInt(1);
         loggedUser.pin=rs.getInt(2);
          loggedUser.balance=rs.getString(3);
         loggedUser.regno=rs.getInt(4);
         s++;
       } 
       rs.close();
       dt.stm.close();
       if(s==0)
           return false;
      PreparedStatement stm1=dt.conn.prepareStatement("Select * from user where  regno=?");
      stm1.setInt(1,loggedUser.regno);
      ResultSet rs1=stm1.executeQuery();
      
      while(rs1.next())
      {
       loggedUser.name=rs1.getString(2);
       loggedUser.mobno=rs1.getString(4);
       loggedUser.acctype=rs1.getString(5);
       loggedUser.address=rs1.getString(8);
       loggedUser.email=rs1.getString(9);
      }
      rs1.close();
      stm1.close();
      dt.conn.close();
      bl=Integer.parseInt(balance);
      if((loggedUser.userid==userid)&&(loggedUser.pin==pin))
          return true;
      return false;
    }
   
    public static boolean updateEmail(String gp) throws Exception{
       
            if(loggedUser.email!=null&&loggedUser.email.equals(gp))
                 return true;
            Developconn dm=new Developconn();
            dm.stm=dm.conn.prepareStatement("Update user set email=? where regno=?");
            dm.stm.setString(1,gp);
            dm.stm.setInt(2,loggedUser.regno);
            email=gp;
            boolean sd=dm.stm.execute();
            dm.stm.close();
            dm.conn.close();
            return !sd;
       
    }
          
     public static boolean updateMob(String gp) throws Exception{
         
            if(mobno.equals(gp))
                return true;
            Developconn dm=new Developconn();
           
            dm.stm=dm.conn.prepareStatement("Update user set mobno=? where regno=?");
            dm.stm.setString(1,gp);
            dm.stm.setInt(2,loggedUser.regno);
            mobno=gp;
            boolean sd=dm.stm.execute();
            dm.stm.close();
            dm.conn.close();
            return !sd;
    }  
    public static boolean updateAddress(String gp) throws Exception{
         
            if(address.equalsIgnoreCase(gp))
                  return true;
              Developconn dm=new Developconn();
             
              dm.stm=dm.conn.prepareStatement("Update user set address=? where regno=?");
               dm.stm.setString(1,gp);
              dm.stm.setInt(2,loggedUser.regno);
              address=gp;
               boolean sd=dm.stm.execute();
              dm.stm.close();
              dm.conn.close();
              return sd;     
    }
    public static boolean updateBalance() throws Exception{
       
       Developconn dm=new Developconn();
       dm.stm=dm.conn.prepareStatement("update accounts set amount=? where accno=?");
       dm.stm.setString(1,loggedUser.balance);
       dm.stm.setInt(2,loggedUser.userid);
      boolean df= dm.stm.execute();
       dm.stm.close();
       dm.conn.close();
      // balance=Integer.toString(bl);
        return true;    
    }
    
    public static boolean checkformat(String gp,String forwhich){
        
         switch(forwhich)
         {
             case "Deposit": return gp.matches("[1-9][0-9]*"); 
             case "Withdraw": return gp.matches("[1-9][0-9]*");
             case "MobNo" : return gp.matches("[1-9][0-9]{9}");
             case "Mail"  : return gp.matches("[A-Za-z0-9]+@(.+).com$");
             case "Address" : return gp.matches("[[A-Za-z0-9]+\\s]+");
            // case "Dob"     : return gp.matches("[1-9][0-9]{3}-[[0][1-9]|[1][1-2]]-[0-3][1-9]");
             case "Name"    : return gp.matches("[^0-9]*");
         }
        
        return false;  
    }
    public static boolean checkwithdraw(int amnt) throws Exception{
        if(bl>=amnt)
        {   bl-=amnt;
            balance=Integer.toString(bl);
            
            return loggedUser.UpdateTransactions("Money Debited",Integer.toString(amnt));
        }
        return false;
    }
    public static boolean UpdateTransactions(String desc,String amount) throws Exception{
        Developconn dp=new Developconn();
        String query="Insert into transactions values(?,?,CURRENT_TIMESTAMP,?,?)";
        dp.stm=dp.conn.prepareStatement(query);
        dp.stm.setInt(1,userid);
        dp.stm.setString(2, desc);
        dp.stm.setString(3,amount);
        dp.stm.setString(4,balance);
        dp.stm.executeUpdate();
        dp.stm.close();
        dp.conn.close();
        return true;
    }
     
}
