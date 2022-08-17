
package javaapplication6;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import java.util.*;

public class Adminreg implements ActionListener{
    JFrame f;
    JPanel p;
   JLabel l,l1,l2,lb;
    JTextField t1,t2,t3;
    JButton b,b2;
    JOptionPane n1,n2,n3;
    Font o;
    String PATTERN="^[A-Z]+[a-z0-9]{4,}$";
    
    
    Adminreg(){
        
   
  f=new JFrame("desktop app");
f.setSize(900,700);

p=new JPanel();
p.setLayout(null);
p.setBackground(Color.blue);
f.add(p);

n1=new JOptionPane();
n2=new JOptionPane();
n3=new JOptionPane();

o=new Font("brush script up",Font.BOLD,24);

l=new JLabel("Admin Register");
l1=new JLabel("Username");
t1=new JTextField();
l2=new JLabel("Password");
t2=new JTextField();
lb=new JLabel();
b=new JButton("submit");
b2=new JButton("reset");

l.setBounds(250,170,250,25);
l.setForeground(Color.WHITE);
l1.setForeground(Color.WHITE);
l2.setForeground(Color.WHITE);

l1.setBounds(213,210,90,40);
t1.setBounds(330,220,190,25);

l2.setBounds(210,255,110,40);
t2.setBounds(330,265,190,25);  lb.setBounds(530,265,80,40);


 lb.setForeground(Color.WHITE);

b.setBounds(290,340,100,25);
b2.setBounds(290,370,100,25);

l.setFont(o);
p.add(l);
p.add(l1);
p.add(l2);
p.add(lb);
p.add(t1);
p.add(t2);
p.add(b);
p.add(b2);

b.addActionListener(this);
b2.addActionListener(this);

f.setVisible(true);

}
    
    
    public void actionPerformed(ActionEvent ee){
            
     if(ee.getSource()==b)
    {     
         String a1,a2;
         a1=t1.getText(); 
         a2=t2.getText();
          Pattern pat=Pattern.compile(PATTERN);  //password  t2
          Matcher mat=pat.matcher(t2.getText());
          
         if(!mat.matches())
          {
          lb.setText("not allowed");
         
          t2.setText(" ");
          }
         else{
          try{
            
          lb.setText(" ");
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
         PreparedStatement st=con.prepareStatement("INSERT INTO adminlogin VALUES(?,?)");
         
         st.setString(1,a1);
         st.setString(2,a2);
         st.executeUpdate();
         n1.showMessageDialog(null,"registed successlly","msgbox",3);
         new Admins();
         }
          catch(Exception ex){
                       System.out.println(ex);
                    }  
         }
     
     
     
     }
    else{
            
             t1.setText(" ");
             t2.setText(" ");
       }
                        
       
     }
    
    public static void main(String args[]){
    Adminreg rg=new Adminreg();
    }
}
