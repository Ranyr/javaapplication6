
package javaapplication6;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class viewfees implements ActionListener{
       JFrame f;
    JPanel p;
    JLabel l,l1,l2,l3,l4,l5;
    JTextField t1,t2,t3,t4,t5;
    JButton b1;
    Font o;
    viewfees(){
    f=new JFrame("my app");
    f.setSize(700,700);
    
    p=new JPanel();
    p.setLayout(null);
    f.add(p);
    
    o=new Font("brush script up",Font.BOLD,24);
    p.setBackground(Color.BLUE);
    
    l=new JLabel("Enter Rollno and Class to Get fee details");
    l1=new JLabel("Rollno");
    l2=new JLabel("class");
    l3=new JLabel("total fees");
    l4=new JLabel("fee paid");
     l5=new JLabel("Balance");
     
    t1=new JTextField(20);
    t2=new JTextField(20);
    t3=new JTextField(20);
     t4=new JTextField(20);
    t5=new JTextField(20);
    b1=new JButton("submit"); 
l.setBounds(140,170,490,25);
l1.setBounds(213,210,90,40);
t1.setBounds(330,220,190,25);

l2.setBounds(210,255,110,40);
t2.setBounds(330,265,190,25);

l3.setBounds(210,300,130,40);
t3.setBounds(330,310,190,25);


l4.setBounds(210,345,130,40);
t4.setBounds(330,355,190,25);

l5.setBounds(210,395,130,40);
t5.setBounds(330,400,190,25);

b1.setBounds(220,440,100,25);
l.setFont(o);
l.setForeground(Color.WHITE);
l1.setForeground(Color.WHITE);
l2.setForeground(Color.WHITE);
l3.setForeground(Color.WHITE);
l4.setForeground(Color.WHITE);
l5.setForeground(Color.WHITE); 

    p.add(l);
    p.add(l1);
    p.add(t1);
    p.add(l2);
    p.add(t2);
    p.add(l3);
    p.add(t3);
    p.add(l4);
     p.add(t4);
     p.add(l5);
     p.add(t5);
    p.add(b1);
    f.setVisible(true);
    b1.addActionListener(this);
    
    }
    public void actionPerformed(ActionEvent e){
     String a1;
     a1=t1.getText();
     if(e.getSource()==b1){
     try{
     Class.forName("org.apache.derby.jdbc.ClientDriver");
     Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
     PreparedStatement stat=con.prepareStatement("Select*from fees where rollno=?");
     
     stat.setString(1, a1);
     ResultSet res=stat.executeQuery();
     while(res.next()){
     t1.setText(res.getString(1));
     t2.setText(res.getString(2));
     t3.setText(res.getString(3)); 
      t4.setText(res.getString(4)); 
       t5.setText(res.getString(5)); 
     }
     }
     catch(Exception ep){
     System.out.println(ep);
     }
     
     }
  
    }
    public static void main(String p[]){
   viewfees s= new viewfees();
  
    }
}
