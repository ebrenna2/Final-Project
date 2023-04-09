import java.awt.*;

public class Segment {

    private int x;
    private int y;
    private boolean head;

    public Segment(int y, int x, boolean head) {
        this.x = x;
        this.y = y;
        this.head = head;
    }

    public void draw(Graphics g) {
        if (head) {
            g.setColor(Color.orange);
        } else {
            g.setColor(Color.green);
        }
        g.fillRect(x, y, 20, 20);
    }
}
