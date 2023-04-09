import javax.swing.*;
import java.util.ArrayList;

public class Snake extends JComponent {

    ArrayList<Segment> body;
    int score;

    Snake() {
        body = new ArrayList<>();
        score = 0;
    }

}
