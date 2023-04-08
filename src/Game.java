import javax.swing.*;
import java.awt.*;

public class Game {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel gamePanel = new JPanel();
        gamePanel.setPreferredSize(new Dimension(720, 720));
        gamePanel.setBackground(Color.black);

        frame.add(gamePanel);
        frame.pack();
        frame.setVisible(true);
    }
}
