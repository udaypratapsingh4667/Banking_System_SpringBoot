package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String pin;

    JLabel l2;
    JButton b1;

    BalanceEnquiry(String pin){

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

//        JLabel l1 = new JLabel("Your Current Balance is Rs. ");
//        l1.setFont(new Font("System",Font.BOLD,16));
//        l1.setBounds(450,160,400,35);
//        l1.setForeground(Color.WHITE);
//        l3.add(l1);                                // when you want to override then l3.add() otherwise simply on the JFrame add()

        l2 = new JLabel();
        l2.setFont(new Font("System",Font.BOLD,16));
        l2.setBounds(450,210,400,35);
        l2.setForeground(Color.WHITE);
        l3.add(l2);

        //Back Button
        b1 = new JButton("BACK");
        b1.setBounds(700,408,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        // --- API CALL TO GET BALANCE ---
        double balance = BankAPI.getBalance(); // Backend se balance mango

        JLabel text = new JLabel("Your Current Account Balance is Rs " + balance);
        text.setForeground(Color.WHITE);
        text.setBounds(430, 180, 700, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        l3.add(text);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main_Class(pin);
    }
}
