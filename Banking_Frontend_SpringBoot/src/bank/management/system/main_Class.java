package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_Class extends JFrame implements ActionListener {

    JButton d,cw,fc,ms,pc,be,b,ex;
    String pin;

     public main_Class(String pin){

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel l1 = new JLabel("Please Select Your Transaction");
        l1.setFont(new Font("System",Font.BOLD,22));
        l1.setBounds(460,180,400,35);
        l1.setForeground(Color.WHITE);
        l3.add(l1);

        //Deposit Button
        d = new JButton("DEPOSIT");
        d.setBackground(new Color(65,125,128));
        d.setBounds(408,272,150,35);
        d.setForeground(Color.WHITE);
        d.addActionListener(this);
        l3.add(d);

        //Cash Withdrawal Button
        cw = new JButton("CASH WITHDRAWAL");
        cw.setBackground(new Color(65,125,128));
        cw.setBounds(700,272,150,35);
        cw.setForeground(Color.WHITE);
        cw.addActionListener(this);
        l3.add(cw);

        //Fast Cash Button
        fc = new JButton("FAST CASH");
        fc.setBackground(new Color(65,125,128));
        fc.setBounds(408,318,150,35);
        fc.setForeground(Color.WHITE);
        fc.addActionListener(this);
        l3.add(fc);

        //Mini Statement Button
        ms = new JButton("MINI STATEMENT");
        ms.setBounds(700,318,150,35);
        ms.setBackground(new Color(65,125,128));
        ms.setForeground(Color.WHITE);
        ms.addActionListener(this);
        l3.add(ms);

        //Pin Change Button
        pc = new JButton("PIN CHANGE");
        pc.setBackground(new Color(65,125,128));
        pc.setBounds(408,364,150,35);
        pc.setForeground(Color.WHITE);
        pc.addActionListener(this);
        l3.add(pc);

        //Balance Enquiry Button
        be = new JButton("BALANCE ENQUIRY");
        be.setBackground(new Color(65,125,128));
        be.setBounds(700,364,150,35);
        be.setForeground(Color.WHITE);
        be.addActionListener(this);
        l3.add(be);

        //Exit Button
        ex = new JButton("EXIT");
        ex.setBounds(700,408,150,35);
        ex.setBackground(new Color(65,125,128));
        ex.setForeground(Color.WHITE);
        ex.addActionListener(this);
        l3.add(ex);


        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == d){
            new Deposit(pin);
            setVisible(false);
        }
        else if (e.getSource() == cw) {
            new Withdrawal(pin);
            setVisible(false);
        }
        else if (e.getSource() == fc) {
            new FastCash(pin);
            setVisible(false);
        }
        else if (e.getSource() == ms) {
            new mini(pin);
            setVisible(false);
        }
        else if (e.getSource() == pc) {
            new Pin(pin);
            setVisible(false);
        }
        else if (e.getSource() == be) {
            new BalanceEnquiry(pin);
            setVisible(false);
        }
        else if (e.getSource() == ex) {
            new Login();
            setVisible(false);
        }
    }
}
