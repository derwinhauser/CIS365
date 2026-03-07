import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame {

    private String[] board = new String[9];
    private JButton[] cells = new JButton[9];
    private JLabel statusLabel;
    private boolean playerTurn = true; // true = human (X), false = computer (O)
    private boolean gameOver = false;

    public TicTacToe() {
        setTitle("Tic-Tac-Toe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Status label at the top
        statusLabel = new JLabel("Your turn (X)", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(statusLabel, BorderLayout.NORTH);

        // 3x3 grid of buttons
        JPanel grid = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            final int idx = i;
            cells[i] = new JButton("");
            cells[i].setFont(new Font("Arial", Font.BOLD, 40));
            cells[i].addActionListener(e -> onCellClick(idx));
            grid.add(cells[i]);
        }
        add(grid, BorderLayout.CENTER);

        // Reset button at the bottom
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> resetGame());
        add(resetButton, BorderLayout.SOUTH);

        resetGame();
        setSize(400, 450);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void onCellClick(int idx) {
        if (gameOver || !playerTurn || !board[idx].isEmpty()) return;

        place(idx, "X");

        if (checkWin("X")) {
            statusLabel.setText("You win!");
            gameOver = true;
            return;
        }
        if (isDraw()) {
            statusLabel.setText("It's a draw!");
            gameOver = true;
            return;
        }

        playerTurn = false;
        statusLabel.setText("Computer's turn (O)");
        computerMove();
    }

    private void computerMove() {
        int best = bestMove();
        place(best, "O");

        if (checkWin("O")) {
            statusLabel.setText("Computer wins!");
            gameOver = true;
            return;
        }
        if (isDraw()) {
            statusLabel.setText("It's a draw!");
            gameOver = true;
            return;
        }

        playerTurn = true;
        statusLabel.setText("Your turn (X)");
    }

    private void place(int idx, String symbol) {
        board[idx] = symbol;
        cells[idx].setText(symbol);
        cells[idx].setEnabled(false);
    }

    // Minimax to find the best move for the computer
    private int bestMove() {
        int bestScore = Integer.MIN_VALUE;
        int bestIdx = -1;
        for (int i = 0; i < 9; i++) {
            if (board[i].isEmpty()) {
                board[i] = "O";
                int score = minimax(0, false);
                board[i] = "";
                if (score > bestScore) {
                    bestScore = score;
                    bestIdx = i;
                }
            }
        }
        return bestIdx;
    }

    private int minimax(int depth, boolean isMaximizing) {
        if (checkWin("O")) return 10 - depth;
        if (checkWin("X")) return depth - 10;
        if (isDraw()) return 0;

        int best = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for (int i = 0; i < 9; i++) {
            if (board[i].isEmpty()) {
                board[i] = isMaximizing ? "O" : "X";
                int score = minimax(depth + 1, !isMaximizing);
                board[i] = "";
                best = isMaximizing ? Math.max(best, score) : Math.min(best, score);
            }
        }
        return best;
    }

    private static final int[][] WINS = {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
        {0, 4, 8}, {2, 4, 6}              // diagonals
    };

    private boolean checkWin(String symbol) {
        for (int[] w : WINS) {
            if (board[w[0]].equals(symbol) && board[w[1]].equals(symbol) && board[w[2]].equals(symbol))
                return true;
        }
        return false;
    }

    private boolean isDraw() {
        for (String s : board) {
            if (s.isEmpty()) return false;
        }
        return true;
    }

    private void resetGame() {
        for (int i = 0; i < 9; i++) {
            board[i] = "";
            cells[i].setText("");
            cells[i].setEnabled(true);
        }
        playerTurn = true;
        gameOver = false;
        statusLabel.setText("Your turn (X)");
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}