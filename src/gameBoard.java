import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class gameBoard extends JPanel {

    private Snake snake;
    private int gridSize=36;
    private ArrayList<ArrayList<State>> grid=createGrid(gridSize);

    gameBoard() {
        snake = new Snake();
        setBackground(Color.black);
        setPreferredSize(new Dimension(720, 720));
        setLayout(new BorderLayout());
        add(snake);
        addKeyListener(snake);
        setFocusable(true);
    }

    public void move() {
        snake.move();
    }

    public boolean checkLoseCondition() {
        Segment head = snake.getBody().get(0);
        if (head.getX() < 0 || head.getY() < 0) return true;
        if (grid.get(head.getY()/20).get(head.getX()/20)== State.WALL||
                grid.get(head.getY()/20).get(head.getX()/20)==State.BODY) {
            return true;
        } else return false;
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
    }
}