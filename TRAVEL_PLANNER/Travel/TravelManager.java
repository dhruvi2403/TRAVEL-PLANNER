package Travel;

import java.util.*;
import javax.swing.*;
import VerificationPack.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import hotel.*;
import linklist.*;
import stack.*;

public class TravelManager extends linklist {

    public linklist tpack;

    JFrame f;
    JFrame itifr;
    JButton bbak;
    JButton bbok;
    JButton bchose;
    JFrame f2;
    TravelPackage tPackage;
    Hotel h;
    JButton bh;
    JButton vp;
    JFrame itf;
    TravelPackage tp;
    JButton bbac;

    public void initializePackages() {

        Hotel maH1 = new Hotel("Hotel Manali Inn",
                new ArrayList<>(Arrays.asList("manali1.jpg", "manali2.jpg", "manali3.jpg")));
        Hotel maH2 = new Hotel("Hotel Snow Peak",
                new ArrayList<>(Arrays.asList("snow1.jpg", "snow2.jpg", "snow3.jpg")));

        Hotel dH1 = new Hotel("Hotel Darjeeling Palace",
                new ArrayList<>(Arrays.asList("darjeeling1.jpg", "darjeeling2.jpg", "darjeeling3.jpg")));
        Hotel dH2 = new Hotel("Hotel Hill View",
                new ArrayList<>(Arrays.asList("hill1.jpg", "hill2.jpg", "hill3.jpg")));

        Hotel muH1 = new Hotel("Hotel Mumbai Grand",
                new ArrayList<>(Arrays.asList("mumbai1.jpg", "mumbai2.jpg", "mumbai3.jpg")));
        Hotel muH2 = new Hotel("Hotel Sea View", new ArrayList<>(Arrays.asList("sea1.jpg", "sea2.jpg", "sea3.jpg")));

        Hotel gH1 = new Hotel("Hotel Goa Beach", new ArrayList<>(Arrays.asList("goa1.jpg", "goa2.jpg", "goa3.jpg")));
        Hotel gH2 = new Hotel("Hotel Sand Dunes",
                new ArrayList<>(Arrays.asList("sand1.jpg", "sand2.jpg", "sand3.jpg")));

        TravelPackage tp1 = new TravelPackage("Manali", "Himachal Pradesh", "₹20,000 ", "5 Days, 4 Nights",
                "Nature's masterpiece: Manali.",
                new LinkedList<>(Arrays.asList(maH1, maH2)));

        TravelPackage tp2 = new TravelPackage("Darjeeling", "West Bengal", "₹25,000 ", "6 Days, 5 Nights",
                "The sweetest part of India.",
                new LinkedList<>(Arrays.asList(dH1, dH2)));

        TravelPackage tp3 = new TravelPackage("Mumbai", "Maharashtra", "₹30,000 ", "7 Days, 6 Nights",
                "Unlimited.",
                new LinkedList<>(Arrays.asList(muH1, muH2)));

        TravelPackage tp4 = new TravelPackage("Goa", "Goa", "₹22,000 ", "5 Days, 4 Nights",
                "A perfect holiday destination.",
                new LinkedList<>(Arrays.asList(gH1, gH2)));

        // we can Add packages to the list by default method
        // tpack.add(tp1);
        // tpack.add(tp2);
        // tpack.add(tp3);
        // tpack.add(tp4);
        // or add packages by using user generated insertatlast method

        tpack.insertatlast(tp1);
        tpack.insertatlast(tp2);
        tpack.insertatlast(tp3);
        tpack.insertatlast(tp4);

    }

    public TravelManager() {
        this.tpack = new linklist();
        initializePackages();
        seepackages();
        s_display();
    }

