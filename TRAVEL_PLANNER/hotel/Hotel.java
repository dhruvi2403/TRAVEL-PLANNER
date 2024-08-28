package hotel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import Connector.*;
import Travel.*;
import Booking.*;

public class Hotel {
    String name;
    ArrayList<String> photoPaths;
    public static int noofppl;
    public static String cname;
    

    public Hotel(String name, ArrayList<String> photoPaths) {
        this.name = name;
        this.photoPaths = photoPaths;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getPhotoPaths() {
        return photoPaths;
    }

    public Hotel(TravelPackage tp, JFrame f2) {

        JFrame f4 = new JFrame("Details for Booking Hotel");
        f4.getContentPane().setBackground(new Color(128, 223, 255));
        f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f4.setSize(650, 450);
        f4.setLayout(null);
        f4.setLocationRelativeTo(null);

        JLabel l1 = new JLabel("Enter the number of people you want to book package for:");
        l1.setBounds(30, 45, 340, 25);
        JTextField nppl = new JTextField();
        nppl.setBounds(390, 45, 80, 25);

        JLabel l2 = new JLabel("Enter your name:");
        l2.setBounds(30, 80, 150, 25);
        JTextField ename = new JTextField();
        ename.setBounds(250, 80, 350, 25);

        JLabel l3 = new JLabel("Enter your age:");
        l3.setBounds(30, 115, 180, 25);
        JTextField eage = new JTextField();
        eage.setBounds(250, 115, 350, 25);

        JLabel l4 = new JLabel("Enter your phone number:");
        l4.setBounds(30, 150, 180, 25);
        JTextField epno = new JTextField();
        epno.setBounds(250, 150, 350, 25);

        JLabel l5 = new JLabel("Enter your aadhar number:");
        l5.setBounds(30, 185, 180, 25);
        JTextField eaadhr = new JTextField();
        eaadhr.setBounds(250, 185, 350, 25);
        JLabel l6 = new JLabel("Enter your address:");
        l6.setBounds(30, 220, 180, 25);
        JTextField eadd = new JTextField();
        eadd.setBounds(250, 220, 350, 25);
        JLabel l7 = new JLabel("Select your gender:");
        l7.setBounds(30, 255, 150, 25);
        String[] gender = { "Male", "Female", "Other" };
        JComboBox<String> gdrop = new JComboBox<>(gender);
        gdrop.setBounds(250, 255, 350, 25);

        JButton adet = new JButton("Add details");
        adet.setBounds(250, 290, 100, 25);
        adet.setBackground(Color.WHITE);

        JButton bbac = new JButton("Back");
        bbac.setBounds(250, 320, 100, 25);
        bbac.setBackground(Color.WHITE);

        f4.add(l1);
        f4.add(nppl);
        f4.add(adet);
        f4.add(l2);
        f4.add(ename);
        f4.add(l3);
        f4.add(eage);
        f4.add(l4);
        f4.add(epno);
        f4.add(l5);
        f4.add(eaadhr);
        f4.add(l6);
        f4.add(eadd);
        f4.add(l7);
        f4.add(gdrop);
        f4.add(bbac);

        f4.setVisible(true);

        adet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                     cname = ename.getText();
                    int age = Integer.parseInt(eage.getText());
                    long pno = Long.parseLong(epno.getText());
                    long aadharno = Long.parseLong(eaadhr.getText());
                    String address = eadd.getText();
                    String gender = gdrop.getSelectedItem().toString();
                     noofppl = Integer.parseInt(nppl.getText());

                    boolean hasnum = false;
                    for (char c : cname.toCharArray()) {
                        if (Character.isDigit(c)) {
                            hasnum = true;
                            break;
                        }
                    }
                    if (age < 18) {
                        JOptionPane.showMessageDialog(f4, "You cannot book as you are a minor in age");
                    }
                    else if (hasnum) {
                        JOptionPane.showMessageDialog(f4, "Please enter a valid name it should not have numbers");
                    } else {
                       // String s3 = "insert into cust_info values(null,?,?,?,?,?,?,?)";
                       String s3="{call insert_cust(?,?,?,?,?,?,?)}";
                        sql_connecor c = new sql_connecor();
                        CallableStatement cst2=c.con.prepareCall(s3);
                        //PreparedStatement pst1 = c.con.prepareStatement(s3);
                        cst2.setString(1, cname);
                        cst2.setLong(2, pno);
                        cst2.setString(3, gender);
                        cst2.setLong(4, aadharno);
                        cst2.setString(5, address);
                        cst2.setInt(6, age);
                        cst2.setInt(7, noofppl);
                        cst2.execute();
                        System.out.println("Record inserted successfully");
                        JOptionPane.showMessageDialog(f4, "Record inserted successfully");
                        booking b1 = new booking();
                        b1.seebooking(tp, noofppl, f4, f2);
                       // b1.generate(name,noofppl,tp);
                        f4.dispose();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println(e);
                    JOptionPane.showMessageDialog(f4, "An error occurred try again.");
                }
            }
        });

        bbac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f4.dispose();
                f2.setVisible(true);
            }
        });
    }

}
