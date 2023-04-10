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
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
