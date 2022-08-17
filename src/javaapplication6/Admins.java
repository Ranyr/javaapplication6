
package javaapplication6;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.regex.*;
import java.util.*;
public class Admins implements ActionListener{
    JFrame f;
    JPanel p;
    JLabel l,l2,l3;
    JTextField t1,t2;
    JButton b1,b2,b3;
    JOptionPane n,nx1,nx;
    Font o;
   
    
    Admins(){
     f=new JFrame("my app");
     f.setSize(700,700);
      
    p=new JPanel(); 
    p.setLayout(null);
    f.add(p);
    
     Color c1=new Color(60,30,150);
     p.setBackground(c1);
    
     n=new JOptionPane();
     nx=new JOptionPane();
     nx1=new JOptionPane();
        
    l=new JLabel("Admin Login");
    l2=new JLabel("enter  your username");
    l3=new JLabel("enter your Password");
    
    t1=new JTextField(20);
    t2=new JTextField(20);
     
    b1=new JButton("Login");
    b2=new JButton("Forgot Password");
    b3=new JButton("New Admin");
   
    o=new Font("brush script up",Font.BOLD,24);
    l.setFont(o);
    l.setBounds(270,110,150,25);
    
    l2.setBounds(100,175,150,30);
    t1.setBounds(250,175,200,30);
     
    l3.setBounds(100,210,150,30);
    t2.setBounds(250,210,200,30);
    
   b1.setBounds(250,295,150,30);
   b2.setBounds(250,330,150,30); 
   b3.setBounds(250,365,150,30);
   
   l.setForeground(Color.WHITE);
    l2.setForeground(Color.WHITE);
     l3.setForeground(Color.WHITE);
    t1.setBackground(Color.WHITE);
    t2.setBackground(Color.WHITE);
    b1.setBackground(Color.WHITE);
    b1.setForeground(Color.black);
    b2.setBackground(Color.WHITE);
    b2.setForeground(Color.black);
    b3.setBackground(Color.WHITE);
    b3.setForeground(Color.black);
    
    
      
    p.add(l);
     p.add(l2);
     p.add(l3);
     
    p.add(t1);
     p.add(t2);
      p.add(b1);
       p.add(b2);
        p.add(b3);
        
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    
    f.setVisible(true);
       }   
    

public void actionPerformed(ActionEvent ex)
{
 String ap,ap1;
    
 if(ex.getSource()==b1){
       ap=t1.getText();
         ap1=t2.getText();

     
     try{
          
         
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         Connection cc=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
         PreparedStatement p=cc.prepareStatement("SELECT username,password FROM adminlogin WHERE username='"+ap+"'");
         ResultSet rs=p.executeQuery();
 while(rs.next())
 {
  if( (ap.equals(rs.getString("username")))&&(ap1.equals(rs.getString("password"))) )
  {
  n.showMessageDialog(null,"user is verified","msgbox",3);
  new adminhome();
  }
  else if((ap.isEmpty())||(ap1.isEmpty()))
  { nx1.showMessageDialog(null,"something went wrong!!try again","msgbox",3);}
  else
  { nx.showMessageDialog(null,"no such user found plz contact admin","msgbox",3);}
 
 }
     }
     
     
     catch (Exception ek){ System.out.println(ek);}
 }
 
 else if(ex.getSource()==b2){
 new adminforgot();
 
 }
 else
 {   new Adminreg(); }
}


public static void main(String args[]){

Admins apz=new Admins();
}


}