    public void seepackages() {
        f = new JFrame("Travel Packages");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 600);
        f.setLocationRelativeTo(null);
        f.setFont(new Font("STXinwei", Font.PLAIN, 20));

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 1, 10, 0));

        for (TravelPackage t : tpack) {
            JPanel p2 = new JPanel();
            p2.setLayout(new BorderLayout());

            JTextArea packdetail = new JTextArea(t.toString());
            packdetail.setEditable(false);
            packdetail.setBackground(new Color(255, 255, 102));
            p2.add(packdetail, BorderLayout.CENTER);
            packdetail.setFont(new Font("STXinwei", Font.PLAIN, 15));

            bbok = new JButton("BOOK " + t.getDestination().toUpperCase());
            bbok.setBackground(new Color(255, 255, 0));
            bbok.setForeground(Color.black);
            bbok.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
            bbok.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    s_push(f);
                    showItineraries(t);
                    s_display();
                }
            });
            p2.add(bbok, BorderLayout.SOUTH);

            p.add(p2);
        }

        bbak = new JButton("Back");
        bbak.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        bbak.setBackground(new Color(230, 230, 0));
        bbak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                if (!s_isEmpty()) {
                    JFrame prev = s_pop();
                    s_display();
                    prev.setVisible(true);

                } else {
                    new verification();
                }
            }
        });
        f.getContentPane().add(bbak, BorderLayout.SOUTH);

        f.getContentPane().add(new JScrollPane(p));
        f.setVisible(true);
    }

    public void showItineraries(TravelPackage t) {
        itifr = new JFrame("Choose Your Itinerary");
        itifr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        itifr.setLayout(new GridLayout(2, 1));
        itifr.setSize(700, 470);
        itifr.setLocationRelativeTo(null);
        itifr.getContentPane().setBackground(new Color(102, 217, 255));

        String iti1 = readfile(t.getDestination().toLowerCase() + "iter1.txt");
        String iti2 = readfile(t.getDestination().toLowerCase() + "iter2.txt");

        JPanel p3 = crteitipanel(iti1, "Choose Itinerary 1", t, itifr);
        p3.setBackground(new Color(102, 217, 255));
        JPanel p4 = crteitipanel(iti2, "Choose Itinerary 2", t, itifr);
        p4.setBackground(new Color(102, 217, 255));

        itifr.add(p3);
        itifr.add(p4);

        s_push(itifr); // Push the itinerary frame to the stack
        s_display();
        itifr.setVisible(true);
    }

    public JPanel crteitipanel(String itinerary, String buttonText, TravelPackage tPackage, JFrame itf) {
        JPanel p5 = new JPanel();
        p5.setLayout(new BorderLayout());

        JTextArea itiar = new JTextArea(itinerary);
        itiar.setEditable(false);
        itiar.setBackground(new Color(102, 217, 255));
        p5.add(new JScrollPane(itiar), BorderLayout.CENTER);

        bchose = new JButton(buttonText);
        bchose.setBackground(Color.WHITE);
        // bchose.addActionListener(this);
        bchose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itf.setVisible(false);
                hotelopt(tPackage);
            }
        });

        p5.add(bchose, BorderLayout.SOUTH);

        return p5;
    }

    public String readfile(String filePath) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String l;
            while ((l = br.readLine()) != null) {
                sb.append(l).append("\n");
            }
        } catch (IOException e) {
            sb.append("Error: Unable to load itinerary from ").append(filePath);
            // e.printStackTrace();
            System.out.println(e);
        }

        return sb.toString();
    }

    public void hotelopt(TravelPackage tp) {
        f2 = new JFrame("Choose a Hotel for " + tp.getDestination());
        f2.setSize(400, 225);
        f2.setLocationRelativeTo(null);
        f2.getContentPane().setBackground(new Color(102, 217, 255));
        JPanel hp1 = new JPanel();
        hp1.setBackground(new Color(128, 223, 255));
        hp1.setLayout(new GridLayout(tp.getHotels().size(), 1, 10, 10));

        for (Hotel h : tp.getHotels()) {
            JPanel p6 = new JPanel();
            p6.setLayout(new BorderLayout());

            JLabel l1 = new JLabel(h.getName());
            p6.add(l1, BorderLayout.NORTH);

            JButton bh = new JButton("Book Hotel");
            bh.setBackground(new Color(191, 191, 191));

            bh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Hotel(tp, f2);
                    f2.setVisible(false);
                }
            });
            p6.add(bh, BorderLayout.CENTER);

            vp = new JButton("View Pictures");
            vp.setBackground(new Color(191, 191, 191));
            // vp.addActionListener(this);
            vp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    viewhpic(h);
                }
            });
            p6.add(vp, BorderLayout.SOUTH);

            hp1.add(p6);
        }

        bbac = new JButton("Back");
        bbac.setBackground(new Color(163, 194, 194));
        // bbac.addActionListener(this);
        bbac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.setVisible(false);

                if (!s_isEmpty()) {
                    JFrame prev = s_pop();
                    s_display();
                    prev.setVisible(true);
                }
            }
        });
        f2.getContentPane().add(bbac, BorderLayout.SOUTH);

        f2.getContentPane().add(new JScrollPane(hp1));
        f.setVisible(false);
        f2.setVisible(true);
    }

    public void viewhpic(Hotel hotel) {
        JFrame f3 = new JFrame("Pictures of " + hotel.getName());
        f3.setSize(1100, 295);

        f3.setLocationRelativeTo(null);
        f3.setResizable(false);

        JPanel p7 = new JPanel();
        p7.setLayout(new GridLayout(1, hotel.getPhotoPaths().size(), 10, 10));

        for (String pik : hotel.getPhotoPaths()) {
            JLabel l2 = new JLabel(new ImageIcon(pik));
            p7.add(l2);
        }

        f3.getContentPane().add(new JScrollPane(p7));
        f3.setVisible(true);
    }

    public void displaypic(Hotel h) {
        JFrame f4 = new JFrame("Hotel Photos:" + h.getName());
        f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f4.setResizable(false);
        f4.setSize(1100, 275);
        f4.setLocationRelativeTo(null);
        JPanel p1 = new JPanel();
        f4.add(p1);

        for (String pic : h.getPhotoPaths()) {
            ImageIcon i = new ImageIcon(pic);
            JLabel l = new JLabel(i);
            p1.add(l);
        }
        f4.setVisible(true);
    }

}
