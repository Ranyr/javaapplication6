
package javaapplication6;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;
import javax.swing.*;
import java.awt.*;

public class Login1 implements ActionListener{
    JFrame f;
    JPanel p,p1,p2;
    JLabel l,l2,l3;
    JTextField t1,t2;
    JButton bx,b2;
    Font n1,n2;
    JOptionPane n,nx,nx1,nx2;
     Login1(){
     f=new JFrame("my app");
      f.setSize(700,700);
      
       n=new JOptionPane();
       nx=new JOptionPane();
      nx1=new JOptionPane();
       nx2=new JOptionPane();
     
      
     p=new JPanel();    ///1 panel   
     p1=new JPanel();////  2 panel
    
   bx=new JButton("ok");
    b2=new JButton("Forgot Password");
  
    p.setLayout(null);
    p1.setLayout(null);
    
   Color c1=new Color(60,30,150);
   Color c2=new Color(50,40,170);
    n1=new Font("brush script up",Font.BOLD,28);
    n2=new Font("times new roman",Font.BOLD,15);
    p.setBounds(20,20,680,680);    //outer panel
    p1.setBounds(190,170,300,250);//inner paner
    p1.setBackground(c2);
    p.setBackground(c1);
    
    l=new JLabel("login form");
    l2=new JLabel("enter  your username");
    l3=new JLabel("enter your Password");
  
     t1=new JTextField(20);
     t2=new JTextField(20);
     

    l.setFont(n1);
    l2.setFont(n2);
    l3.setFont(n2);
    
    l.setBounds(270,120,150,35);
    l2.setBounds(25,55,150,30);
    l3.setBounds(25,120,150,30);
    t1.setBounds(25,85,200,30);
    t2.setBounds(25,155,200,30);
    bx.setBounds(100,195,70,30);
    b2.setBounds(250,430,150,30); 
   
    l.setForeground(Color.WHITE);
    l2.setForeground(Color.WHITE);
    l3.setForeground(Color.WHITE);
  

    t1.setBackground(Color.WHITE);
    t2.setBackground(Color.WHITE);
    bx.setBackground(Color.WHITE);
    bx.setForeground(Color.black);
    b2.setBackground(Color.WHITE);
    b2.setForeground(Color.black);
  bx.addActionListener(this);
    b2.addActionListener(this);
    p.add(l);                        //login form heading is added in outer panel                      
    p1.add(l2);
    p1.add(l3);
    p1.add(t1);
    p1.add(t2);
    p1.add(bx);
    p.add(p1);
    p.add(b2);
    f.add(p);
    f.setVisible(true);
       
     }
    public void actionPerformed(ActionEvent e){
    String x,x1;
    
if(e.getSource()==bx){

     
     try{
          
       x=t1.getText();
       x1=t2.getText();
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         Connection cc=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
         PreparedStatement p=cc.prepareStatement("SELECT username,password FROM stu WHERE username='"+x+"'");
         ResultSet rs=p.executeQuery();
 while(rs.next())
 {
    if((x.isEmpty())||(x1.isEmpty()))
    { nx1.showMessageDialog(null,"it's mandatory to provide  both rollno and class","msgbox",3);}
     
     else if( (!x.isEmpty())&&(!x1.isEmpty()) &&(x.equals(rs.getString("username")))&&(x1.equals(rs.getString("password"))) ) 
 {
  n.showMessageDialog(null,"credentials are verified","msgbox",3);
  new stuhomepage();
 }
     else{ nx2.showMessageDialog(null,"invalid credentials!! plz try again","msgbox",3);}
 
 }
 }
 catch(Exception ew){
 System.out.println(ew);
         }
 }
 else{
 new userforgot();
 
 }
}//main================================================================================
    public static void main(String args[]){
    Login1 lk=new Login1();
    }
    
}
