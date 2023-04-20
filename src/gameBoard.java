
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class gameBoard extends JPanel {

    private Snake snake;
    private int score = 0;
    private Food cookie;
    private int cookiePosX;
    private int cookiePosY;

    gameBoard() {
        snake = new Snake();
        setBackground(Color.black);
        setPreferredSize(new Dimension(580, 580));
        setLayout(new BorderLayout());
        add(snake);
        addKeyListener(snake);
        setFocusable(true);

        cookie = new Food();
        cookiePosX = 40;
        cookiePosY = 40;
    }

    public int getScore() {
        return score;
    }

    public void move() {
        snake.move();
    }

    public void eat() {
        if (snake.getBody().get(0).getX() == cookiePosX && snake.getBody().get(0).getY() == cookiePosY) {
            score++;
            snake.addSegment();
            cookiePosX = randomCookieCords();
            cookiePosY = randomCookieCords();
        }
    }

    public int randomCookieCords() {
        Random random = new Random();
        int randPos = 0;
        boolean overlap = true;

        while (overlap) {
            randPos = random.nextInt(0, 29);
            for (int i = 1; i < snake.getBody().size(); i++) {
                Segment segment = snake.getBody().get(i);
                if ((randPos*20) != segment.getX() && (randPos*20) != segment.getY()) {
                    overlap = false;
                }
            }
        }
        return randPos*20;
    }

    public boolean checkLoseCondition() {
        boolean lose = false;
        Segment head = snake.getBody().get(0);

        // checks collision between head and body segments or wall
        for (int i = 1; i < snake.getBody().size(); i++) {
            Segment segment = snake.getBody().get(i);
            if (head.getX() == segment.getX() && head.getY() == segment.getY()) {
                lose = true;
            }
        }
        if (head.getX() < 0 || head.getX() > 580 || head.getY() < 0 || head.getY() > 580) {
            lose = true;
        }
        return lose;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        snake.draw(g);
        cookie.paintCookie(g, cookiePosX, cookiePosY); // paint cookie
        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Score: " + score, 440, 25);
    }
}