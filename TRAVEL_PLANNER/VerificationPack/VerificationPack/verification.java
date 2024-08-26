package VerificationPack;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.HashMap;

import javax.swing.*;
import Connector.*;
import Travel.*;

public class verification extends JFrame implements ActionListener {
    JButton blog = new JButton("Login");
    JButton bsign = new JButton("Signup");
    JButton bcacc = new JButton("Create Account");
    JButton bback = new JButton("Back");
    JTextField uf = new JTextField();
    JTextField nf = new JTextField();
    JTextField uf2 = new JTextField();
    JPasswordField pf1 = new JPasswordField();
    JPasswordField pf2 = new JPasswordField();

    public static HashMap<String, User> userMap = new HashMap<>();
    public verification() {
        setSize(800, 350);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("USER VERIFICATION");
        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 400, 450);
        
        p1.setBackground(Color.pink);
        add(p1);

        JPanel p2 = new JPanel();
        p2.setBounds(400, 0, 400, 450);
        p2.setLayout(null);
        add(p2);

        ImageIcon i3 = new ImageIcon("E:\\COLLEGE\\SEMESTER-2\\signinlogo2-removebg-preview.png");
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 50, i3.getIconWidth(), i3.getIconHeight());

        p1.add(l2);

       
        JLabel l3 = new JLabel("Username:");
        JLabel l4 = new JLabel("Password:");
        l3.setBounds(70, 75, 80, 25);
        l4.setBounds(70, 125, 80, 25);

        p2.add(l3);
        p2.add(l4);

        
        blog.setBounds(70, 200, 80, 25);
        p2.add(blog);
        blog.setBackground(Color.white);
        blog.addActionListener(new Login());

       
        uf.setBounds(150, 75, 165, 25);
        p2.add(uf);

        
        pf1.setBounds(150, 125, 165, 25);
        p2.add(pf1);

        
        bsign.setBounds(225, 200, 80, 25);
        p2.add(bsign);
        bsign.setBackground(Color.white);
        bsign.addActionListener(this);

        JLabel l5 = new JLabel("Don't have an account? Then sign up");
        l5.setBounds(80, 260, 300, 25);
        p2.add(l5);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bsign) {
            dispose();
            new Signup();
        }

    }

    public class Signup extends JFrame implements ActionListener {
        JTextField nf = new JTextField();
        JTextField uf2 = new JTextField();
        JPasswordField pf2 = new JPasswordField();
        JButton bcacc = new JButton("Create Account");
        JButton bback = new JButton("Back");

        Signup() {
            setSize(700, 350);
            setLocationRelativeTo(null);
            setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            setTitle("SIGN UP");

            JPanel p3 = new JPanel();
            p3.setBounds(0, 0, 350, 350);
            p3.setLayout(null);
            p3.setBackground(Color.cyan);
            add(p3);

            JPanel p4 = new JPanel();
            p4.setBounds(350, 0, 350, 350);
            p4.setLayout(null);
            p4.setBackground(Color.white);
            add(p4);

            JLabel l8 = new JLabel("Name:");
            l8.setBounds(50, 50, 80, 25);
            p4.add(l8);

            nf.setBounds(130, 50, 165, 25);
            p4.add(nf);

            JLabel l6 = new JLabel("Username:");
            l6.setBounds(50, 100, 80, 25);
            p4.add(l6);

            uf2.setBounds(130, 100, 165, 25);
            p4.add(uf2);

            JLabel l7 = new JLabel("Password:");
            l7.setBounds(50, 150, 80, 25);
            p4.add(l7);

            pf2.setBounds(130, 150, 165, 25);
            p4.add(pf2);

            bcacc.setBounds(50, 250, 150, 25);
            p4.add(bcacc);
            bcacc.setBackground(Color.white);
            bcacc.addActionListener(this);

            bback.setBounds(240, 250, 70, 25);
            p4.add(bback);
            bback.setBackground(Color.white);
            bback.addActionListener(this);

            ImageIcon i4 = new ImageIcon("E:\\COLLEGE\\SEMESTER-2\\signinlogo1-removebg-preview.png");
            JLabel l9 = new JLabel(i4);
            l9.setBounds(0, 0, 350, 350);
            p3.add(l9);

            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == bcacc) {
                String name = nf.getText();
                String username = uf2.getText();
                String pass = new String(pf2.getPassword());

                if (userMap.containsKey(username)) {
                    JOptionPane.showMessageDialog(null, "Username already taken. Please choose another.");
                } else {
                    
                    User u = new User(name, username, pass);
                    userMap.put(username, u);
            
                
                    String sql1="{call insert_signup(?,?,?)}";
                    
                System.out.println("Executing SQL: " + sql1);
               
                
                try {
                    sql_connecor c = new sql_connecor();
                    CallableStatement cst=c.con.prepareCall(sql1);
                    cst.setString(1, name);
                    cst.setString(2,username);
                    cst.setString(3,pass);

                    if (c.con != null) {
                        System.out.println("Connection established.");
                        
                        cst.execute();
                        JOptionPane.showMessageDialog(null, "Account created successfully");
                        dispose();
                        
                    } else {
                        System.out.println("Failed to establish connection.");  
                        JOptionPane.showMessageDialog(null, "Database connection failed.");
                    }
                } catch (Exception e1) {
                e1.printStackTrace();
                   
                    JOptionPane.showMessageDialog(null, "Account creation failed. Please try again.");
                }
            }
            } else if (e.getSource() == bback) {
                dispose();
                new verification();
            }
        }
    }

    public class Login implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == blog) {
                String un1 = uf.getText();
                String p1 = pf1.getText();

                String s2 = "SELECT * FROM verification_info WHERE username='" + un1 + "' AND password='" + p1
                        + "'";
                System.out.println("Executing SQL: " + s2);
                try {
                    sql_connecor c = new sql_connecor();
                    ResultSet rs = c.st.executeQuery(s2);
                    if (rs.next()) {

                        dispose();
                        
                        new TravelManager();
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password");
                    }

                } catch (Exception e2) {
                    e2.printStackTrace();
                }

            }
        }

    }
}

class User extends verification{
    public String name;
    public String username;
    public String password;

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
