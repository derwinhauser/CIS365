import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DigitalClock.java
 * A sleek, dark-themed digital clock GUI application.
 * Displays current time with Start/Stop control and 12/24-hour format toggle.
 */
public class DigitalClock extends JFrame {

    // ── State ────────────────────────────────────────────────────────────────
    private boolean is24Hour   = true;
    private boolean isRunning  = true;

    // ── Swing components ─────────────────────────────────────────────────────
    private final ClockPanel  clockPanel;
    private final JButton     startStopBtn;
    private final JButton     formatBtn;
    private final javax.swing.Timer timer;

    // ── Palette ──────────────────────────────────────────────────────────────
    private static final Color BG_OUTER    = new Color(10,  10,  15);
    private static final Color BG_CARD     = new Color(18,  18,  28);
    private static final Color ACCENT      = new Color(0,   210, 180);
    private static final Color ACCENT_DIM  = new Color(0,   120, 105);
    private static final Color TEXT_MAIN   = new Color(230, 240, 255);
    private static final Color TEXT_SUB    = new Color(100, 115, 140);
    private static final Color BTN_BG      = new Color(28,  30,  45);
    private static final Color BTN_HOVER   = new Color(38,  42,  62);
    private static final Color STOP_COLOR  = new Color(255, 80,  100);
    private static final Color STOP_DIM    = new Color(180, 40,  60);

