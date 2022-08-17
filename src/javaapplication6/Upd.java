package javaapplication6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Upd implements ActionListener{
     JFrame f;
    JPanel p1;
    JLabel l,l1,l2,l3;
    JTextField t1,t2,t3;
    JButton b1;
     JOptionPane n1;
     
    Upd(){
    f=new JFrame("update enetries here");
    f.setSize(700,700);
    
    p1=new JPanel();
    p1.setLayout(null);////////////////////////////////////////////
    f.add(p1);
    
    p1.setBackground(Color.blue);
    
    l=new JLabel("UPDATE CREDENTIALS");
    l1=new JLabel("rollno");
    l2=new JLabel("usename");
    l3= new JLabel("password");
   
        
    t1=new JTextField(20);
    t2=new JTextField(20);
    t3=new JTextField(20);

  n1=new JOptionPane();
  b1=new JButton("click to update records in table");    
    
    l.setBounds(190,50,180,50);
    l1.setBounds(50,120,80,30); 
   l2.setBounds(50,160,80,30);
   l3.setBounds(50,210,80,30);
  
   
  t1.setBounds(150,120,380,30);
  t2.setBounds(150,160,380,30);
  t3.setBounds(150,210,380,30);

  
 b1.setBounds(150,300,240,30);
 
 l.setForeground(Color.WHITE);
 l1.setForeground(Color.WHITE);
l2.setForeground(Color.WHITE);
l3.setForeground(Color.WHITE);
  p1.add(l);
    p1.add(l1);
    p1.add(t1);
    p1.add(l2);
    p1.add(t2);
    p1.add(l3);
    p1.add(t3);
   
     p1.add(b1);
   
    f.setVisible(true);
   b1.addActionListener(this);
 
    }
    public void actionPerformed(ActionEvent e){
         if(e.getSource()== b1){
      String a1,a2,a3;
      a1=t1.getText();
      a2=t2.getText();
      a3=t3.getText();
    
       try{ 
           if(!a3.isEmpty())
           {
           Class.forName("org.apache.derby.jdbc.ClientDriver");
           Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
           PreparedStatement stat=con.prepareStatement("Update stu set username=?,password=? where rollno=?");
           
           stat.setString(1,a2);
           stat.setString(2,a3);
           stat.setString(3,a1);
           stat.executeUpdate();
           JOptionPane n1= new JOptionPane();
           n1.showMessageDialog(null,"data updated successfull","msg box",1);
           }
           else{
            n1.showMessageDialog(null,"something went wrong , plz try again","msg box",1);
           
           }
       }
       catch(Exception ew){
           System.out.println(ew);
       }

         }
    }
    public static void main(String p[]){
    Upd v=new Upd();
    }
}