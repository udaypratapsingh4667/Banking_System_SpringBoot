package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    String pin;
    JTextField textField;
    JButton b1, b2;

    Deposit(String pin) {

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(460, 180, 400, 35);
        l1.setForeground(Color.WHITE);
        l3.add(l1);                                                          // when you want to override then l3.add() otherwise simply on the JFrame add()

        textField = new JTextField();
        textField.setBounds(460, 230, 320, 25);
        textField.setFont(new Font("Raleway", Font.BOLD, 20));
        textField.setBackground(new Color(65, 125, 128));
        textField.setForeground(Color.WHITE);
        l3.add(textField);

        //Deposit Button
        b1 = new JButton("DEPOSIT");
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
        if (e.getSource() == b1) { // Agar Deposit Button dabaya
            try {
                String amountStr = textField.getText();

                if (amountStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter amount");
                } else {
                    double amount = Double.parseDouble(amountStr);

                    // API Call (Dekho kitna simple ho gaya)
                    if (BankAPI.deposit(amount)) {
                        JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully");
                        setVisible(false);
                        new main_Class(pin).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Deposit Failed!");
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}

