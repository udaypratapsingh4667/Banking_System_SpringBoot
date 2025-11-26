package bank.management.system;

import javax.swing.*; // containers and components - JFrame , JLabel
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; // for performing action on clicking the button
import java.util.Arrays;

public class Login extends JFrame implements ActionListener { // JFrame for the title bar
    JLabel label1,label2,label3; //JLabel main work is to show the text one the screen
    JTextField textField2; // for writing text
    JPasswordField passwordField3; // for writing password
    JButton button1,button2,button3;

    Login(){
        super("Bank Management System");// Always on top

        //bank image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));// this is so that the program don't crash on others pc because of path
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT); // giving the size or scaling the dimensions basically
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); // because the image can't directly get to frames so we use JLabel
        image.setBounds(355,10,100,100); // where the image should be visible
        add(image); // it is adding JLabel into the JFrame

        //card image
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));// this is so that the program don't crash on others pc because of path
        Image ii2 = ii1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT); // giving the size or scaling the dimensions basically
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3); // because the image can't directly get to frames so we use JLabel
        iimage.setBounds(635,365,100,100); // where the image should be visible
        add(iimage); // it is adding JLabel into the JFrame

        // for welcome
        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.WHITE); // it is to set the text colour
        label1.setFont(new Font("AvantGarde",Font.BOLD,38)); // to change the style and also font style
        label1.setBounds(235,125,450,40); //setting the dimensions of label1
        add(label1); // adding the label to JFrame so that it can be visible

        // for card number
        label2 = new JLabel("Card No:");
        label2.setFont(new Font("Railway",Font.BOLD,28)); // to change the style and also font style
        label2.setForeground(Color.WHITE); // it is to set the text colour
        label2.setBounds(155,203,375,30); //setting the dimensions of label2
        add(label2);

        textField2 = new JTextField(15); // no need for this 15 as we are using setLayout as null
        textField2.setBounds(305,203,230,30);
        textField2.setFont(new Font("Arial",Font.BOLD,14));
        add(textField2);

        // for pin
        label3 = new JLabel("PIN:");
        label3.setFont(new Font("Railway",Font.BOLD,28));
        label3.setForeground(Color.WHITE);
        label3.setBounds(155,245,375,90);
        add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(305,270,230,30);
        passwordField3.setFont(new Font("Arial",Font.BOLD,14));
        add(passwordField3);

        // for buttons
        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial",Font.BOLD,14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(305,322,100,30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial",Font.BOLD,14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(435,322,100,30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial",Font.BOLD,14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(305,370,230,30);
        button3.addActionListener(this);
        add(button3);

        //background image
        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));// this is so that the program don't crash on others pc because of path
        Image iii2 = iii1.getImage().getScaledInstance(900,500, Image.SCALE_DEFAULT); // giving the size or scaling the dimensions basically
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3); // because the image can't directly get to frames so we use JLabel
        iiimage.setBounds(0,0,900,500); // where the image should be visible
        add(iiimage); // it is adding JLabel into the JFrame

        setLayout(null); // default border but we want our customization
        setSize(900,500); // setting size for the title bar, but it is not visible so we have to also setVisible
        setLocation(330,200); // this is for shifting the frame from leftmost to center when it is opening
        setVisible(true ); // always write at last
    }


    public static void main(String[] args) {
        new Login();
    }

    // Event Handling
    @Override
    public void actionPerformed(ActionEvent e) { // to override action listener
        try{
            if(e.getSource() == button1){

                // 1. Data Nikalo
                String cardnumber = textField2.getText();
                String pin = new String(passwordField3.getPassword());

                // 2. Validation
                if (cardnumber.isEmpty() || pin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter Card Number and Pin");
                    return;
                }

                // 3. API Call & Check (Simple boolean check)
                if (BankAPI.login(cardnumber, pin)) {
                    // Agar True aaya (Login Pass)
                    new main_Class(pin);
                    setVisible(false);
                } else {
                    // Agar False aaya (Login Fail)
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }

            }
            else if(e.getSource() == button2){
                textField2.setText("");
                passwordField3.setText("");
            }
            else if(e.getSource() == button3){
                new Signup1();
                setVisible(false);
            }

        } catch (Exception e1) {
            e1.printStackTrace(); // it shows the name of error
        }
    }
}
