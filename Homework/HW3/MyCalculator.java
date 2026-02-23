import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.net.URL;

public class MyCalculator extends JFrame {

    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel resultLabel;

    public MyCalculator() {
        setTitle("MyCalculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 520);
        setLocationRelativeTo(null);
        setResizable(false);

        // ── Main panel ──────────────────────────────────────────────────
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(245, 247, 250));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        // ── Calculator image (loaded from the web via URL) ───────────────
        JLabel imageLabel = new JLabel();
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        try {
            URL imgUrl = new URL("https://cdn-icons-png.flaticon.com/128/900/900618.png");
            ImageIcon icon = new ImageIcon(imgUrl);
            Image scaled = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaled));
        } catch (Exception e) {
            // Fallback: draw a simple calculator icon using a label
            imageLabel.setText("🧮");
            imageLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 60));
        }

        // ── Title label ──────────────────────────────────────────────────
        JLabel titleLabel = new JLabel("My Calculator");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(44, 62, 80));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitleLabel = new JLabel("Addition Calculator");
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitleLabel.setForeground(new Color(127, 140, 141));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // ── Card panel (white rounded box) ───────────────────────────────
        JPanel card = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 20, 20));
                g2.dispose();
            }
        };
        card.setOpaque(false);
        card.setLayout(new GridBagLayout());
        card.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        card.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.setMaximumSize(new Dimension(340, 220));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Segoe UI", Font.BOLD, 14);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);

        // First Number
        JLabel lbl1 = new JLabel("First Number:");
        lbl1.setFont(labelFont);
        lbl1.setForeground(new Color(52, 73, 94));
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.4;
        card.add(lbl1, gbc);

        num1Field = createTextField(fieldFont);
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 0.6;
        card.add(num1Field, gbc);

        // Second Number
        JLabel lbl2 = new JLabel("Second Number:");
        lbl2.setFont(labelFont);
        lbl2.setForeground(new Color(52, 73, 94));
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.4;
        card.add(lbl2, gbc);

        num2Field = createTextField(fieldFont);
        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 0.6;
        card.add(num2Field, gbc);

        // Operator label (static "+")
        JLabel opLabel = new JLabel("Operation:  Addition  ( + )", SwingConstants.LEFT);
        opLabel.setFont(new Font("Segoe UI", Font.ITALIC, 13));
        opLabel.setForeground(new Color(41, 128, 185));
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        card.add(opLabel, gbc);

        // ── Result label ─────────────────────────────────────────────────
        resultLabel = new JLabel(" ", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        resultLabel.setForeground(new Color(39, 174, 96));
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultLabel.setBorder(BorderFactory.createEmptyBorder(6, 0, 6, 0));

        // ── Buttons ──────────────────────────────────────────────────────
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        btnPanel.setOpaque(false);
        btnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton calcBtn = createButton("Calculate", new Color(41, 128, 185), Color.WHITE);
        JButton exitBtn = createButton("Exit", new Color(231, 76, 60), Color.WHITE);

        calcBtn.addActionListener(e -> calculate());
        exitBtn.addActionListener(e -> System.exit(0));

        // Allow Enter key to trigger Calculate
        getRootPane().setDefaultButton(calcBtn);

        btnPanel.add(calcBtn);
        btnPanel.add(exitBtn);

        // ── Assemble ─────────────────────────────────────────────────────
        mainPanel.add(imageLabel);
        mainPanel.add(Box.createVerticalStrut(8));
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(2));
        mainPanel.add(subtitleLabel);
        mainPanel.add(Box.createVerticalStrut(18));
        mainPanel.add(card);
        mainPanel.add(Box.createVerticalStrut(12));
        mainPanel.add(resultLabel);
        mainPanel.add(Box.createVerticalStrut(12));
        mainPanel.add(btnPanel);

        add(mainPanel);
        setVisible(true);
    }

    // ── Helpers ──────────────────────────────────────────────────────────

    private JTextField createTextField(Font font) {
        JTextField tf = new JTextField(10);
        tf.setFont(font);
        tf.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(189, 195, 199), 1, true),
                BorderFactory.createEmptyBorder(4, 8, 4, 8)));
        return tf;
    }

    private JButton createButton(String text, Color bg, Color fg) {
        JButton btn = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getModel().isPressed()
                        ? bg.darker()
                        : getModel().isRollover() ? bg.brighter() : bg);
                g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 12, 12));
                g2.dispose();
                super.paintComponent(g);
            }
        };
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setForeground(fg);
        btn.setBackground(bg);
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setPreferredSize(new Dimension(120, 38));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private void calculate() {
        String t1 = num1Field.getText().trim();
        String t2 = num2Field.getText().trim();

        if (t1.isEmpty() || t2.isEmpty()) {
            resultLabel.setForeground(new Color(192, 57, 43));
            resultLabel.setText("⚠  Please enter both numbers.");
            return;
        }

        try {
            double n1 = Double.parseDouble(t1);
            double n2 = Double.parseDouble(t2);
            double sum = n1 + n2;

            // Format: show as integer when possible
            String fmt = (sum == Math.floor(sum) && !Double.isInfinite(sum))
                    ? "%.0f" : "%.4g";
            String n1Str = (n1 == Math.floor(n1)) ? String.format("%.0f", n1) : String.valueOf(n1);
            String n2Str = (n2 == Math.floor(n2)) ? String.format("%.0f", n2) : String.valueOf(n2);
            String sumStr = String.format(fmt, sum);

            resultLabel.setForeground(new Color(39, 174, 96));
            resultLabel.setText(n1Str + " + " + n2Str + " = " + sumStr);

        } catch (NumberFormatException ex) {
            resultLabel.setForeground(new Color(192, 57, 43));
            resultLabel.setText("⚠  Invalid input. Enter numbers only.");
        }
    }

    public static void main(String[] args) {
        // Use system look-and-feel for native rendering
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(MyCalculator::new);
    }
}