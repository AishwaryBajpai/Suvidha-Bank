package project1;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class transactionDetails extends JPanel {
      JTable jt;
      JScrollPane js;
      transactionDetails() throws Exception{
           String[] header={"Description","Date Time","Amount","Balance"};
           setLayout(new BorderLayout());
           DefaultTableModel model=new DefaultTableModel();
            model.setColumnIdentifiers(header);
           jt=new JTable(model);
           jt.setVisible(true);
           jt.setPreferredScrollableViewportSize(new Dimension(450,63));
           jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
           jt.setEnabled(false);
           jt.setFillsViewportHeight(true);
           
          // scrollbar
           js=new JScrollPane(jt); 
           js.add(new JScrollBar());
          js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
          js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
           js.setVisible(true);
          
          Developconn dp=new Developconn();
          dp.stm=dp.conn.prepareStatement("select * from transactions where accno= ?");
          int st=loggedUser.userid;
          dp.stm.setInt(1, st);
          ResultSet rs=dp.stm.executeQuery();
           
           int i=0;
          while(rs.next())
          {   i++;
              model.addRow(new Object[]{rs.getString(2),rs.getTimestamp(3),rs.getString(4),rs.getString(5)});
          }
          if(i==0)
              JOptionPane.showMessageDialog(null, "No transactions available");
          rs.close();
          dp.stm.close();
          dp.conn.close();
          // add(jt);
           add(js);
      }
    public static void main(String args[]) throws Exception{
        JFrame trans=new JFrame("Transaction History");
        trans.setVisible(true);
        trans.setLocation(400,200);
        trans.setSize(600, 300);
        trans.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        transactionDetails tp=new transactionDetails();
        trans.add(tp);
    }
}
