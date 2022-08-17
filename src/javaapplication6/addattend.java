
package javaapplication6;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class addattend implements ActionListener{
    JFrame f;
    JPanel p;
    JLabel l,l3,l1,l2;
    JTextField t1,t2,t3;
    JOptionPane n1,n2,n3;
    JButton b1,b2;
    Font o;
    
        
    addattend(){
    f=new JFrame("desk");
    f.setSize(700,600);
    
   
    p=new JPanel();
    p.setLayout(null);
    
    f.add(p);
     

    o=new Font("Monotype Corsiva",Font.BOLD,25);  
    n1=new JOptionPane();
    n2=new JOptionPane();
    n3=new JOptionPane();
    
 l=new JLabel("ATTENDANCE UPDATION");
 l1=new JLabel("rollno");   
l2=new JLabel("class");
l3=new JLabel("Attendance");



t1=new JTextField(50);
t2=new JTextField(50);
t3=new JTextField(50);


b1=new JButton("submit");
b2=new JButton("reset");

l.setBounds(230,40,330,40);
l1.setBounds(180,90,100,27);
l2.setBounds(180,120,100,27);
l3.setBounds(180,150,180,27);



t1.setBounds(350,90,190,25);
t2.setBounds(350,120,190,25);
t3.setBounds(350,150,190,25);


l.setFont(o);
l1.setFont(o);
l2.setFont(o);
l3.setFont(o);


 
 l.setForeground(Color.WHITE);
 l1.setForeground(Color.WHITE);
 l2.setForeground(Color.WHITE);
 l3.setForeground(Color.WHITE);

 
 p.setBackground(Color.blue);
 
p.add(l);
p.add(l1); 
p.add(l2);
p.add(l3);



p.add(t1);
p.add(t2);
p.add(t3);




b1.setBounds(300,300,150,25);
b2.setBounds(300,330,150,25);
b1.setFont(o);
b2.setFont(o);
p.add(b1);
p.add(b2);
f.add(p);
b1.addActionListener(this);
b2.addActionListener(this);
f.setVisible(true);
 
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            
            String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10;
            a1=t1.getText();
             a2=t2.getText();
              a3=t3.getText();
               
               

            
              
    try{
     Class.forName("org.apache.derby.jdbc.ClientDriver");
     Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
     PreparedStatement st=con.prepareStatement("Insert into attendance values(?,?,?)");
     
st.setString(1,a1);
st.setString(2,a2);
st.setString(3,a3);


st.executeUpdate();
n3.showMessageDialog(null,"Attendance updated successfully","confirmation msg",1);
      }
    catch(Exception ew){
        System.out.println(ew);
                       }
        }    
        
        //reset button is pressed
    else{
            
         t1.setText(" ");     
          t2.setText(" ");     
          t3.setText(" ");     
             
            
          
        }   }
        

    public static void main (String args[]){
   addattend s=new addattend();
}
}

