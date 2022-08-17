package javaapplication6;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Dlt implements ActionListener{
    JFrame f;
    JPanel p1;
    JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2,t3,t4,t5;
 JButton b1;
    
    Dlt(){
    f=new JFrame("delete enetries here");
    f.setSize(700,700);
    
    p1=new JPanel();
    p1.setLayout(null);////////////////////////////////////////////
    f.add(p1);
    p1.setBackground(Color.blue);
     
    l1=new JLabel("rollno");  
    t1=new JTextField(20);
    b1=new JButton("click to delete records in table");    
    
    
    l1.setBounds(50,50,50,30);
    t1.setBounds(150,50,380,30);
    
    b1.setBounds(150,100,250,30);
  l1.setForeground(Color.WHITE);
    p1.add(l1);
    p1.add(t1);
    
     p1.add(b1);
   
    f.setVisible(true);
   b1.addActionListener(this);
 
    }
    public void actionPerformed(ActionEvent e){
         if(e.getSource()==b1){
      String a1;
      a1=t1.getText();
     
       try{
           Class.forName("org.apache.derby.jdbc.ClientDriver");
           Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
           PreparedStatement stat=con.prepareStatement("Delete from stu where rollno=?");
           stat.setString(1,a1);
           
           stat.executeUpdate();
           JOptionPane n1=new JOptionPane();
           n1.showMessageDialog(null,"record deleted successfully","msg box",1);
       }
       catch(Exception ew){
           System.out.println(ew);
       }

         }
    }
    public static void main(String p[]){
    Dlt d=new Dlt();
    }
}
    

