import java.awt.*;

public class Segment {

    private int x;
    private int y;
    private boolean head;
    private Direction dir;

    public Segment(int y, int x, boolean head, Direction dir) {
        this.x = x;
        this.y = y;
        this.head = head;
        this.dir = dir;
    }

    // draws the segment on the screen at the x and y coordinates
    public void draw(Graphics g) {
        if (head) {
            g.setColor(Color.orange);
        } else {
            g.setColor(Color.green);
        }
        g.fillRect(x, y, 20, 20);
    }

    // updates x or y coordinates based on the direction of the Segment
    public void move() {
        switch (dir) {
            case LEFT:
                x -= 20;
                break;
            case RIGHT:
                x += 20;
                break;
            case UP:
                y -= 20;
                break;
            case DOWN:
                y += 20;
                break;
        }
    }

    // changes direction of Segment object
    public void setDir(Direction d) {
        dir = d;
    }
}
