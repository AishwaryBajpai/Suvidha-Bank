package project1;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.text.NumberFormatter;


public class login extends JFrame implements ActionListener{
      JLabel l1,l2,l3,l4,l5,logo;
      JTextField tf1;
      JPasswordField jp;
      JPanel jt;
      JButton signUp,logIn;
      public loggedUser loguse=new loggedUser();
      
      public login() throws IOException{
          super("Suvidha Bank");
          jt=new JPanel();
          Image img= ImageIO.read(getClass().getResource("resources/logo.png"));
          logo=new JLabel(new ImageIcon(img));
          l1=new JLabel("Suvidha Bank");
          l2= new JLabel("Username:");
          l3=new JLabel("Pin :");
          l4=new JLabel(" Or ");
          l5=new JLabel("To Create Account ");
          
         
          logIn=new JButton("LogIn");
          signUp=new JButton("SignUp");
          
          setLayout(null);
          jt.setLayout(null);
          jt.setBorder(BorderFactory.createLineBorder(Color.black,2));
           jt.setSize(400, 400);
            jt.setBackground(Color.white);
          
          //setting logo
          logo.setBounds(20,5,120,110);
          logo.setVisible(true);
          jt.add(logo);
          
          //setting label l1
          l1.setFont(new Font("Arial",Font.BOLD,25));
          l1.setBounds(150,50,400,30);
          jt.add(l1); 
          
          //setting l2
          l2.setFont(new Font("Times New Roman",Font.PLAIN,20));
          l2.setBounds(10, 125, 100, 20);
           jt.add(l2);
          
           //setting l3
          l3.setFont(new Font("Times New Roman",Font.PLAIN,20));
          l3.setBounds(10, 200, 100, 20);
          jt.add(l3);
          
          //textfield
       
          tf1=new JTextField();
          tf1.setBounds(150,125,200,20);
           jt.add(tf1);
           
          //password field
           
           jp=new JPasswordField(4);
           jp.setBounds(150,200,200,20);
          jt.add(jp);
          
          //label4 
           l4.setBounds(185,280,40,20);
           jt.add(l4);
           
          //login button 
          logIn.setBackground(Color.black);
          logIn.setBounds(150,250,100,30);
          logIn.setForeground(Color.white);
          logIn.setFocusPainted(false);
          logIn.setFont(new Font("Arial",Font.BOLD,20));
           jt.add(logIn);
          
          //label 5
           l5.setBounds(150,300,200,20);
            jt.add(l5);
            
          //signUP button
          signUp.setBackground(Color.black);
          signUp.setBounds(130,330,150,30);
          signUp.setForeground(Color.white);
          signUp.setFocusPainted(false);
          signUp.setFont(new Font("Arial",Font.BOLD,20));
            jt.add(signUp);
          
       
          jt.setLocation(0,0);  
          jt.setVisible(true);
          add(jt);
          logIn.addActionListener(this);
          signUp.addActionListener(this);
         
      }

    @Override
    public void actionPerformed(ActionEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==logIn)
        {   String ud=tf1.getText();
               String pd=String.valueOf(jp.getPassword());
             //System.out.println(ud+" "+pd);
            if(ud.isEmpty()||pd.isEmpty())
                JOptionPane.showMessageDialog(this,"All enteries are not filled");
            else
            {  
               if(ud.matches("[0-9]*")||pd.matches("[0-9]{4}"))
               {   int useid=Integer.parseInt(ud);
                   int pinid=Integer.parseInt(pd);
                     
                   try {
                       if(loguse.check(useid,pinid))
                       {
                           Loginoptions pf=new Loginoptions();
                           pf.setSize(1300,1000);
                           pf.setVisible(true);
                           this.dispose();
                           pf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                       }
                       else
                           JOptionPane.showMessageDialog(this,"Invalid User");
                   } catch (Exception ex) {
                       Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                   }
            
                   
               }
             else
                JOptionPane.showMessageDialog(this,"Incorrect UserId and Pin");
           }
        }
        else
        {
            try {
                 SignUP sp;
                sp = new SignUP();
                 sp.setSize(1300,1000);
                sp.setVisible(true);
                this.dispose();
                sp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } catch (Exception ex) {}
        }
    }
}
