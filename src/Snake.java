import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Snake extends JComponent {

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
}
