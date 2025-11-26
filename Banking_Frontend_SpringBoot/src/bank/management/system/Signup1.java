package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup1 extends JFrame implements ActionListener {

    JRadioButton r1, r2, m1, m2, m3;
    JButton next;
    JTextField textName, textFName, textEmail, textAdd, textCity, textPin, textState;
    JDateChooser dateChooser;

    Random random = new Random();
    int first4 = random.nextInt(9000) + 1000;
    String first = String.valueOf(first4);

    Signup1() {
        super("APPLICATION FORM");

        Font titleFont = new Font("Raleway", Font.BOLD, 34);
        Font subTitleFont = new Font("Raleway", Font.BOLD, 22);
        Font labelFont = new Font("Raleway", Font.BOLD, 20);
        Font fieldFont = new Font("Raleway", Font.BOLD, 15);

        Color bankBlue = new Color(25, 118, 210);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(60,15,100,100);
        add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO: " + first);
        label1.setBounds(220, 20, 600, 45);
        label1.setFont(titleFont);
        label1.setForeground(bankBlue);
        add(label1);

        JLabel label2 = new JLabel("Page 1: Personal Details");
        label2.setBounds(300, 90, 600, 30);
        label2.setFont(subTitleFont);
        label2.setForeground(Color.BLACK);
        add(label2);

        JPanel line = new JPanel();
        line.setBounds(0, 130, 850, 2);
        line.setBackground(Color.BLACK);
        add(line);

        JLabel labelName = new JLabel("Name :");
        labelName.setFont(labelFont);
        labelName.setBounds(100, 190, 100, 30);
        add(labelName);

        textName = new JTextField();
        textName.setFont(fieldFont);
        textName.setBounds(300, 190, 400, 30);
        add(textName);

        JLabel labelFName = new JLabel("Father's Name :");
        labelFName.setFont(labelFont);
        labelFName.setBounds(100, 240, 200, 30);
        add(labelFName);

        textFName = new JTextField();
        textFName.setFont(fieldFont);
        textFName.setBounds(300, 240, 400, 30);
        add(textFName);

        JLabel DOB = new JLabel("Date of Birth :");
        DOB.setFont(labelFont);
        DOB.setBounds(100, 340, 200, 30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 340, 400, 30);
        add(dateChooser);

        JLabel labelG = new JLabel("Gender :");
        labelG.setFont(labelFont);
        labelG.setBounds(100, 290, 200, 30);
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setFont(fieldFont);
        r1.setBackground(Color.WHITE);
        r1.setBounds(300, 290, 60, 30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(fieldFont);
        r2.setBackground(Color.WHITE);
        r2.setBounds(450, 290, 90, 30);
        add(r2);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(r1);
        buttonGroup1.add(r2);

        JLabel labelEmail = new JLabel("Email Address :");
        labelEmail.setBounds(100, 390, 200, 30);
        labelEmail.setFont(labelFont);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setBounds(300, 390, 400, 30);
        textEmail.setFont(fieldFont);
        add(textEmail);

        JLabel labelMs = new JLabel("Marital Status :");
        labelMs.setBounds(100, 440, 200, 30);
        labelMs.setFont(labelFont);
        add(labelMs);

        m1 = new JRadioButton("Married");
        m1.setFont(fieldFont);
        m1.setBounds(300, 440, 100, 30);
        m1.setBackground(Color.WHITE);
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setFont(fieldFont);
        m2.setBounds(450, 440, 150, 30);
        m2.setBackground(Color.WHITE);
        add(m2);

        m3 = new JRadioButton("Other");
        m3.setFont(fieldFont);
        m3.setBounds(600, 440, 100, 30);
        m3.setBackground(Color.WHITE);
        add(m3);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(m1);
        buttonGroup2.add(m2);
        buttonGroup2.add(m3);

        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setBounds(100, 490, 200, 30);
        labelAdd.setFont(labelFont);
        add(labelAdd);

        textAdd = new JTextField();
        textAdd.setBounds(300, 490, 400, 30);
        textAdd.setFont(fieldFont);
        add(textAdd);

        JLabel labelCity = new JLabel("City :");
        labelCity.setBounds(100, 540, 200, 30);
        labelCity.setFont(labelFont);
        add(labelCity);

        textCity = new JTextField();
        textCity.setBounds(300, 540, 400, 30);
        textCity.setFont(fieldFont);
        add(textCity);

        JLabel labelPin = new JLabel("Pin Code :");
        labelPin.setBounds(100, 590, 200, 30);
        labelPin.setFont(labelFont);
        add(labelPin);

        textPin = new JTextField();
        textPin.setBounds(300, 590, 400, 30);
        textPin.setFont(fieldFont);
        add(textPin);

        JLabel labelState = new JLabel("State :");
        labelState.setBounds(100, 640, 200, 30);
        labelState.setFont(labelFont);
        add(labelState);

        textState = new JTextField();
        textState.setBounds(300, 640, 400, 30);
        textState.setFont(fieldFont);
        add(textState);

        next = new JButton("Next");
        next.setFont(fieldFont);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620, 710, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(850, 800);
        setLocation(345, 30);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = first;
        String name = textName.getText();
        String fname = textFName.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if (r1.isSelected()) gender = "Male";
        else if (r2.isSelected()) gender = "Female";

        String email = textEmail.getText();

        String marital = null;
        if (m1.isSelected()) marital = "Married";
        else if (m2.isSelected()) marital = "Unmarried";
        else if (m3.isSelected()) marital = "Other";

        String address = textAdd.getText();
        String city = textCity.getText();
        String pincode = textPin.getText();
        String state = textState.getText();

        try {
            if (name.isEmpty() || fname.isEmpty() || dob.isEmpty() || email.isEmpty() ||
                    address.isEmpty() || city.isEmpty() || pincode.isEmpty() || state.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill out all required fields");
            } else if (gender == null) {
                JOptionPane.showMessageDialog(null, "Please select a gender");
            } else if (marital == null) {
                JOptionPane.showMessageDialog(null, "Please select marital status");
            } else {
                // --- API CALL ---
                if (BankAPI.signup1(formno, name, fname, dob, gender, email, marital, address, city, pincode, state)) {
                    // Success
                    setVisible(false);
                    new Signup2(first).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error connecting to server! Check Backend.");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}