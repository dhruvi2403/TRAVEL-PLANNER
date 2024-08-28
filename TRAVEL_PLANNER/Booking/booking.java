
package Booking;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Travel.*;
import generatereceipt.generatereceipt;
import hotel.*;

public class booking implements ActionListener {
    public JButton pb, bbac, cc, dc, bp, bpay;
    public JPanel p1;
    public JFrame f1, f5;
    public TravelPackage tpp;
    public JFrame f2;
    int tamt;
    int amount = tamt;
    String pay_method = "";
    String name_on_card="-";
    String card_no="-";
    String cust_id="-";
    String username;
    String name = Hotel.cname;
int noOfPeople = Hotel.noofppl;
//TravelPackage travelPackage = Hotel.tpac;

    public void seebooking(TravelPackage tpp, int ppl, JFrame f4, JFrame f2) {
        this.tpp = tpp;
        this.f2 = f2;
        f1 = new JFrame("Booking Details");
        f1.setSize(400, 300);
        f1.setLocationRelativeTo(null);
        f1.setLayout(new GridLayout(4, 1));
        f1.getContentPane().setBackground(new Color(102, 217, 255));
        int price = Integer.parseInt(tpp.getPrice().replaceAll("[^0-9]", ""));
        tamt = price * ppl;

        JLabel l1 = new JLabel("Total Amount to be Paid: ₹" + tamt);
        l1.setFont(new Font("Arial", Font.BOLD, 16));
        l1.setHorizontalAlignment(SwingConstants.CENTER);

        pb = new JButton("Proceed");
        pb.setBackground(Color.WHITE);
        pb.addActionListener(this);

        bbac = new JButton("Back");
        bbac.setBackground(new Color(163, 194, 194));
        bbac.addActionListener(this);

        f1.add(l1);
        f1.add(pb);
        f1.add(bbac);
        f1.setVisible(true);
    }

    public void showPaymentFrame(TravelPackage travelPackage) {
        f5 = new JFrame("Payment Options");
        f5.setSize(400, 400);
        f5.setLocationRelativeTo(null);
        f5.setLayout(null);
        f5.getContentPane().setBackground(new Color(102, 217, 255));

        JLabel l2 = new JLabel("Choose Payment Option:");
        l2.setFont(new Font("Arial", Font.BOLD, 16));
        l2.setBounds(100, 10, 200, 30);

        cc = new JButton("Credit Card");
        cc.setBounds(50, 50, 120, 30);
        cc.setBackground(Color.WHITE);
        cc.addActionListener(this);

        dc = new JButton("Debit Card");
        dc.setBounds(200, 50, 120, 30);
        dc.setBackground(Color.WHITE);
        dc.addActionListener(this);

        bp = new JButton("Bank Payment");
        bp.setBounds(125, 90, 150, 30);
        bp.setBackground(Color.WHITE);
        bp.addActionListener(this);

        p1 = new JPanel(null);
        p1.setBounds(50, 130, 300, 100);
        p1.setBackground(new Color(204, 242, 255));

        bpay = new JButton("Pay");
        bpay.setBounds(150, 240, 100, 30);
        bpay.setBackground(Color.WHITE);
        bpay.addActionListener(this);

        f5.add(l2);
        f5.add(cc);
        f5.add(dc);
        f5.add(bp);
        f5.add(p1);
        f5.add(bpay);

        f5.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == pb) {
            f1.setVisible(false);
            showPaymentFrame(tpp);
        } else if (e.getSource() == bbac) {
            f1.setVisible(false);
            new Hotel(tpp, f2);
        } else if (e.getSource() == cc) {
            pay_method = "Credit Card";
            p1.removeAll();
            p1.add(new JLabel("Card Number:")).setBounds(10, 0, 90, 25);
            JTextField cf = new JTextField();
            cf.setBounds(100, 0, 180, 25);
            card_no = cf.getText();
            p1.add(cf);

            p1.add(new JLabel("CVV:")).setBounds(10, 30, 90, 25);
            JTextField cvvf = new JTextField();
            cvvf.setBounds(100, 30, 180, 25);
            p1.add(cvvf);

            p1.add(new JLabel("Expiry Date:")).setBounds(10, 60, 90, 25);
            JTextField exf = new JTextField();
            exf.setBounds(100, 60, 180, 25);
            p1.add(exf);

            p1.revalidate();
            p1.repaint();
        } else if (e.getSource() == dc) {
            pay_method = "Debit Card";
            p1.removeAll();
            p1.add(new JLabel("Card Number:")).setBounds(10, 0, 90, 25);
            JTextField cf = new JTextField();
            cf.setBounds(100, 0, 180, 25);
            card_no = cf.getText();
            p1.add(cf);

            p1.add(new JLabel("CVV:")).setBounds(10, 30, 90, 25);
            JTextField cvvf = new JTextField();
            cvvf.setBounds(100, 30, 180, 25);
            p1.add(cvvf);

            p1.add(new JLabel("Expiry Date:")).setBounds(10, 60, 90, 25);
            JTextField exf = new JTextField();
            exf.setBounds(100, 60, 180, 25);
            p1.add(exf);

            p1.revalidate();
            p1.repaint();
        } else if (e.getSource() == bp) {
            pay_method = "Bank Payment";

            p1.removeAll();
            p1.add(new JLabel("Name on Card:")).setBounds(10, 0, 90, 25);
            JTextField nf = new JTextField();
            nf.setBounds(100, 0, 180, 25);
            name_on_card = nf.getText();
            p1.add(nf);

            p1.add(new JLabel("Customer ID:")).setBounds(10, 30, 90, 25);
            JTextField cid = new JTextField();
            cid.setBounds(100, 30, 180, 25);
            cust_id = cid.getText();

            p1.add(cid);

            p1.add(new JLabel("Password:")).setBounds(10, 60, 90, 25);
            JPasswordField pf = new JPasswordField();
            pf.setBounds(100, 60, 180, 25);
            p1.add(pf);

            p1.revalidate();
            p1.repaint();
        } else if (e.getSource() == bpay) {
            boolean allfilled = true;
            if (p1.getComponents().length == 6) {
                for (Component c1 : p1.getComponents()) {
                    if (c1 instanceof JTextField && ((JTextField) c1).getText().isEmpty()) {
                        allfilled = false;
                        break;
                    }
                }
            } else {
                allfilled = false;
            }

            if (allfilled) {
                    generatereceipt g=new generatereceipt();
                    g.genreceipt(name,noOfPeople,tpp,pay_method,tamt);
                
                JOptionPane.showMessageDialog(f5, "Payment done successfully! Thanks for using our services.");
                f5.dispose();
            } else {
                JOptionPane.showMessageDialog(f5, "Payment not done! Please fill all the fields.");
            }
        }
        
    }

}
