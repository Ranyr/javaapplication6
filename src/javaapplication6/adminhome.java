
package javaapplication6;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class adminhome implements ActionListener{
    
    JFrame f1;
    JPanel p1;
    JLabel pl,l1,l2,l3;
    TextField t1;
    JButton b1,b2,b3,b4,bx,bx1;
    
    Icon c1;
    Font o,o1;
    adminhome(){
    f1=new JFrame("my frame");
    f1.setSize(840,520);
    
    p1=new JPanel ();
    p1.setLayout(null);
    f1.add(p1);
    
    l2=new JLabel(" WELCOME TO ADMIN PORTAL");
    l2.setFont(o);
    l2.setForeground(Color.blue);
     
    b1=new JButton("ADDMarks");    
    b2=new JButton("AddAttendance");
    b3=new JButton("AddFees");
    b4=new JButton("add new student");
    bx=new JButton("delete");
   bx1=new JButton("update");
    
    o=new Font("brush script up",Font.BOLD,27);
    o1=new Font("Arial",Font.BOLD,13);
    l2.setFont(o);
    //b5.setFont(o1);
   
     c1=new ImageIcon("D:\\admin.jpg");
    
     pl=new JLabel(c1);
     pl.setBounds(0,-150,820,770);
     p1.add(pl);
 
     
     l2.setBounds(210,15,450,25);
     
     b1.setBounds(10,450,100,25);
     b2.setBounds(120,450,150,25);
     b3.setBounds(280,450,90,25);
     b4.setBounds(380,450,130,25);
     bx.setBounds(520,450,130,25);
    bx1.setBounds(660,450,155,25);
    
     
    b1.setBackground(Color.blue);
    b1.setForeground(Color.white);
    
    b2.setBackground(Color.blue);
    b2.setForeground(Color.white);
    
    b3.setBackground(Color.blue);
    b3.setForeground(Color.white);
    
    b4.setBackground(Color.blue);
    b4.setForeground(Color.white);
    
     bx.setBackground(Color.blue);
    bx.setForeground(Color.white);
    
     bx1.setBackground(Color.blue);
    bx1.setForeground(Color.white);
    
   
   
    
    
    p1.add(l2);
     p1.add(b1);
        p1.add(b2);
           p1.add(b3);
              p1.add(b4);
                p1.add(bx);
                p1.add(bx1);
                
         
           b1.addActionListener(this);
           b2.addActionListener(this);
           b3.addActionListener(this);
           b4.addActionListener(this);
          bx.addActionListener(this);
          bx1.addActionListener(this);
    f1.setVisible(true);
             }
    public void actionPerformed(ActionEvent ee)
    {
    if(ee.getSource()==b1)
    { new insmark();}
    else if(ee.getSource()==b2)
    {new addattend();}
    else if(ee.getSource()==b3)
    { new addfees(); }
    else if(ee.getSource()==b4)
    { new studentregister(); }
    else if(ee.getSource()==bx)
    {new Dlt();}
    else if(ee.getSource()==bx1)
    { new Upd();}
   // else
    //{new contactadmin(); }
    }
    public static void main(String p[]){
        adminhome m=new adminhome();
                 }
    
    
    
}
