/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;
import java.util.regex.*;
import javax.swing.*;
import java.awt.*;

public class Try implements ActionListener{
    JFrame f;
    JPanel p;
    JLabel lb,l2;
    JTextField t1,t2;
    JButton b;
    JOptionPane n1,n2,n3;
    
    String a1,a2;
    String PATTERN="^[A-Z]+[a-z0-9]{4,}$"; //AZYabcd1234---means password must be of at least 5 chr
    String PATTERNS="^[A-Za-z0-9_\\.]+@[A-Za-z0-9]{3,}\\.[A-Za-z]{2,}$";
    
    Try(){
    f=new JFrame("desk");
    f.setSize(1150,700);
    
    p=new JPanel();
    p.setLayout(null);
    f.add(p);
    
    lb=new JLabel();
    l2=new JLabel();
    t1=new JTextField(20);  
    t2=new JTextField(20);
   
    n1=new JOptionPane();
    n2=new JOptionPane();
    n3=new JOptionPane();
    
    b=new JButton("go");
    
    t1.setBounds(200,100,150,25);
    t2.setBounds(200,140,150,25);
    lb.setBounds(370,100,100,25);
    l2.setBounds(370,140,150,25);
    b.setBounds(200,180,130,25);
    
    lb.setForeground(Color.pink);
  l2.setForeground(Color.red);
    p.add(lb);
   p.add(l2);
    p.add(t1);
    p.add(t2);
    p.add(b);
    b.addActionListener(this);
    f.setVisible(true);
   
}
    
   
     public void actionPerformed(ActionEvent e){
        
        if(e.getSource()== b){
            String a,ab;
            
           Pattern pat=Pattern.compile(PATTERN);
           Matcher mat=pat.matcher(t1.getText());
           
           Pattern patt=Pattern.compile(PATTERNS);
           Matcher matt=patt.matcher(t2.getText());
           if((!mat.matches())&&(!matt.matches())){
            lb.setText("invalid password");
            l2.setText("invalid email");
            t1.setText(" ");
             t2.setText(" ");
           }
           
          else if(!mat.matches())
          {
          lb.setText("invalid");
          t1.setText(" ");
          }
          else if(!matt.matches()){
            l2.setText("false");
            t2.setText(" ");
           
           }
          
           
            else
           {
                lb.setText(" ");
                l2.setText(" ");
                 
            try{
                a=t1.getText();
            ab=t2.getText();
           Class.forName("org.apache.derby.jdbc.ClientDriver");
           Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
           PreparedStatement st=con.prepareStatement("INSERT INTO try VALUES(?,?)");
           st.setString(1,a);
           st.setString(2,ab);
           st.executeUpdate();
           n3.showMessageDialog(null,"data inserted","msgbox",2);
        }
            catch(Exception ee){
                
                System.out.println(ee);
            }
    }
    }   
    
     } 

     public static void main(String args[]){
    Try tr=new Try();
    }
}

    
