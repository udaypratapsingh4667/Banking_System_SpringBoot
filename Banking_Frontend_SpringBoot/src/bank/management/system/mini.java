package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import static bank.management.system.BankAPI.TransactionDetail; // Import helper class

public class mini extends JFrame implements ActionListener {

    String pin;
    JButton button1, button2;

    mini(String pin) {
        this.pin = pin;

        // --- Frame Setup ---
        getContentPane().setBackground(new Color(105, 226, 246));
        setLayout(null);
        setSize(400, 600);
        setLocation(570, 100);

        // Title Label
        JLabel l2 = new JLabel("Mini Statement");
        l2.setFont(new Font("System", Font.BOLD, 15));
        l2.setBounds(150, 20, 200, 20);
        add(l2);

        // Line under title
        JPanel line = new JPanel();
        line.setBounds(148, 42, 114, 2);
        line.setBackground(Color.BLACK);
        add(line);

        String cardNumber = BankAPI.getCardNumber();

        // Account ID Label
        JLabel l3 = new JLabel("Card Number: " + (cardNumber.equals("N/A") ? "N/A" : cardNumber));
        l3.setBounds(20, 80, 300, 20);
        add(l3);

        // --- Transaction History Area ---
        // Using JTextArea inside JScrollPane for better list display
        JTextArea historyArea = new JTextArea();
        historyArea.setEditable(false);
        historyArea.setFont(new Font("Monospaced", Font.PLAIN, 12)); // Monospaced font for alignment

        JScrollPane scrollPane = new JScrollPane(historyArea);
        scrollPane.setBounds(20, 140, 350, 300);
        add(scrollPane);

        // Balance Label
        JLabel l4 = new JLabel();
        l4.setBounds(20, 460, 300, 22);
        l4.setFont(new Font("System", Font.BOLD, 14));
        add(l4);

        // --- FETCH DATA FROM API ---
        double balance = 0;
        StringBuilder sb = new StringBuilder();

        // Header
        sb.append(String.format("%-20s %-10s %14s\n", "Date", "Type", "Amount"));
        sb.append("-----------------------------------------------\n");

        if (BankAPI.currentUserId != null) {
            try {
                // 1. Get Transactions List
                List<TransactionDetail> transactions = BankAPI.getMiniStatement();

                for (TransactionDetail t : transactions) {
                    // Format date (taking first 10 chars e.g. 2023-10-25)
                    String dateStr = (t.timestamp != null) ? t.timestamp : "N/A";
                    if (dateStr.length() > 10) dateStr = dateStr.substring(0, 10);

                    // Format Type (DEPOSIT/WITHDRAW)
                    String type = (t.transactionType != null && t.transactionType.equals("DEPOSIT")) ? "DEPOSIT" : "WITHDRAW";

                    // Add to list
                    sb.append(String.format("%-20s %-10s %14d\n", dateStr, type, (int)t.amount));
                }

                // 2. Get Current Balance
                balance = BankAPI.getBalance();

            } catch (Exception e) {
                sb.append("\nError fetching data from server.");
                e.printStackTrace();
            }
        } else {
            sb.append("\nUser not logged in.");
        }

        // Set text to area
        historyArea.setText(sb.toString());
        l4.setText("Your total balance is Rs. " + (int)(balance));


        // --- Buttons ---
        button1 = new JButton("Back");
        button1.setBounds(20, 500, 100, 25);
        button1.addActionListener(this);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        add(button1);

        button2 = new JButton("Exit");
        button2.setBounds(260, 500, 100, 25);
        button2.addActionListener(this);
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        add(button2);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            setVisible(false);
            new main_Class(pin).setVisible(true); // Go back to Main Menu
        } else {
            System.exit(0); // Exit App
        }
    }
}