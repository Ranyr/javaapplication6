
package javaapplication6;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class studentregister implements ActionListener{
    JFrame f;
    JPanel p;
    JLabel l,l3,l1,l2,l4,l5,l6,l7,l8,l9,l10,lb,lb1;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    JOptionPane n1,n2,n3;
    JButton b1,b2;
    Font o;
    
    String PATTERN="^[A-Z]+[a-z0-9]{4,}$"; //AZYabcd1234---means password must be of at least 5 chr
    String PATTERNS="^[A-Za-z0-9_\\.]+@[A-Za-z0-9]{3,}\\.[A-Za-z]{2,}$"; //email validation
    
    studentregister(){
    f=new JFrame("desk");
    f.setSize(700,600);
    
   
    p=new JPanel();
    p.setLayout(null);
    
    f.add(p);
     

    o=new Font("Monotype Corsiva",Font.BOLD,25);  
    n1=new JOptionPane();
    n2=new JOptionPane();
    n3=new JOptionPane();
 l=new JLabel("REGISTERATION PORTAL");
 l1=new JLabel("name");   
l2=new JLabel("class");
l3=new JLabel("rollno");
l4=new JLabel("dob");
l5=new JLabel("admissiondate");
l6=new JLabel("address");
l7=new JLabel("contact_no");
l8=new JLabel("email");
l9=new JLabel("username");
l10=new JLabel("password");
lb=new JLabel();
lb1=new JLabel();

t1=new JTextField(50);
t2=new JTextField(50);
t3=new JTextField(50);
t4=new JTextField(80);
t5=new JTextField(50);
t6=new JTextField(80);
t7=new JTextField(80);
t8=new JTextField(80);
t9=new JTextField(80);
t10=new JTextField(80);

l.setBounds(230,40,330,40);
l1.setBounds(180,90,100,27);
l2.setBounds(180,120,100,27);
l3.setBounds(180,150,100,27);
l4.setBounds(180,180,150,27);
l5.setBounds(180,210,150,27);
l6.setBounds(180,240,150,27);
l7.setBounds(180,270,150,27);
l8.setBounds(180,300,150,27);
l9.setBounds(180,330,150,27);
l10.setBounds(180,360,150,27);

lb.setBounds(550,300,200,27);//infront of t8 email
lb1.setBounds(550,360,200,27);//in front of t10 password

t1.setBounds(350,90,190,25);
t2.setBounds(350,120,190,25);
t3.setBounds(350,150,190,25);
t4.setBounds(350,180,190,25);
t5.setBounds(350,210,190,25);
t6.setBounds(350,240,190,25);
t7.setBounds(350,270,190,25);
t8.setBounds(350,300,190,25);
t9.setBounds(350,330,190,25);
t10.setBounds(350,360,190,25);


l.setFont(o);
l1.setFont(o);
l2.setFont(o);
l3.setFont(o);
l4.setFont(o);
l5.setFont(o);
l6.setFont(o);
l7.setFont(o);
l8.setFont(o);
l9.setFont(o);
l10.setFont(o);
 
 l.setForeground(Color.WHITE);
 l1.setForeground(Color.WHITE);
 l2.setForeground(Color.WHITE);
 l3.setForeground(Color.WHITE);
 l4.setForeground(Color.WHITE);
 l5.setForeground(Color.WHITE);
 l6.setForeground(Color.WHITE);
 l7.setForeground(Color.WHITE);
 l8.setForeground(Color.WHITE);
 l9.setForeground(Color.WHITE);
 l10.setForeground(Color.WHITE);
 lb.setForeground(Color.WHITE);
 lb1.setForeground(Color.WHITE);
 p.setBackground(Color.blue);
 
p.add(l);
p.add(l1); 
p.add(l2);
p.add(l3);
p.add(l4);
p.add(l5);
p.add(l6);
p.add(l7);
p.add(l8);
p.add(l9);
p.add(l10);
p.add(lb);
p.add(lb1);

p.add(t1);
p.add(t2);
p.add(t3);
p.add(t4);
p.add(t5);
p.add(t6);
p.add(t7);
p.add(t8);
p.add(t9);
p.add(t10);

b1=new JButton("submit");
b2=new JButton("reset");
b1.setBounds(300,400,150,25);
b2.setBounds(300,430,150,25);
b1.setFont(o);
b2.setFont(o);
p.add(b1);
p.add(b2);
f.add(p);
f.setVisible(true);
 b1.addActionListener(this);
 b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            
            String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10;
            a1=t1.getText();
             a2=t2.getText();
              a3=t3.getText();
               a4=t4.getText();
                a5=t5.getText();
                 a6=t6.getText();
                  a7=t7.getText();
                   a8=t8.getText();
                   a9=t9.getText();
                 a10=t10.getText();
                
               
                
            
            Pattern pat=Pattern.compile(PATTERN);  //password  t10
           Matcher mat=pat.matcher(t10.getText());
           
           Pattern patt=Pattern.compile(PATTERNS);  //email   t8
           Matcher matt=patt.matcher(t8.getText());
           
           if((!mat.matches())&&(!matt.matches())){
            lb.setText("invalid password");   //lb=password
            lb1.setText("invalid email");     //lb 1=email
            t10.setText(" ");
             t8.setText(" ");
           }
           
          else if(!mat.matches())
          {
          lb.setText("invalid password");
          t10.setText(" ");
          }
          else if(!matt.matches()){
            lb1.setText("invalid email");
            t8.setText(" ");
           
           }   
            else
           {
                lb.setText(" ");
                lb1.setText(" ");
            
              
    try{
     Class.forName("org.apache.derby.jdbc.ClientDriver");
     Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
     PreparedStatement st=con.prepareStatement("Insert into stu values(?,?,?,?,?,?,?,?,?,?)");
     
st.setString(1,a1);
st.setString(2,a2);
st.setString(3,a3);
st.setString(4,a4);
st.setString(5,a5);
st.setString(6,a6);
st.setString(7,a7);
st.setString(8,a8);
st.setString(9,a9);
st.setString(10,a10);
st.executeUpdate();
n3.showMessageDialog(null,"student registered successfully","confirmation msg",1);
      }
    catch(Exception ew){
        System.out.println(ew);
                       }
        }
        }
        
        
        //reset button is pressed
    else{
            
         t1.setText(" ");     
          t2.setText(" ");     
          t3.setText(" ");     
          t4.setText(" ");     
          t5.setText(" ");     
          t6.setText(" ");     
          t7.setText(" ");     
          t8.setText(" ");     
          t9.setText(" ");     
          t10.setText(" ");     
          
        }   }
        

    public static void main (String args[]){
    studentregister s=new studentregister();
}
}