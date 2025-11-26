package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Withdrawal extends JFrame implements ActionListener {

    String pin;
    JTextField textField;
    JButton b1, b2;

    Withdrawal(String pin) {

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel l1 = new JLabel("MAXIMUM WITHDRAWAL IS Rs.10,000");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(480, 160, 400, 35);
        l1.setForeground(Color.WHITE);
        l3.add(l1);                                // when you want to override then l3.add() otherwise simply on the JFrame add()

        JLabel l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setBounds(435, 210, 400, 35);
        l2.setForeground(Color.WHITE);
        l3.add(l2);

        textField = new JTextField();
        textField.setBounds(435, 250, 320, 25);
        textField.setFont(new Font("Raleway", Font.BOLD, 20));
        textField.setBackground(new Color(65, 125, 128));
        textField.setForeground(Color.WHITE);
        l3.add(textField);

        //Withdraw Button
        b1 = new JButton("WITHDRAW");
        b1.setBounds(700, 364, 150, 35);
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        //Back Button
        b2 = new JButton("BACK");
        b2.setBounds(700, 408, 150, 35);
        b2.setBackground(new Color(65, 125, 128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);


        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == b1) { // WITHDRAW BUTTON Logic

                    // 1. Text Field se amount nikalo
                    String amountStr = textField.getText();

                    // 2. Check karo khali toh nahi hai
                    if (amountStr.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");
                    } else {
                        // String ko number mein badlo
                        double amount = Double.parseDouble(amountStr);

                        // 3. API Call: Backend se paise katwao
                        if (BankAPI.withdraw(amount)) {
                            // Agar true aaya (Success)
                            JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                            setVisible(false);
                            new main_Class(pin).setVisible(true);
                        } else {
                            // Agar false aaya (Fail - Balance kam hai ya error)
                            JOptionPane.showMessageDialog(null, "Insufficient Balance or Transaction Failed");
                        }
                    }
                } else if (e.getSource() == b2) { // BACK BUTTON Logic
                    setVisible(false);
                    new main_Class(pin).setVisible(true);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

