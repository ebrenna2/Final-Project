//change the code a bit to make other classes so it works a bit better

import javax.swing.*;
import java.awt.*;

public class Game {

    private static boolean lose = false;

    public static void main(String[] args) {
        Game game = new Game();
        game.run();

    }

    public void run () {
        JFrame frame = new JFrame("Snake");
        JOptionPane.showMessageDialog(null, "Welcome to Snake! Use the arrow keys to move the snake. Eat the food to grow longer. Don't hit the walls or yourself!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameBoard board = new gameBoard();
        frame.getContentPane().add(board);
        frame.setSize(720, 720);

        frame.pack();
        frame.setVisible(true);

        while (!lose) {
            board.revalidate();
            board.repaint();
            board.move();
            board.eat();
            lose = board.checkLoseCondition();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (lose) {
            JOptionPane.showMessageDialog(null, "You lose! Your score was " + board.getScore() + ".", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            showScoreLogGui();
        }
    }

    public void showScoreLogGui() {
        gameBoard board = new gameBoard();
        ScoreLogGui gui = new ScoreLogGui(new ScoreLog(), board.getScore());
        gui.setVisible(true);

    }
}

