import javax.swing.*;
import java.util.ArrayList;

public class Snake extends JComponent {

    ArrayList<Segment> body;
    int score;

    Snake() {
        body = new ArrayList<>();
        score = 0;
    }

    public void addSegment() {
        Segment segment = new Segment(360, 360, true);
        body.add(segment);
    }

}
