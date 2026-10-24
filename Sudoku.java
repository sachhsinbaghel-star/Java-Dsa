import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Sudoku extends JFrame {
    private static final int SIZE = 9;
    private JTextField[][] cells = new JTextField[SIZE][SIZE];
    private int[][] puzzle = new int[SIZE][SIZE];
    private int[][] solution = new int[SIZE][SIZE];

    public Sudoku() {
        setTitle("Sudoku Game");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new FlowLayout());
        JButton newGameBtn = new JButton("New Game");
        JButton solveBtn = new JButton("Solve");
        JButton clearBtn = new JButton("Clear");
        topPanel.add(newGameBtn);
        topPanel.add(solveBtn);
        topPanel.add(clearBtn);

        JPanel gridPanel = new JPanel(new GridLayout(SIZE, SIZE, 1, 1));
        gridPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                cells[r][c] = new JTextField();
                cells[r][c].setHorizontalAlignment(JTextField.CENTER);
                cells[r][c].setFont(new Font("Arial", Font.BOLD, 18));
                cells[r][c].setDocument(new NumberDocument());
                cells[r][c].addFocusListener(new FocusAdapter() {
                    public void focusGained(FocusEvent e) {
                        final JTextField tf = (JTextField) e.getSource();
                        SwingUtilities.invokeLater(tf::selectAll);
                    }
                });
                gridPanel.add(cells[r][c]);
            }
        }

        JPanel bottomPanel = new JPanel(new FlowLayout());
        JLabel statusLabel = new JLabel("Fill in the empty cells with numbers 1-9");
        bottomPanel.add(statusLabel);

        add(topPanel, BorderLayout.NORTH);
        add(gridPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        newGameBtn.addActionListener(e -> newGame());
        solveBtn.addActionListener(e -> solve());
        clearBtn.addActionListener(e -> clear());

        newGame();
    }

    private void newGame() {
        generatePuzzle();
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (puzzle[r][c] != 0) {
                    cells[r][c].setText(String.valueOf(puzzle[r][c]));
                    cells[r][c].setEditable(false);
                    cells[r][c].setBackground(Color.LIGHT_GRAY);
                } else {
                    cells[r][c].setText("");
                    cells[r][c].setEditable(true);
                    cells[r][c].setBackground(Color.WHITE);
                }
            }
        }
    }

    private void generatePuzzle() {
        solution = new int[SIZE][SIZE];
        fillDiagonal();
        solveSudoku(solution);
        puzzle = new int[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++) {
            System.arraycopy(solution[r], 0, puzzle[r], 0, SIZE);
        }
        removeKDigits(40);
    }

    private void fillDiagonal() {
        for (int i = 0; i < SIZE; i += 3) {
            fillBox(i, i);
        }
    }

    private void fillBox(int row, int col) {
        Random rand = new Random();
        int num;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                do {
                    num = rand.nextInt(9) + 1;
                } while (!isSafeInBox(solution, row, col, num));
                solution[row + i][col + j] = num;
            }
        }
    }

    private boolean isSafeInBox(int[][] grid, int row, int col, int num) {
        int boxRowStart = row - row % 3;
        int boxColStart = col - col % 3;
        for (int r = boxRowStart; r < boxRowStart + 3; r++) {
            for (int c = boxColStart; c < boxColStart + 3; c++) {
                if (grid[r][c] == num) return false;
            }
        }
        return true;
    }

    private boolean solveSudoku(int[][] grid) {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (grid[r][c] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isSafe(grid, r, c, num)) {
                            grid[r][c] = num;
                            if (solveSudoku(grid)) return true;
                            grid[r][c] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSafe(int[][] grid, int row, int col, int num) {
        for (int c = 0; c < SIZE; c++) if (grid[row][c] == num) return false;
        for (int r = 0; r < SIZE; r++) if (grid[r][col] == num) return false;
        int boxRowStart = row - row % 3;
        int boxColStart = col - col % 3;
        for (int r = boxRowStart; r < boxRowStart + 3; r++)
            for (int c = boxColStart; c < boxColStart + 3; c++)
                if (grid[r][c] == num) return false;
        return true;
    }

    private void removeKDigits(int k) {
        Random rand = new Random();
        int count = k;
        while (count != 0) {
            int cellId = rand.nextInt(SIZE * SIZE);
            int r = cellId / SIZE;
            int c = cellId % SIZE;
            if (puzzle[r][c] != 0) {
                puzzle[r][c] = 0;
                count--;
            }
        }
    }

    private void solve() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (solution[r][c] != 0) {
                    cells[r][c].setText(String.valueOf(solution[r][c]));
                }
            }
        }
    }

    private void clear() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (cells[r][c].isEditable()) {
                    cells[r][c].setText("");
                }
            }
        }
    }

    class NumberDocument extends javax.swing.text.PlainDocument {
        public void insertString(int offs, String str, javax.swing.text.AttributeSet a)
                throws javax.swing.text.BadLocationException {
            if (str == null) return;
            try {
                int val = Integer.parseInt(str);
                if (val < 1 || val > 9) return;
            } catch (NumberFormatException e) {
                return;
            }
            super.insertString(offs, str, a);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Sudoku().setVisible(true));
    }
}