    // ─────────────────────────────────────────────────────────────────────────
    public DigitalClock() {
        super("Digital Clock");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setBackground(BG_OUTER);

        // Root panel with outer background
        JPanel root = new JPanel(new GridBagLayout());
        root.setBackground(BG_OUTER);
        root.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // ── Card panel ───────────────────────────────────────────────────────
        JPanel card = new JPanel(new BorderLayout(0, 0)) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON);
                // Card background
                g2.setColor(BG_CARD);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 28, 28);
                // Subtle top border glow
                g2.setColor(new Color(0, 210, 180, 40));
                g2.setStroke(new BasicStroke(1.5f));
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 28, 28);
                g2.dispose();
            }
        };
        card.setOpaque(false);
        card.setBorder(BorderFactory.createEmptyBorder(34, 44, 30, 44));

        // ── Header label ─────────────────────────────────────────────────────
        JLabel header = new JLabel("DIGITAL CLOCK", SwingConstants.CENTER);
        header.setForeground(TEXT_SUB);
        header.setFont(new Font("Monospaced", Font.PLAIN, 11));
        header.setBorder(BorderFactory.createEmptyBorder(0, 0, 18, 0));
        card.add(header, BorderLayout.NORTH);

        // ── Clock display ────────────────────────────────────────────────────
        clockPanel = new ClockPanel();
        card.add(clockPanel, BorderLayout.CENTER);

        // ── Button row ───────────────────────────────────────────────────────
        JPanel btnRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 14, 0));
        btnRow.setOpaque(false);
        btnRow.setBorder(BorderFactory.createEmptyBorder(24, 0, 0, 0));

        startStopBtn = createStyledButton("|| STOP", STOP_COLOR, STOP_DIM);
        formatBtn    = createStyledButton("12-HOUR", ACCENT, ACCENT_DIM);

        startStopBtn.addActionListener(e -> toggleClock());
        formatBtn.addActionListener(e -> toggleFormat());

        btnRow.add(startStopBtn);
        btnRow.add(formatBtn);
        card.add(btnRow, BorderLayout.SOUTH);

        root.add(card);
        setContentPane(root);

        // ── Timer: tick every 1 000 ms ───────────────────────────────────────
        timer = new javax.swing.Timer(1000, e -> clockPanel.repaint());
        timer.start();

        pack();
        setLocationRelativeTo(null);
    }

    // ── Toggle start / stop ───────────────────────────────────────────────────
    private void toggleClock() {
        isRunning = !isRunning;
        if (isRunning) {
            timer.start();
            startStopBtn.setText("|| STOP");
            updateButtonColors(startStopBtn, STOP_COLOR, STOP_DIM);
        } else {
            timer.stop();
            startStopBtn.setText("> START");
            updateButtonColors(startStopBtn, ACCENT, ACCENT_DIM);
        }
        clockPanel.setRunning(isRunning);
    }

    // ── Toggle 12 / 24-hour format ────────────────────────────────────────────
    private void toggleFormat() {
        is24Hour = !is24Hour;
        formatBtn.setText(is24Hour ? "12-HOUR" : "24-HOUR");
        clockPanel.setFormat(is24Hour);
        clockPanel.repaint();
    }

    // ── Helper: build a styled flat button ───────────────────────────────────
    private JButton createStyledButton(String text, Color fg, Color fgHover) {
        JButton btn = new JButton(text) {
            private Color currentFg = fg;

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON);
                Color bg = getModel().isRollover() ? BTN_HOVER : BTN_BG;
                g2.setColor(bg);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 14, 14);
                // Border
                g2.setColor(currentFg);
                g2.setStroke(new BasicStroke(1.2f));
                g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 14, 14);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        btn.setForeground(fg);
        btn.setFont(new Font("Monospaced", Font.BOLD, 12));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setOpaque(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(130, 40));

        // Hover color shift
        btn.addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) {
                btn.setForeground(fgHover); btn.repaint(); }
            @Override public void mouseExited(MouseEvent e)  {
                btn.setForeground(fg);      btn.repaint(); }
        });
        return btn;
    }

    private void updateButtonColors(JButton btn, Color fg, Color fgHover) {
        btn.setForeground(fg);
        btn.repaint();
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Inner class: the actual clock face
    // ─────────────────────────────────────────────────────────────────────────
    private static class ClockPanel extends JPanel {

        private boolean is24Hour = true;
        private boolean running  = true;

        // Frozen time when stopped
        private String frozenTime = null;

        // Blink state for the colon separator when stopped
        private boolean colonVisible = true;
        private int     blinkTick    = 0;

        ClockPanel() {
            setOpaque(false);
            setPreferredSize(new Dimension(380, 120));
        }

        void setFormat(boolean is24Hour) { this.is24Hour = is24Hour; }

        void setRunning(boolean running) {
            this.running = running;
            if (!running) frozenTime = currentTimeString();
            else          frozenTime = null;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            String time = running ? currentTimeString() : frozenTime;

            // Split into segments: HH, MM, SS (and optional AM/PM)
            String[] parts = time.split(":");
            String hh = parts[0];
            String mm = parts[1];
            // SS may have " AM"/" PM" suffix
            String ssFull  = parts[2];
            String ss      = ssFull.length() > 2 ? ssFull.substring(0, 2) : ssFull;
            String ampm    = ssFull.length() > 2 ? ssFull.substring(2).trim() : "";

            // Blinking colons when stopped
            if (!running) {
                blinkTick = (blinkTick + 1) % 2;
                colonVisible = (blinkTick == 0);
            } else {
                colonVisible = true;
            }

            // ── Draw digits ──────────────────────────────────────────────────
            Font digitFont = new Font("Monospaced", Font.BOLD, 72);
            Font colonFont = new Font("Monospaced", Font.BOLD, 60);
            Font ampmFont  = new Font("Monospaced", Font.BOLD, 18);

            g2.setFont(digitFont);
            FontMetrics fm = g2.getFontMetrics();

            int segW   = fm.stringWidth("00");
            int colonW = 18;
            int gap    = 4;
            int totalW = segW * 3 + colonW * 2 + gap * 4;
            int x      = (getWidth() - totalW) / 2;
            int baseY  = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;

            // Glow pass (teal shadow)
            g2.setColor(new Color(0, 210, 180, 35));
            g2.setFont(digitFont.deriveFont(Font.BOLD, 76f));
            FontMetrics fmGlow = g2.getFontMetrics();
            int gx = (getWidth() - (fmGlow.stringWidth("00") * 3 + colonW * 2 + gap * 4)) / 2;
            g2.drawString(hh, gx,                                     baseY + 2);
            g2.drawString(mm, gx + fmGlow.stringWidth("00") + colonW + gap * 2, baseY + 2);
            g2.drawString(ss, gx + (fmGlow.stringWidth("00") + colonW + gap * 2) * 2, baseY + 2);

            // Main digit rendering
            g2.setFont(digitFont);
            g2.setColor(TEXT_MAIN);

            // HH
            g2.drawString(hh, x, baseY);
            x += segW + gap;

            // First colon
            g2.setFont(colonFont);
            g2.setColor(colonVisible ? ACCENT : new Color(ACCENT.getRed(), ACCENT.getGreen(), ACCENT.getBlue(), 60));
            g2.drawString(":", x, baseY - 4);
            x += colonW + gap;

            // MM
            g2.setFont(digitFont);
            g2.setColor(TEXT_MAIN);
            g2.drawString(mm, x, baseY);
            x += segW + gap;

            // Second colon
            g2.setFont(colonFont);
            g2.setColor(colonVisible ? ACCENT : new Color(ACCENT.getRed(), ACCENT.getGreen(), ACCENT.getBlue(), 60));
            g2.drawString(":", x, baseY - 4);
            x += colonW + gap;

            // SS
            g2.setFont(digitFont);
            g2.setColor(new Color(150, 200, 195)); // slightly dimmer for seconds
            g2.drawString(ss, x, baseY);

            // AM / PM label
            if (!ampm.isEmpty()) {
                g2.setFont(ampmFont);
                g2.setColor(ACCENT);
                g2.drawString(ampm, x + segW + 6, baseY - 36);
            }

            // Paused label
            if (!running) {
                g2.setFont(new Font("Monospaced", Font.PLAIN, 11));
                g2.setColor(new Color(255, 80, 100, 160));
                g2.drawString("PAUSED", (getWidth() - g2.getFontMetrics().stringWidth("PAUSED")) / 2,
                              baseY + 26);
            }

            g2.dispose();
        }

        private String currentTimeString() {
            String pattern = is24Hour ? "HH:mm:ss" : "hh:mm:ss a";
            return new SimpleDateFormat(pattern).format(new Date());
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
            new DigitalClock().setVisible(true);
        });
    }
}