/*
Win2.java
 */

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Win2 extends JFrame {
    //properties
    JButton btnPrevious;
    JLabel lblInfo;
    //constructor
    public Win2(){
        super("This is window 2");
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        init();
    }
    //methods
    private void init(){
        lblInfo = new JLabel("This is the SECOND window");
        lblInfo.setBounds(50,50,200,30);
        add(lblInfo);

        btnPrevious = new JButton("Prev");
        btnPrevious.setBounds(150,300,80,30);
        add(btnPrevious);

        btnPrevious.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Win1 win1 = new Win1();
                dispose();
            }
        });
    }
    //static main
    public static void main(String[] args){
        Win2 win2 = new Win2();
    }

}