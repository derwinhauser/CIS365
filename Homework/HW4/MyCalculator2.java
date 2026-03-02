import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyCalculator2 extends JFrame {

    // Properties
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    JButton btn_plus, btn_minus, btn_multiply, btn_divide;
    JButton btn_equals, btn_clear;
    JTextField txtInput;

    double firstNumber = 0;
    String operator = "";
    boolean operatorClicked = false;

    // Constructor
    public MyCalculator2() {
        super("My Calculator");
        setLayout(null);
        init();
        setSize(300, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Methods
    private void init() {

        // Display
        txtInput = new JTextField();
        txtInput.setBounds(20, 20, 240, 45);
        txtInput.setEditable(false);
        add(txtInput);

        // Row 1: 7, 8, 9, /
        btn7 = new JButton("7");
        btn7.setBounds(20, 75, 55, 45);
        add(btn7);
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (operatorClicked) {
                    txtInput.setText(txtInput.getText() + " 7");
                    operatorClicked = false;
                } else {
                    txtInput.setText(txtInput.getText() + "7");
                }
            }
        });

        btn8 = new JButton("8");
        btn8.setBounds(80, 75, 55, 45);
        add(btn8);
        btn8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (operatorClicked) {
                    txtInput.setText(txtInput.getText() + " 8");
                    operatorClicked = false;
                } else {
                    txtInput.setText(txtInput.getText() + "8");
                }
            }
        });

        btn9 = new JButton("9");
        btn9.setBounds(140, 75, 55, 45);
        add(btn9);
        btn9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (operatorClicked) {
                    txtInput.setText(txtInput.getText() + " 9");
                    operatorClicked = false;
                } else {
                    txtInput.setText(txtInput.getText() + "9");
                }
            }
        });

        btn_divide = new JButton("/");
        btn_divide.setBounds(200, 75, 55, 45);
        add(btn_divide);
        btn_divide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(txtInput.getText().trim());
                operator = "/";
                txtInput.setText(txtInput.getText() + " /");
                operatorClicked = true;
            }
        });

        // Row 2: 4, 5, 6, *
        btn4 = new JButton("4");
        btn4.setBounds(20, 130, 55, 45);
        add(btn4);
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (operatorClicked) {
                    txtInput.setText(txtInput.getText() + " 4");
                    operatorClicked = false;
                } else {
                    txtInput.setText(txtInput.getText() + "4");
                }
            }
        });

        btn5 = new JButton("5");
        btn5.setBounds(80, 130, 55, 45);
        add(btn5);
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (operatorClicked) {
                    txtInput.setText(txtInput.getText() + " 5");
                    operatorClicked = false;
                } else {
                    txtInput.setText(txtInput.getText() + "5");
                }
            }
        });

        btn6 = new JButton("6");
        btn6.setBounds(140, 130, 55, 45);
        add(btn6);
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (operatorClicked) {
                    txtInput.setText(txtInput.getText() + " 6");
                    operatorClicked = false;
                } else {
                    txtInput.setText(txtInput.getText() + "6");
                }
            }
        });

        btn_multiply = new JButton("*");
        btn_multiply.setBounds(200, 130, 55, 45);
        add(btn_multiply);
        btn_multiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(txtInput.getText().trim());
                operator = "*";
                txtInput.setText(txtInput.getText() + " *");
                operatorClicked = true;
            }
        });

        // Row 3: 1, 2, 3, -
        btn1 = new JButton("1");
        btn1.setBounds(20, 185, 55, 45);
        add(btn1);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (operatorClicked) {
                    txtInput.setText(txtInput.getText() + " 1");
                    operatorClicked = false;
                } else {
                    txtInput.setText(txtInput.getText() + "1");
                }
            }
        });

        btn2 = new JButton("2");
        btn2.setBounds(80, 185, 55, 45);
        add(btn2);
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (operatorClicked) {
                    txtInput.setText(txtInput.getText() + " 2");
                    operatorClicked = false;
                } else {
                    txtInput.setText(txtInput.getText() + "2");
                }
            }
        });

        btn3 = new JButton("3");
        btn3.setBounds(140, 185, 55, 45);
        add(btn3);
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (operatorClicked) {
                    txtInput.setText(txtInput.getText() + " 3");
                    operatorClicked = false;
                } else {
                    txtInput.setText(txtInput.getText() + "3");
                }
            }
        });

        btn_minus = new JButton("-");
        btn_minus.setBounds(200, 185, 55, 45);
        add(btn_minus);
        btn_minus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(txtInput.getText().trim());
                operator = "-";
                txtInput.setText(txtInput.getText() + " -");
                operatorClicked = true;
            }
        });

        // Row 4: C, 0, =, +
        btn_clear = new JButton("C");
        btn_clear.setBounds(20, 240, 55, 45);
        add(btn_clear);
        btn_clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtInput.setText("");
                firstNumber = 0;
                operator = "";
                operatorClicked = false;
            }
        });

        btn0 = new JButton("0");
        btn0.setBounds(80, 240, 55, 45);
        add(btn0);
        btn0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (operatorClicked) {
                    txtInput.setText(txtInput.getText() + " 0");
                    operatorClicked = false;
                } else {
                    txtInput.setText(txtInput.getText() + "0");
                }
            }
        });

        btn_equals = new JButton("=");
        btn_equals.setBounds(140, 240, 55, 45);
        add(btn_equals);
        btn_equals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Extract the second number from the right side of the display
                String[] parts = txtInput.getText().trim().split(" ");
                double secondNumber = Double.parseDouble(parts[parts.length - 1]);
                double result = 0;

                if (operator.equals("+")) {
                    result = firstNumber + secondNumber;
                } else if (operator.equals("-")) {
                    result = firstNumber - secondNumber;
                } else if (operator.equals("*")) {
                    result = firstNumber * secondNumber;
                } else if (operator.equals("/")) {
                    if (secondNumber == 0) {
                        txtInput.setText("Error");
                        return;
                    }
                    result = firstNumber / secondNumber;
                }

                // Show whole number if no decimal needed
                if (result == (long) result) {
                    txtInput.setText(String.valueOf((long) result));
                } else {
                    txtInput.setText(String.valueOf(result));
                }

                operator = "";
                operatorClicked = false;
            }
        });

        btn_plus = new JButton("+");
        btn_plus.setBounds(200, 240, 55, 45);
        add(btn_plus);
        btn_plus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(txtInput.getText().trim());
                operator = "+";
                txtInput.setText(txtInput.getText() + " +");
                operatorClicked = true;
            }
        });
    }

    // Main method
    public static void main(String[] args) {
        new MyCalculator2();
    }
}