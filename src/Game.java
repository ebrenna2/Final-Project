import javax.swing.*;
import java.awt.*;

public class Game {
    public static void main(String[] args) {
        Snake snake = new Snake();
        JFrame frame = new JFrame();
        JPanel gamePanel = new JPanel();
        gamePanel.setPreferredSize(new Dimension(720, 720));
        gamePanel.setBackground(Color.black);
        gamePanel.add(snake);

        frame.add(gamePanel);
        frame.pack();
        frame.setVisible(true);
    }
}
