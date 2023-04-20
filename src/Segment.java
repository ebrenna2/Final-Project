// Segment class defines the snake body segments
public class Segment {

    private int x;
    private int y;
    private boolean head;
    private Direction dir;

    // creates a segment with an x and y coordinate, a head boolean, and a direction
    public Segment(int y, int x, boolean head, Direction dir) {
        this.x = x;
        this.y = y;
        this.head = head;
        this.dir = dir;
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

    // returns y coordinate
    public int getX() {
        return x;
    }

    //returns x coordinate
    public int getY() {
        return y;
    }

    // changes direction of Segment object
    public void setDir(Direction d) {
        dir = d;
    }

    // returns true if the segment is the head
    public boolean isHead() {
        return head;
    }

    // returns the direction of the segment
    public Direction getDir() { return this.dir; }
}
