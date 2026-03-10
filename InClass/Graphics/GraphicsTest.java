/*
GraphicsTest.java
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;

import java.util.ArrayList;

public class GraphicsTest extends JFrame{
    //
    MyPanel my_panel;

    //
    public GraphicsTest(){
        super("My Graphics Demo");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        init();
    }

    private void init(){
        my_panel = new MyPanel();
        my_panel.setBackground(new Color(255,255,255));
        my_panel.setBounds(0,0,300,280);
        add(my_panel);
    }

    //define class MyPanel
    public class MyPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);

            g.setColor(Color.BLUE);
            g.drawString("Graphics Drawing", 90, 15);
            g.setColor(Color.RED);
            g.drawLine(20, 30, 260, 30);
            g.setColor(Color.GREEN);
            g.fillOval(100,100,50,50);
        }
    }

    //main method
    public static void main(String[] args){
        GraphicsTest test = new GraphicsTest();
    }


}