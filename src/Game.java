

import javax.swing.*;

public class Game {

    private static boolean lose = false;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
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
            lose = board.checkLoseCondition();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        ScoreLogGui gui = new ScoreLogGui(new ScoreLog());
        gui.setVisible(true);
    }
}
