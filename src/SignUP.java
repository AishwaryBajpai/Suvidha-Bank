package project1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;



public class SignUP extends JFrame implements ActionListener{
         private JPanel bdt,pnl,s1,s2;
         private JLabel l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18;
         private JTextField j1,j2,j3,j5,j6,j7;
         private JPasswordField jf,jf1;
         private JFormattedTextField jd,j4;
         private JRadioButton rb1,rb2,rb3;
         private JButton jb,jb1,jb2;
         private JComboBox jp;
         private ButtonGroup bg;
          public SignUP()throws Exception
          {   
              l6=new JLabel("RMD Bank");
              bdt=new JPanel();
              s1=new JPanel();
              s2=new JPanel();
              j1=new JTextField(5);
              jf=new JPasswordField(5);
              jf1=new JPasswordField(4);
              l7=new JLabel("Form No : ");
              l8=new JLabel("A/C No  : ");
              l9=new JLabel("Pin     : ");
              l10=new JLabel("Gender : ");
              l11=new JLabel("Account Type : ");
              l12=new JLabel("Amount : ");
              rb1=new JRadioButton("Male");
              rb2=new JRadioButton("Female");
              rb3=new JRadioButton("Others");
              String type[]={"","Savings","Credit"};
              
              jb=new JButton("Clear");
              jb1=new JButton("Clear");
              jb2=new JButton("Create Account");
              
              jp=new JComboBox(type);
              
              j4=new JFormattedTextField();

              
              l13=new JLabel("Account Details");
              l14=new JLabel("Personal Details");
              l15=new JLabel("Name :");
              l16=new JLabel("DOB :");
              l17=new JLabel("Mobile No :");
              l18=new JLabel("Address :");
              DateFormat dp=new SimpleDateFormat("yyyy-MM-dd");
              jd=new JFormattedTextField(dp);
              jd.setColumns(15);
              jd.setValue(0);
              j5=new JTextField(30);
              j6=new JTextField(50);
              
            
           
              j7=new JTextField();
              j7.setColumns(10);
              
             setLayout(null);
             l6.setFont(new Font("Arial",Font.BOLD,30));
             l6.setBounds(90, 15, 300,40);
             
             
            bdt.setBackground(Color.black);
             bdt.setBounds(5, 80, 1270, 5);
           
            
         pnl=new JPanel();
         pnl.setBounds(40,100,1200,570);
         Border bd=BorderFactory.createLineBorder(Color.black);
         pnl.setBorder(BorderFactory.createTitledBorder(bd, " NEW ACCOUNT REGISTRATION ",TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, null, Color.red));
          pnl.setLayout(null);
          
             l13.setBounds(250,60,200,40);
             l13.setFont(new Font("Times New Roman",Font.PLAIN,30));
             s1.setBounds(150,100,400,300);
             s1.setBackground(Color.white);
             s1.setBorder(BorderFactory.createLoweredBevelBorder());
             
              l14.setBounds(800,60,200,40);
             l14.setFont(new Font("Times New Roman",Font.PLAIN,30));
             s2.setBounds(700,100,400,220);
             s2.setBackground(Color.white);
             s2.setBorder(BorderFactory.createRaisedBevelBorder());
             
             
             add(bdt);
             add(l6);
             add(pnl);
             pnl.add(l13);
             pnl.add(l14);
             pnl.add(s1);
             pnl.add(s2);
             
              jb.setBounds(300,420,100,25);
              jb1.setBounds(800,350,100,25);
              jb2.setBounds(500,450,300,25);
              
            //  pnl.add(jb);
              //pnl.add(jb1);
              pnl.add(jb2);
            
              User.getnums();
             l7.setBounds(10,15,100,40);
             j1.setBounds(110,25,250,25);
             j1.setText(" "+User.regno);
             j1.setEditable(false);
             
             l8.setBounds(10,55,100,40);
             jf.setBounds(110,65,250,25);
             jf.setText(" "+User.accno);
             jf.setEditable(false);
             
             l9.setBounds(10,95,100,40);
              jf1.setBounds(110,105,250,25);
             jf1.setText(" "+User.pin);
             jf1.setEditable(false);
             
             l10.setBounds(10,135,100,40);
             rb1.setBounds(110,145,75,25);
             rb2.setBounds(190,145,75,25);
             rb3.setBounds(270,145,75,25);
                        
             l11.setBounds(10,175,100,40);
             jp.setBounds(110,185,250,25);
             jp.setBackground(Color.white);
             
             //Amount
             l12.setBounds(10,215,100,40);
             j4.setBounds(110,225,250,25);
             
             l15.setBounds(10,15,100,40);
             l16.setBounds(10,55,100,40);
             l17.setBounds(10,95,100,40);
             l18.setBounds(10,135,100,40);
             
             j5.setBounds(110,25,250,25);
             jd.setBounds(110,65,250,25);
             j7.setBounds(110,105,250,25);
             j6.setBounds(110,145,250,25);
             
             
             s1.setLayout(null); s2.setLayout(null);s1.add(l7);s1.add(l8);
             s1.add(l9); s1.add(j1);s1.add(jf);s1.add(jf1);s1.add(l10);s1.add(rb1);
             s1.add(rb2);s1.add(rb3);s1.add(l11);s1.add(l12);s1.add(jp);
             s1.add(j4);s2.add(l15);s2.add(l16);s2.add(l17);s2.add(l18); s2.add(jd); s2.add(j5);
             s2.add(j7);s2.add(j6);
             bg=new ButtonGroup();
             bg.add(rb1);bg.add(rb2); bg.add(rb3); 
             jb2.addActionListener(this);
        //     cust.Back();    
          }

    @Override
    public void actionPerformed(ActionEvent e) {

       if(e.getSource()==jb2)
       {
           StringBuffer st;
           st=new StringBuffer("");
         
           if(!loggedUser.checkformat(j4.getText(),"Deposit"))
                 st.append("Amount not filled in correct format");
           if(!loggedUser.checkformat(j5.getText(),"Name"))
                st.append("\n username is not in correct format");
           if(!loggedUser.checkformat(j7.getText(),"MobNo"))
               st.append("\nMobile number is not correct format");
           if(!st.isEmpty()){
               JOptionPane.showMessageDialog(pnl, st);
               return;
           }
           
           String gen=new String("");
           if(rb1.isSelected())
               gen=gen.concat("Male");
           else if(rb2.isSelected())
               gen=gen.concat("Female");
           else if(rb3.isSelected())
               gen=gen.concat("Others");
 
          
           
           try {
          
              if(User.Insert(j4.getText(),j5.getText(),java.sql.Date.valueOf(jd.getText()),j7.getText(), j6.getText(),gen,(String)jp.getSelectedItem()))
             {
                 JOptionPane.showMessageDialog(pnl,"Account Created \n Userid :"+User.accno+"\nPin :"+User.pin);
                 login log=new login();
                 log.setSize(415, 440);
                 log.setLocation(400, 150);
                 log.setVisible(true);
                 log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 this.dispose();
                 
             }
           } catch (Exception ex) {}
           
       }
    }
}
