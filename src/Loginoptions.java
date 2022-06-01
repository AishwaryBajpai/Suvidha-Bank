package project1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Loginoptions extends JFrame implements ActionListener{
    private JPanel jpanel[]=new JPanel[7];
    private JLabel jlabel[]=new JLabel[23];
    private JPanel full;
    private JLabel logo,out;
    private JTextField jtext[]=new JTextField[10];
    private JButton edit[]=new JButton[4];
    private JButton save[]=new JButton[4];
    private JButton show,match,deposit,match1,withdraw,transactions,logout;
    private JPasswordField pinp,pinp1,pinp2,pinp3;
    private JTabbedPane opt;    
   
    public Loginoptions() throws IOException{
      //  this.setBackground(Color.WHITE);
      super("Suvidha Bank");
      setLayout(null);
        full=new JPanel();
        full.setSize(1300,1000);
        full.setBackground(Color.WHITE);
        add(full);
        full.setLayout(null);
         Image img= ImageIO.read(getClass().getResource("resources/logo.png"));
          logo=new JLabel(new ImageIcon(img));
          logo.setBounds(20,5,120,110);
          logo.setVisible(true);
       // logo.setBackground(Color.magenta);
        full.add(logo);
        
        //for headings
        jlabel[0]=new JLabel("Suvidha Bank");
        jlabel[0].setFont(new Font("Arial",Font.BOLD,30));
        jlabel[0].setBounds(150, 40, 300,40);  
       full.add(jlabel[0]);
         
        //for liner
        jpanel[0]=new JPanel();
        jpanel[0].setBackground(Color.black);
        jpanel[0].setBounds(5, 120, 1270, 5);
        full.add(jpanel[0]);
        
        //for logout
          logout=new JButton();
          JLabel out=new JLabel("LogOut");
          Image img1 = ImageIO.read(getClass().getResource("resources/logpanel.png"));
          ImageIcon ic=new ImageIcon(img1);
          logout.setIcon(ic);
          logout.setFocusPainted(false);
          logout.setBorderPainted(false);
          logout.setToolTipText("Logout");
          logout.setBackground(Color.WHITE);
          logout.setBorderPainted(false);
          logout.setBounds(1100,20,170,70);
          out.setBounds(1165,80,50,30 );
         full.add(logout);
         full.add(out);
         logout.addActionListener(this);
          
        //for options
        opt=new JTabbedPane();
        opt.setBounds(40,150,1200,450);
        Border bd=BorderFactory.createLineBorder(Color.black);
        opt.setBorder(bd);
        opt.setBackground(Color.orange);
         
        //panel for profile
         jpanel[1]=new JPanel();
         jpanel[1].setBackground(Color.white);
         jpanel[1].setLayout(null);
         
         //userID
         jlabel[1]=new JLabel("UserID  :");
         jlabel[1].setBounds(200, 50, 150, 50);
         jlabel[1].setFont(new Font("Monospaced",Font.PLAIN,20));
         jlabel [6]=new JLabel(" "+loggedUser.userid);
         jlabel[6].setBounds(400, 50, 200, 50);
         jlabel[6].setFont(new Font("Arial",Font.PLAIN,30));
         
         //username
         jlabel[2]=new JLabel("UserName  :");
         jlabel[2].setBounds(200, 100, 150, 50);
         jlabel[2].setFont(new Font("Monospaced",Font.PLAIN,20));
         jtext[0]=new JTextField(30);
         jtext[0].setText(loggedUser.name);
         jtext[0].setEditable(false);
         jtext[0].setBounds(400, 110, 350, 30);
         
         //Mobile
         jlabel[3]=new JLabel("Mobile No : ");
         jlabel[3].setBounds(200,150,150,50);
         jlabel[3].setFont(new Font("Monospaced",Font.PLAIN,20));
         jtext[1]=new JTextField(10);
         jtext[1].setText(loggedUser.mobno);
         jtext[1].setEditable(false);
         jtext[1].setBounds(400, 160, 350, 30);
          edit[1]=new JButton("Edit");
         edit[1].setBounds(800,160,100,30);
         save[1]=new JButton("Save");
         save[1].setBounds(930, 160, 100, 30);
          edit[1].addActionListener(this);
         save[1].addActionListener(this);
         
         //Address
         jlabel[4]=new JLabel("Address  :");
         jlabel[4].setBounds(200,200,150,50);
         jlabel[4].setFont(new Font("Monospaced",Font.PLAIN,20));
         jtext[2]=new JTextField(100);
         jtext[2].setText(loggedUser.address);
         jtext[2].setEditable(false);
         jtext[2].setBounds(400, 210, 350, 30);
          edit[2]=new JButton("Edit");
         edit[2].setBounds(800,210,100,30);
         save[2]=new JButton("Save");
         save[2].setBounds(930, 210, 100, 30);
         edit[2].addActionListener(this);
         save[2].addActionListener(this);
         
         //Email
         jlabel[5]=new JLabel("Email    :");
         jlabel[5].setBounds(200,250,150,50);
         jlabel[5].setFont(new Font("Monospaced",Font.PLAIN,20));
         jtext[3]=new JTextField(50);
         if(loggedUser.email==null)
           jtext[3].setText("Not Registered");
         else
           jtext[3].setText(loggedUser.email);
         jtext[3].setEditable(false);
         jtext[3].setBounds(400, 260, 350, 30);
         
          edit[3]=new JButton("Edit");
         edit[3].setBounds(800,260,100,30);
         save[3]=new JButton("Save");
         save[3].setBounds(930, 260, 100, 30);
          edit[3].addActionListener(this);
         save[3].addActionListener(this);
         
         //adding every component in profile panel which is jpanel[1]
         jpanel[1].add(jlabel[1]); jpanel[1].add(jlabel[2]); jpanel[1].add(jlabel[3]);jpanel[1].add(jlabel[4]);
         jpanel[1].add(jlabel[5]);jpanel[1].add(jlabel[6]); jpanel[1].add(jtext[0]);jpanel[1].add(jtext[1]);jpanel[1].add(jtext[2]);jpanel[1].add(jtext[3]);
         jpanel[1].add(edit[1]);jpanel[1].add(save[1]);jpanel[1].add(edit[2]);jpanel[1].add(save[2]);
         jpanel[1].add(edit[3]);jpanel[1].add(save[3]);

        //panel for View Balance
          jpanel[2]=new JPanel(); jpanel[2].setBackground(Color.white); jpanel[2].setLayout(null);
          jlabel[7]=new JLabel("UserID :");
          jlabel[7].setBounds(250, 50, 300, 50);
          jlabel[7].setFont(new Font("Monospaced",Font.PLAIN,30));
          jlabel [8]=new JLabel(""+loggedUser.userid);
          jlabel[8].setBounds(550, 50, 400, 50);
          jlabel[8].setFont(new Font("Arial",Font.PLAIN,35));
          
          jlabel[9]=new JLabel("Account type :");
          jlabel[9].setBounds(250,120,300,50);
          jlabel[9].setFont(new Font("Monospaced",Font.PLAIN,30));
          jlabel[10]=new JLabel("Savings ");
          jlabel[10].setBounds(550,120,200,50);
          jlabel[10].setFont(new Font("Arial",Font.PLAIN,35));
          jlabel[11]=new JLabel("Balance :");
          jlabel[11].setBounds(250,190,300,50);
          jlabel[11].setFont(new Font("Monospaced",Font.PLAIN,30));
          jlabel[12]=new JLabel(""+ loggedUser.balance+ " /- INR ");
          jlabel[12].setBounds(550,190,400,50);
          jlabel[12].setFont(new Font("Arial",Font.PLAIN,35));
         
          
          jpanel[2].add(jlabel[7]); jpanel[2].add(jlabel[8]);jpanel[2].add(jlabel[9]);
          jpanel[2].add(jlabel[10]);jpanel[2].add(jlabel[11]);jpanel[2].add(jlabel[12]);
          
          //panel for Deposit
          jpanel[3]=new JPanel();jpanel[3].setBackground(Color.white); jpanel[3].setLayout(null);
          
          jlabel[13]=new JLabel("UserID:");
          jlabel[13].setBounds(250, 50, 300, 50);
          jlabel[13].setFont(new Font("Monospaced",Font.PLAIN,20));
          jlabel [14]=new JLabel(""+loggedUser.userid);
          jlabel[14].setBounds(550, 50, 300, 50);
          jlabel[14].setFont(new Font("Arial",Font.PLAIN,30));
          
          jlabel[15]=new JLabel("Amount :");
          jlabel[15].setBounds(250,120,300,50);
          jlabel[15].setFont(new Font("Monospaced",Font.PLAIN,20));
          jtext[4]=new JTextField(4);
          jtext[4].setBounds(550, 125, 300, 40);
          jtext[4].setFont(new Font("Arial",Font.PLAIN,25));
          
    
          jlabel[16]=new JLabel("Pin  :");
          jlabel[16].setBounds(250,190,300,50);
          jlabel[16].setFont(new Font("Monospaced",Font.PLAIN,20));
          pinp=new JPasswordField(4); 
          pinp.setText(""+loggedUser.pin);
          pinp.setBounds(550,195,300,40);
          pinp.setEditable(false);
          pinp.setFont(new Font("Arial",Font.PLAIN,30));
          
          jlabel[17]=new JLabel("Confirm Pin :");
          jlabel[17].setBounds(250,260,300,50);
          jlabel[17].setFont(new Font("Monospaced",Font.PLAIN,20));
          pinp2=new JPasswordField(4);
          pinp2.setBounds(550, 265, 300, 40);
          pinp2.setFont(new Font("Arial",Font.PLAIN,25));
          
          match=new JButton("Match");
          match.setBounds(900,265,100,40);
          match.addActionListener(this);
          
          deposit=new JButton("Deposit");
          deposit.setBounds(530,330,100,40);
          deposit.addActionListener(this);
          
      jpanel[3].add(jlabel[13]);jpanel[3].add(jlabel[14]);jpanel[3].add(jlabel[15]);jpanel[3].add(pinp);
      jpanel[3].add(jlabel[16]);jpanel[3].add(jtext[4]);jpanel[3].add(pinp2);jpanel[3].add(jlabel[17]);
      jpanel[3].add(match);jpanel[3].add(deposit);
          
        //panel for withdraw
        jpanel[4]=new JPanel(); jpanel[4].setBackground(Color.white); jpanel[4].setLayout(null);
        
          jlabel[18]=new JLabel("UserID:");
          jlabel[18].setBounds(250, 50, 300, 50);
          jlabel[18].setFont(new Font("Monospaced",Font.PLAIN,20));
          jlabel [19]=new JLabel(""+loggedUser.userid);
          jlabel[19].setBounds(550, 50, 300, 50);
          jlabel[19].setFont(new Font("Arial",Font.PLAIN,30));
          
          jlabel[20]=new JLabel("Amount :");
          jlabel[20].setBounds(250,120,300,50);
          jlabel[20].setFont(new Font("Monospaced",Font.PLAIN,20));
          jtext[6]=new JTextField(5);
          jtext[6].setBounds(550, 125, 300, 40);
          jtext[6].setFont(new Font("Arial",Font.PLAIN,25));
          
          jlabel[21]=new JLabel("Pin  :");
          jlabel[21].setBounds(250,190,300,50);
          jlabel[21].setFont(new Font("Monospaced",Font.PLAIN,20));
          pinp1=new JPasswordField(4); 
          pinp1.setText(""+loggedUser.pin);
          pinp1.setBounds(550,195,300,40);
          pinp1.setEditable(false);
          pinp1.setFont(new Font("Arial",Font.PLAIN,30));
          
          jlabel[22]=new JLabel("Confirm Pin :");
          jlabel[22].setBounds(250,260,300,50);
          jlabel[22].setFont(new Font("Monospaced",Font.PLAIN,20));
          pinp3=new JPasswordField(4);
          pinp3.setBounds(550, 265, 300, 40);
          pinp3.setFont(new Font("Arial",Font.PLAIN,25));
          
          match1=new JButton("Match");
          match1.setBounds(900,265,100,40);
          match1.addActionListener(this);
          
          withdraw=new JButton("Withdraw ");
          withdraw.setBounds(530,330,100,40);
          withdraw.addActionListener(this);
          
          jpanel[4].add(jlabel[18]); jpanel[4].add(jlabel[19]); jpanel[4].add(jlabel[20]);
          jpanel[4].add(jlabel[21]); jpanel[4].add(jlabel[22]); jpanel[4].add(jtext[6]);
          jpanel[4].add(pinp3); jpanel[4].add(pinp1); jpanel[4].add(match1); jpanel[4].add(withdraw);
          
        // panel for others
        jpanel[5]=new JPanel(); jpanel[5].setBackground(Color.white); jpanel[5].setLayout(null);
        transactions=new JButton("view Transactions");
        transactions.setToolTipText("Tap to view transaction history");
        transactions.setBounds(100, 150, 200, 50);
        jpanel[5].add(transactions);
        transactions.addActionListener(this);
 
        //profile 
        opt.addTab("Profile",jpanel[1]);
        opt.addTab("View Balance",jpanel[2]);
        opt.addTab("Deposit",jpanel[3]);
        opt.addTab("Withdraw",jpanel[4]);
        opt.addTab("others",jpanel[5]);
        full.add(opt);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
        if(e.getSource()==match){
            int enteredpin=Integer.parseInt(String.valueOf(pinp2.getPassword()));
            if(loggedUser.pin==enteredpin){ pinp2.setEditable(false); } 
            else{JOptionPane.showMessageDialog(jpanel[3], "Incorrect Pin");}
            return ;
        }
        if(e.getSource()==deposit)
        {  if(!pinp2.isEditable())
           {
            try {
                if(!loggedUser.checkformat(jtext[4].getText(), "Deposit"))
                {JOptionPane.showMessageDialog(jpanel[3],"fill amount in correct format");
                    return ;
                }
                int dp=Integer.parseInt(jtext[4].getText());
                loggedUser.bl+=dp;
                loggedUser.balance=Integer.toString(loggedUser.bl);
                if(loggedUser.updateBalance()){
                  loggedUser.UpdateTransactions("Money Deposited",jtext[4].getText());
                JOptionPane.showMessageDialog(jpanel[3], jtext[4].getText()+" Rs is deposited in your bank A/C");
                pinp2.setEditable(true); pinp2.setText("");jtext[4].setText("");
                jlabel[12].setText(""+loggedUser.balance+" /-INR");jtext[5].setText("");}
            } catch (Exception ex) {}
           }
           else
              JOptionPane.showMessageDialog(jpanel[3],"First confirm the pin");
           return ;
        }
        if(e.getSource()==match1)
        {   int enteredpin=Integer.parseInt(String.valueOf(pinp3.getPassword()));
            if(loggedUser.pin==enteredpin){ pinp3.setEditable(false); } 
            else{JOptionPane.showMessageDialog(jpanel[3], "Incorrect Pin");}
            return;
        }
        if(e.getSource()==withdraw)
        {   
            if(!pinp3.isEditable())
            { 
               if(!loggedUser.checkformat(jtext[6].getText(),"Withdraw")){
                   JOptionPane.showMessageDialog(jpanel[4],"Amount is not in correct format"); return;}
              try {
                 int amnt=Integer.parseInt(jtext[6].getText());
                 if(loggedUser.checkwithdraw(amnt))
                 { loggedUser.updateBalance();
                   JOptionPane.showMessageDialog(jpanel[4],"Your A/c has been debited by "+jtext[6].getText()+" INR");
                   pinp3.setEditable(true);pinp3.setText(""); jtext[6].setText("");
                   jlabel[12].setText(" "+loggedUser.balance+" /- INR");
                 }
                  else
                  JOptionPane.showMessageDialog(jpanel[3],"Not enough balance in your A/c available to proceed this transaction");
              } catch (Exception ex) {}
               
            }
            else
               JOptionPane.showMessageDialog(jpanel[3],"First confirm the pin");
            return;
        }
        
        if(e.getSource()==transactions){
            try {
                transactionDetails.main(null);
            } catch (Exception ex) {
              //  Logger.getLogger(Loginoptions.class.getName()).log(Level.SEVERE, null, ex);
            } 
             return;
        }
        if(e.getSource()==logout)
        {
            login lg;
            try {
                lg = new login();
                 lg.setSize(415, 440);
                 lg.setLocation(400, 150);
                 lg.setVisible(true);
                 lg.setResizable(false);
                 lg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 this.dispose();
                 return ;
            } catch (IOException ex) {
              //  Logger.getLogger(Loginoptions.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
       
        if(e.getSource()==edit[1]) {jtext[1].setEditable(true);return;}
        if(e.getSource()==edit[2]) {jtext[2].setEditable(true);return;}
        if(e.getSource()==edit[3]) {jtext[3].setEditable(true); return;}
        
        if(e.getSource()==save[1]&&jtext[1].isEditable()) {
             if(!loggedUser.checkformat(jtext[1].getText(),"MobNo")){ JOptionPane.showMessageDialog(jpanel[4],"Mob no is not in correct format"); return;}
            try {
                if(loggedUser.updateMob(jtext[1].getText())){
                    jtext[1].setEditable(false);
                    JOptionPane.showMessageDialog(jpanel[1],"Mobile no Successfully updated");
                }
                else{
                     JOptionPane.showMessageDialog(jpanel[1],"Invalid Mobile no");
                }} catch (Exception ex){}
         }
         else if(e.getSource()==save[2]&&jtext[2].isEditable()){ 
             if(!loggedUser.checkformat(jtext[2].getText(),"Address")){ JOptionPane.showMessageDialog(jpanel[4],"Address is not in correct format"); return;}
            try {
                if(loggedUser.updateAddress(jtext[2].getText())){
                    jtext[2].setEditable(false);
                    JOptionPane.showMessageDialog(jpanel[1],"Address Successfully updated");
                }
                else{
                    JOptionPane.showMessageDialog(jpanel[1],"Address format is not correct");
                } } catch (Exception ex) {}
         }
        else
        {
            if(!loggedUser.checkformat(jtext[3].getText(),"Mail")){ JOptionPane.showMessageDialog(jpanel[4],"Email is not in correct format"); return;}
            try {
                if(loggedUser.updateEmail(jtext[3].getText()))
                {
                    jtext[3].setEditable(false);
                    JOptionPane.showMessageDialog(jpanel[1],"Email Successfully updated");
                }
                else{
                JOptionPane.showMessageDialog(jpanel[1],"Invalid Email");      
              }
            } catch (Exception ex) {}
        }
    }
}
