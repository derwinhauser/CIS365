import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyCalculator2 extends JFrame {

    JLabel lblInfo, lblResult;
    JTextField num1Field, num2Field;
    JButton calcBtn, exitBtn, moveBtn;

    public MyCalculator2() {
        super("MyCalculator2");
        setLayout(null);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        init();
        setVisible(true);
    }

    private void init() {
        lblInfo = new JLabel("Derwin Hauser");
        lblInfo.setBounds(180, 20, 200, 30);
        lblInfo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        add(lblInfo);

        JLabel lbl1 = new JLabel("First Number:");
        lbl1.setBounds(80, 80, 120, 30);
        add(lbl1);

        num1Field = new JTextField();
        num1Field.setBounds(210, 80, 150, 30);
        add(num1Field);

        JLabel lbl2 = new JLabel("Second Number:");
        lbl2.setBounds(80, 130, 120, 30);
        add(lbl2);

        num2Field = new JTextField();
        num2Field.setBounds(210, 130, 150, 30);
        add(num2Field);

        JLabel opLabel = new JLabel("Operation:  Addition  ( + )");
        opLabel.setBounds(80, 175, 250, 30);
        opLabel.setForeground(new Color(41, 128, 185));
        add(opLabel);

        lblResult = new JLabel(" ", SwingConstants.CENTER);
        lblResult.setBounds(80, 215, 330, 30);
        lblResult.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblResult.setForeground(new Color(39, 174, 96));
        add(lblResult);

        calcBtn = new JButton("Calculate");
        calcBtn.setBounds(110, 270, 110, 38);
        add(calcBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(260, 270, 110, 38);
        add(exitBtn);

        moveBtn = new JButton("Move");
        moveBtn.setBounds(185, 320, 110, 38);
        add(moveBtn);

        calcBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });

        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        moveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int x = lblInfo.getX();
                int newX = x + 20;
                if (newX + lblInfo.getWidth() > 480) newX = 0;
                lblInfo.setLocation(newX, lblInfo.getY());
            }
        });

        getRootPane().setDefaultButton(calcBtn);
    }

    private void calculate() {
        String t1 = num1Field.getText().trim();
        String t2 = num2Field.getText().trim();

        if (t1.isEmpty() || t2.isEmpty()) {
            lblResult.setForeground(new Color(192, 57, 43));
            lblResult.setText("Please enter both numbers.");
            return;
        }

        try {
            double n1 = Double.parseDouble(t1);
            double n2 = Double.parseDouble(t2);
            double sum = n1 + n2;

            String fmt = (sum == Math.floor(sum) && !Double.isInfinite(sum)) ? "%.0f" : "%.4g";
            lblResult.setForeground(new Color(39, 174, 96));
            lblResult.setText(t1 + " + " + t2 + " = " + String.format(fmt, sum));

        } catch (NumberFormatException ex) {
            lblResult.setForeground(new Color(192, 57, 43));
            lblResult.setText("Invalid input. Enter numbers only.");
        }
    }

    public static void main(String[] args) {
        new MyCalculator2();
    }
}
