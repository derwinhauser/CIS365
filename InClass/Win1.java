/*
Win1.java
 */

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Win1 extends JFrame {
    //properties
    JButton btnNext, btnExit;
    JLabel lblInfo;
    //constructor
    public Win1(){
        super("This is window 1");
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        init();
    }
    //methods
    private void init(){
        lblInfo = new JLabel("This is the FIRST window");
        lblInfo.setBounds(50,50,200,30);
        add(lblInfo);

        btnNext = new JButton("Next");
        btnNext.setBounds(50,100,80,30);
        add(btnNext);

        btnNext.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Win2 win2 = new Win2();
                dispose();
            }
        });

        btnExit = new JButton("Exit");
        btnExit.setBounds(250,300,80,30);
        add(btnExit);

        btnExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
    }
    //static main
    public static void main(String[] args){
        Win1 win1 = new Win1();
    }

}