package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {

    JButton b1,b2;
    JPasswordField p1,p2;

    String pin;

    Pin(String pin){

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,1550,830);
        add(label);

        JLabel l1 = new JLabel("CHANGE YOUR PIN: ");
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setBounds(430,180,400,35);
        l1.setForeground(Color.WHITE);
        label.add(l1);

        JLabel l2 = new JLabel("Create New Pin: ");
        l2.setFont(new Font("System",Font.BOLD,14));
        l2.setBounds(430,220,150,35);
        l2.setForeground(Color.WHITE);
        label.add(l2);

        p1 = new JPasswordField();
        p1.setFont(new Font("Raleway",Font.BOLD,20));
        p1.setBackground(new Color(65,125,128));
        p1.setBounds(580,225,180,25);
        p1.setForeground(Color.WHITE);
        label.add(p1);

        JLabel l3 = new JLabel("Re-Enter New Pin: ");
        l3.setFont(new Font("System",Font.BOLD,14));
        l3.setBounds(430,250,400,35);
        l3.setForeground(Color.WHITE);
        label.add(l3);

        p2 = new JPasswordField();
        p2.setFont(new Font("Raleway",Font.BOLD,20));
        p2.setBackground(new Color(65,125,128));
        p2.setBounds(580,255,180,25);
        p2.setForeground(Color.WHITE);
        label.add(p2);

        //Change Pin Button
        b1 = new JButton("CHANGE");
        b1.setBounds(700,364,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        label.add(b1);

        //Back Button
        b2 = new JButton("BACK");
        b2.setBounds(700,408,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        label.add(b2);

        setSize(1550,1080);
        setLayout(null);
        setLocation(0,0);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // 1. Text Fields se Naya PIN nikalo
            String pin1 = new String(p1.getPassword());
            String pin2 = new String(p2.getPassword());

            // 2. Check karo: Dono PIN same hain ya nahi?
            if (!pin1.equals(pin2)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            // --- CHANGE BUTTON LOGIC ---
            if (e.getSource() == b1) {

                if (pin1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return;
                }

                    // API CALL: Backend ko bola PIN badal de
                    if (BankAPI.changePin(pin2)) {
                        // SUCCESS
                        JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                        setVisible(false);
                        // Naye PIN ke sath Main Menu kholo
                        new main_Class(pin2).setVisible(true);
                    } else {
                        // FAILURE
                        JOptionPane.showMessageDialog(null, "Error! Server Issue or Invalid Request.");
                    }
                }

            // --- BACK BUTTON LOGIC ---
            if (e.getSource() == b2) {
                setVisible(false);
                // Purane PIN ke sath wapas jao
                new main_Class(pin).setVisible(true);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
