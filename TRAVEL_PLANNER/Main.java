import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import VerificationPack.*;

public class Main {
    public static void main(String[] args) throws Exception {

        JFrame f1 = new JFrame();
        ImageIcon i1 = new ImageIcon("E:\\COLLEGE\\SEMESTER-2\\logo1.png");
        ImageIcon i2 = new ImageIcon("E:\\COLLEGE\\SEMESTER-2\\travelplanner2.png");
        JLabel l1 = new JLabel();

        f1.setIconImage(i1.getImage());

        f1.setResizable(false);
        f1.setTitle("TRAVEL PLANNER");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setSize(500, 500);
        f1.setLocationRelativeTo(null);
        f1.setVisible(true);
        f1.getContentPane().setBackground(new Color(255, 255, 204));
        f1.add(l1);

        l1.setText("TRAVEL PLANNER");

        l1.setIcon(i2);
        l1.setHorizontalTextPosition(JLabel.CENTER);
        l1.setVerticalTextPosition(JLabel.TOP);
        l1.setVerticalAlignment(JLabel.CENTER);
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(new Font("times new roman", Font.BOLD, 30));

        Thread.sleep(3000);
        
        f1.setVisible(false);

        new verification();
    }
}