//change the code a bit to make other classes so it works a bit better

import javax.swing.*;
import java.awt.*;

public class Game {

    private static boolean lose = false;
    private static boolean running = true;
    private static boolean scoring = false;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake");
        JOptionPane.showMessageDialog(null, "Welcome to Snake! Use the arrow keys to move the snake. Eat the food to grow longer. Don't hit the walls or yourself!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(720, 720);
        ScoreLogGui gui;
        gameBoard board = new gameBoard();
        frame.getContentPane().add(board);
        frame.pack();
        frame.setVisible(true);

        while (running) {
            // loop that runs the game
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
            scoring = true;
            gui = new ScoreLogGui(new ScoreLog(), board.getScore());
            gui.setVisible(true);

            // loop that checks if player is done scoring and wants to reset
            while (scoring) {
                scoring = gui.isDone();
            }

            // resets the game if player wants to continue
            gui.setVisible(false);
            lose = false;
            frame.remove(board);
            board = new gameBoard();
            frame.getContentPane().add(board);
        }
    }
}
