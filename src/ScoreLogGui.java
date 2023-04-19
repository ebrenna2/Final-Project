
import javax.swing.*;
import java.awt.*;
import java.util.List;

//reminder to add a button for retrying the game
public class ScoreLogGui extends JFrame {
    private final ScoreLog leaderboard;
    private final JTextField nameField;
    private final JTextArea leaderboardArea;
    private final int score;

    private gameBoard board;


    public ScoreLogGui (ScoreLog leaderboard, int score) {
        this.leaderboard = leaderboard;
        //leaderboard.readEntries();
        this.score = score;
        setTitle("Score Log");
        setSize(new Dimension(400, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        leaderboard.readEntries();
        JPanel mainPanel = new JPanel(new BorderLayout());

        String plurality = "";
        if (this.score == 1)
        {
            plurality = " point!";
        }

        else
        {
            plurality = " points!";
        }

        JOptionPane.showMessageDialog(null, "You scored " + this.score + plurality + " Enter your name (one word, no spaces, no special characters) to add your score to the leaderboard.");
        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        JButton enterButton = new JButton("Enter");
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(enterButton);

        leaderboardArea = new JTextArea();
        leaderboardArea.setEditable(false);
        JScrollPane leaderboardScrollPane = new JScrollPane(leaderboardArea);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton retryButton = new JButton("Retry");
        JButton exitButton = new JButton("Exit");
        buttonPanel.add(retryButton);
        buttonPanel.add(exitButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(leaderboardScrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        updateLeaderboard();

        enterButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(
                        ScoreLogGui.this,
                        "Please enter a name.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            leaderboard.addEntry(name, score);
            updateLeaderboard();
            nameField.setText("");

        });

        retryButton.addActionListener(e -> {
            boolean lose = false;
            board.reset();
            gameBoard board = new gameBoard();
            Game game = new Game();
            game.run(lose, board);
        });

        exitButton.addActionListener(e -> System.exit(0));
    }

    private void updateLeaderboard() {
        List<ScoreLog.Entry> entries = leaderboard.getEntries();
        StringBuilder sb = new StringBuilder();
        sb.append("\tName\tScore\n");
        sb.append("\t----\t-----\n");
        for (ScoreLog.Entry entry : entries) {
            sb.append(String.format("\t%s\t%d\n", entry.getName(), entry.getScore()));
        }
        leaderboardArea.setText(sb.toString());
    }

    public void setGameBoard(gameBoard board) {
        this.board = board;
    }
}
