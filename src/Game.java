//change the code a bit to make other classes so it works a bit better

import javax.swing.*;
import java.awt.*;

public class Game {

    private static boolean lose = false;

    public static void main(String[] args) {
        gameBoard board = new gameBoard();
        Game game = new Game();
        game.run(lose, board);

    }

    public void run (boolean lose, gameBoard board) {
        {
            JFrame frame = new JFrame("Snake");
            JOptionPane.showMessageDialog(null, "Welcome to Snake! Use the arrow keys to move the snake. Eat the food to grow longer. Don't hit the walls or yourself!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

            ScoreLogGui gui = new ScoreLogGui(new ScoreLog(), board.getScore());
            gui.setGameBoard(board);
            gui.setVisible(true);

        }
    }
}
