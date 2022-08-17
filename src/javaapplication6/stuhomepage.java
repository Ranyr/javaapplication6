
package javaapplication6;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class stuhomepage implements ActionListener
{
    JFrame f1;
    JPanel p1;
    JLabel pp,l1,l2,l3;
    TextField t1;
    JButton b1,b2,b3,b4,b5;
    Icon c;
    Font o,o1;
    public stuhomepage(){
    f1=new JFrame("my frame");
    f1.setSize(820,520);
    
    p1=new JPanel ();
    p1.setLayout(null);
    f1.add(p1);
    
    l2=new JLabel("STUDENT PORTAL");
   
     
    b1=new JButton("Marksheet");    
    b2=new JButton("Attendancesheet");
    b3=new JButton("Fees");
    b4=new JButton("Contact Admin");
    b5=new JButton("IT'S TIME TO BE SERIOUS");
    
    o=new Font("brush script up",Font.BOLD,24);
    o1=new Font("Arial",Font.BOLD,13);
    l2.setFont(o);
    b5.setFont(o1);
   
    
     c=new ImageIcon("D:\\home_stu.jpg"); 
     pp=new JLabel(c);
     pp.setBounds(0,-150,800,770);
     p1.add(pp); 
     
     l2.setBounds(260,3,300,25);
     b5.setBounds(530,450,265,25);
     b1.setBounds(10,450,100,25);
     b2.setBounds(120,450,150,25);
     b3.setBounds(280,450,90,25);
     b4.setBounds(380,450,130,25);
     
      b1.setBackground(Color.ORANGE);
    b1.setForeground(Color.black);
      b2.setBackground(Color.ORANGE);
    b2.setForeground(Color.black);
     b3.setBackground(Color.ORANGE);
    b3.setForeground(Color.black);
     b4.setBackground(Color.ORANGE);
    b4.setForeground(Color.black);
    
   b5.setBackground(Color.ORANGE);
   b5.setForeground(Color.black);
    b5.setEnabled(false); 
    
    p1.add(l2);
     p1.add(b1);
        p1.add(b2);
           p1.add(b3);
              p1.add(b4);
                p1.add(b5);
         p1.add(b2);
         p1.add(b3);
         p1.add(b4);
           b1.addActionListener(this);
           b2.addActionListener(this);
           b3.addActionListener(this);
           b4.addActionListener(this);
           
    f1.setVisible(true);
             }
    public void actionPerformed(ActionEvent ee)
    {
    if(ee.getSource()==b1)
    { new viewmarks();}
    else if(ee.getSource()==b2)
    {new viewattend();}
    else if(ee.getSource()==b3)
    { new viewfees(); }
   // else
    //{new contactadmin(); }
    }
    public static void main(String p[]){
        stuhomepage m=new stuhomepage();
                 }
}
