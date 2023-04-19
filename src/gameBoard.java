
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class gameBoard extends JPanel {

    private Snake snake;
    private int gridSize=36;
    private ArrayList<ArrayList<State>> grid=createGrid(gridSize);

    private int score;
    private JLabel scoreLabel;

    private Food cookie;

    private int cookiePos;

    gameBoard() {
        snake = new Snake();
        setBackground(Color.black);
        setPreferredSize(new Dimension(720, 720));
        setLayout(new BorderLayout());
        add(snake);
        addKeyListener(snake);
        setFocusable(true);

        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setForeground(Color.RED);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 30));
        scoreLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(scoreLabel, BorderLayout.NORTH);

        cookie = new Food();
        cookiePos = 40;
    }

    public void move() {
        snake.move();
    }

    public void eat() {
        ScoreLog scoreLog = new ScoreLog();
        if (snake.getBody().get(0).getX() == cookiePos && snake.getBody().get(0).getY() == cookiePos) {
            score++;
            scoreLabel.setText("Score: " + score);
            snake.addSegment();
            cookiePos = randomCookieCords();
        }
    }

    public boolean checkFoodCondition() {
        boolean foodEaten = false;
            for (int i = 1; i < snake.getBody().size(); i++) {
                Segment segment = snake.getBody().get(i);
                if ((cookiePos) == segment.getX() && (cookiePos) == segment.getY()) {
                    foodEaten = true;
            }
        }
        return foodEaten;
    }

    public int randomCookieCords() {
        Random random = new Random();
        int randPos = 0;
        boolean overlap = true;

        while (overlap) {
            randPos = random.nextInt(0, 37);
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
        if (head.getX() < 0 || head.getX() > 710 || head.getY() < 0 || head.getY() > 710) {
            lose = true;
        }
        return lose;

        /*System.out.println(grid.get(head.getY()/20).get(head.getX()/20));
        if (head.getX() < 0 || head.getY() < 0) return true;
        if (grid.get(head.getY()/20).get(head.getX()/20)== State.WALL||
                grid.get(head.getY()/20).get(head.getX()/20)==State.BODY) {
            return true;
        } else return false;*/
    }

    public static ArrayList<ArrayList<State>> createGrid(int gridSize) {
        ArrayList<ArrayList<State>> grid=new ArrayList<>();
        ArrayList<State> wallRow=new ArrayList<>();
        for (int i=0;i<gridSize;i++) {
            wallRow.add(State.WALL);
        }
        ArrayList<State> emptyRow=new ArrayList<>();
        emptyRow.add(State.WALL);
        for (int i=0;i<gridSize;i++) {
            emptyRow.add(State.EMPTY);
        }
        emptyRow.add(State.WALL);
        grid.add(wallRow);
        for (int i=0;i<gridSize;i++) {
            grid.add(emptyRow);
        }
        grid.add(wallRow);
        return grid;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        snake.draw(g);
        cookie.paintCookie(g, cookiePos);
    }


    public int getScore() {
        return score;
    }

}