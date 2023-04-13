import javax.swing.*;
import java.awt.*;

public class gameBoard extends JPanel {

    private Snake snake;

    gameBoard() {
        snake = new Snake();
        setBackground(Color.black);
        setPreferredSize(new Dimension(720, 720));
        setLayout(new BorderLayout());
        add(snake);
        addKeyListener(snake);
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        snake.draw(g);
    }
}
