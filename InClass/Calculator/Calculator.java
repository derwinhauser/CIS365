import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame {
    //properties
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    JButton btn_plus, btn_equals;



    JTextField txtInput;

    //constructor
    public Calculator() {
        super("My Calculator");
        setLayout(null);
        init();
        setSize(500, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //methods
    private void init(){
        txtInput = new JTextField();
        txtInput.setBounds(50, 50, 400, 45);
        add(txtInput);

        btn1 = new JButton("1");
        btn1.setBounds(50, 100, 45, 45);
        add(btn1);

        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String temp = temp+btn1.getText();
                if (op.equals("+")){
                    txtInput.setText(temp);
                }
            }
        });

        btn2 = new JButton("2");
        btn2.setBounds(100, 100, 45, 45);
        add(btn2);

        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                txtInput.setText(btn2.getText());
            }
        });

        btn3 = new JButton("3");
        btn3.setBounds(150, 100, 45, 45);
        add(btn3);

        btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                txtInput.setText(btn3.getText());
            }
        });

        btn4 = new JButton("4");
        btn4.setBounds(50, 150, 45, 45);
        add(btn4);

        btn4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                txtInput.setText(btn4.getText());
            }
        });

        btn5 = new JButton("5");
        btn5.setBounds(100, 150, 45, 45);
        add(btn5);

        btn5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                txtInput.setText(btn5.getText());
            }
        });

        btn6 = new JButton("6");
        btn6.setBounds(150, 150, 45, 45);
        add(btn6);

        btn6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                txtInput.setText(btn6.getText());
            }
        });

        btn7 = new JButton("7");
        btn7.setBounds(50, 200, 45, 45);
        add(btn7);

        btn7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                txtInput.setText(btn7.getText());
            }
        });

        btn8 = new JButton("8");
        btn8.setBounds(100, 200, 45, 45);
        add(btn8);

        btn8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                txtInput.setText(btn8.getText());
            }
        });

        btn9 = new JButton("9");
        btn9.setBounds(150, 200, 45, 45);
        add(btn9);

        btn9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                txtInput.setText(btn9.getText());
            }
        });

        btn0 = new JButton("0");
        btn0.setBounds(100, 250, 45, 45);
        add(btn0);

        btn0.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                txtInput.setText(btn0.getText());
            }
        });

        btn_plus = new JButton("+");
        btn_plus.setBounds(200, 100, 45, 45);
        add(btn_plus);

        btn_plus.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                txtInput.setText(btn_plus.getText());
            }
        });

        btn_equals = new JButton("=");
        btn_equals.setBounds(50, 300, 45, 45);
        add(btn_equals);

        btn_equals.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                txtInput.setText(btn_equals.getText());
            }
        });
    }

    //main method
    public static void main(String[] args) {
        new Calculator();
    }
}