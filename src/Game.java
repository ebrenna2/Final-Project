import javax.swing.*;
import java.awt.*;

public class Game {

    private static boolean lose = false;
    public static void main(String[] args) {
        Snake snake = new Snake();
        JFrame frame = new JFrame();
        JPanel gamePanel = new JPanel();
        gamePanel.setPreferredSize(new Dimension(720, 720));
        gamePanel.setLayout(new BorderLayout());
        gamePanel.setBackground(Color.black);
        gamePanel.add(snake);
        gamePanel.addKeyListener(snake);
        gamePanel.setFocusable(true);

        frame.add(gamePanel);
        frame.pack();
        frame.setVisible(true);

        while (!lose) {
            gamePanel.revalidate();
            gamePanel.repaint();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
