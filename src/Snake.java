import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Snake extends JComponent implements KeyListener {

    private ArrayList<Segment> body;
    private int score;

    Snake() {
        body = new ArrayList<>();
        score = 0;
        addSegment();
    }

    public void addSegment() {
        Segment segment = new Segment(360, 360, true, Direction.DOWN);
        body.add(segment);
    }

    public void paintComponent(Graphics g) {
        for (Segment segment: body) {
            segment.draw(g);
        }
        for (Segment segment: body) {
            segment.move();
        }
        revalidate();
        repaint();
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            body.get(0).setDir(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            body.get(0).setDir(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            body.get(0).setDir(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            body.get(0).setDir(Direction.DOWN);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
