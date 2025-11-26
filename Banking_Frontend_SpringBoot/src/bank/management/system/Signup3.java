package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton a1, a2, a3, a4;
    JCheckBox s1, s2, s3, s4, s5, s6;
    JCheckBox c1;
    JButton s, c;
    String form_no;

    Signup3(String form_no) {
        super("Account Details Form");
        this.form_no = form_no;

        // --- UI Setup (Kept exactly as your original code) ---
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(60, 15, 100, 100);
        add(image);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setForeground(Color.BLACK);
        l1.setBounds(305, 70, 600, 40);
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        add(l1);

        JPanel line = new JPanel();
        line.setBounds(0, 130, 850, 2);
        line.setBackground(Color.BLACK);
        add(line);

        JLabel l3 = new JLabel("Account Type:");
        l3.setBounds(105, 145, 200, 40);
        l3.setFont(new Font("Arial", Font.BOLD, 18));
        add(l3);

        a1 = new JRadioButton("Savings Account");
        a1.setFont(new Font("Arial", Font.BOLD, 14));
        a1.setBackground(Color.WHITE);
        a1.setBounds(105, 180, 200, 40);
        add(a1);

        a2 = new JRadioButton("Fixed Deposit Account");
        a2.setFont(new Font("Arial", Font.BOLD, 14));
        a2.setBackground(Color.WHITE);
        a2.setBounds(355, 180, 300, 40);
        add(a2);

        a3 = new JRadioButton("Current Account");
        a3.setFont(new Font("Arial", Font.BOLD, 14));
        a3.setBackground(Color.WHITE);
        a3.setBounds(105, 220, 200, 40);
        add(a3);

        a4 = new JRadioButton("Recurring Deposit Account");
        a4.setFont(new Font("Arial", Font.BOLD, 14));
        a4.setBackground(Color.WHITE);
        a4.setBounds(355, 220, 300, 40);
        add(a4);

        ButtonGroup a1234 = new ButtonGroup();
        a1234.add(a1);
        a1234.add(a2);
        a1234.add(a3);
        a1234.add(a4);

        JLabel l4 = new JLabel("Card Number:");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(105, 300, 200, 30);
        add(l4);

        JLabel l5 = new JLabel("(Your 16-digit Card Number)");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));
        l5.setBounds(105, 330, 200, 20);
        add(l5);

        JLabel l6 = new JLabel("XXXX-XXXX-XXXX-4667");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        l6.setBounds(335, 300, 250, 30);
        add(l6);

        JLabel l7 = new JLabel("(It would appear on ATM Card/Cheque Book and Statements)");
        l7.setFont(new Font("Raleway", Font.BOLD, 12));
        l7.setBounds(335, 330, 400, 20);
        add(l7);

        JLabel l8 = new JLabel("PIN:");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(105, 370, 200, 30);
        add(l8);

        JLabel l9 = new JLabel("XXXX");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));
        l9.setBounds(335, 370, 250, 30);
        add(l9);

        JLabel l10 = new JLabel("(4-digit password)");
        l10.setFont(new Font("Raleway", Font.BOLD, 12));
        l10.setBounds(105, 400, 400, 20);
        add(l10);

        JLabel l11 = new JLabel("Services Required:");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));
        l11.setBounds(105, 450, 200, 30);
        add(l11);

        s1 = new JCheckBox("ATM Card");
        s1.setFont(new Font("Raleway", Font.BOLD, 14));
        s1.setBackground(Color.WHITE);
        s1.setBounds(110, 500, 100, 30);
        add(s1);

        s2 = new JCheckBox("Internet Banking");
        s2.setFont(new Font("Raleway", Font.BOLD, 14));
        s2.setBackground(Color.WHITE);
        s2.setBounds(360, 500, 150, 30);
        add(s2);

        s3 = new JCheckBox("Mobile Banking");
        s3.setFont(new Font("Raleway", Font.BOLD, 14));
        s3.setBackground(Color.WHITE);
        s3.setBounds(110, 545, 150, 30);
        add(s3);

        s4 = new JCheckBox("EMAIL Alerts");
        s4.setFont(new Font("Raleway", Font.BOLD, 14));
        s4.setBackground(Color.WHITE);
        s4.setBounds(360, 545, 150, 30);
        add(s4);

        s5 = new JCheckBox("Cheque Book");
        s5.setFont(new Font("Raleway", Font.BOLD, 14));
        s5.setBackground(Color.WHITE);
        s5.setBounds(110, 590, 150, 30);
        add(s5);

        s6 = new JCheckBox("E-Statement");
        s6.setFont(new Font("Raleway", Font.BOLD, 14));
        s6.setBackground(Color.WHITE);
        s6.setBounds(360, 590, 150, 30);
        add(s6);

        c1 = new JCheckBox("I hearby declared that the above entered details correct to the best of my knowledge.", true);
        c1.setFont(new Font("Raleway", Font.BOLD, 12));
        c1.setBounds(105, 660, 550, 20);
        c1.setBackground(Color.WHITE);
        add(c1);

        JLabel l12 = new JLabel("Form No :");
        l12.setFont(new Font("Raleway", Font.BOLD, 18));
        l12.setBounds(655, 20, 100, 30);
        add(l12);

        JLabel l13 = new JLabel(form_no);
        l13.setFont(new Font("Raleway", Font.BOLD, 18));
        l13.setBounds(750, 20, 60, 30);
        add(l13);

        s = new JButton("Submit");
        s.setFont(new Font("Raleway", Font.BOLD, 14));
        s.setBounds(245, 700, 100, 30);
        s.setForeground(Color.WHITE);
        s.setBackground(Color.BLACK);
        s.addActionListener(this);
        add(s);

        c = new JButton("Cancel");
        c.setFont(new Font("Raleway", Font.BOLD, 14));
        c.setBounds(425, 700, 100, 30);
        c.setForeground(Color.WHITE);
        c.setBackground(Color.BLACK);
        c.addActionListener(this);
        add(c);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(345, 30);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String acctype = null;
        if (a1.isSelected()) {
            acctype = "Savings Account";
        } else if (a2.isSelected()) {
            acctype = "Fixed Deposit Account";
        } else if (a3.isSelected()) {
            acctype = "Current Account";
        } else if (a4.isSelected()) {
            acctype = "Recurring Deposit Account";
        }

        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String card_no = "" + Math.abs(first7);

        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

        String ser = "";
        if (s1.isSelected()) ser += " ATM Card";
        if (s2.isSelected()) ser += " Internet Banking";
        if (s3.isSelected()) ser += " Mobile Banking";
        if (s4.isSelected()) ser += " EMAIl Alerts";
        if (s5.isSelected()) ser += " Cheque Book";
        if (s6.isSelected()) ser += " E-Statement";

        try {
            if (e.getSource() == s) { // Submit Button Logic

                // Validation
                if (acctype == null) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else if (!c1.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please Accept the Declaration");
                } else {

                    // --- API CALL ---
                    // Backend ko bolo account create kare
                    if (BankAPI.createAccount(form_no, acctype, card_no, pin, ser)) {

                        // Success Message
                        JOptionPane.showMessageDialog(null, "Card Number: " + card_no + "\n Pin: " + pin);

                        // Navigate to Deposit Screen
                        setVisible(false);
                        new Deposit(pin).setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "Error creating account! Please try again.");
                    }
                }

            } else if (e.getSource() == c) { // Cancel Button
                setVisible(false);
                new Login().setVisible(true);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}