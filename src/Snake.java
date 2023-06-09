import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

// Snake class defines a snake object with segments and controls
public class Snake extends JComponent implements KeyListener {

    private ArrayList<Segment> body;

    // creates the snake object starting with the head segment
    Snake() {
        body = new ArrayList<>();
        addHead();
    }

    // adds the head segment to the body
    public void addHead() {
        Segment segment = new Segment(280, 280, true, Direction.DOWN);
        body.add(segment);
    }

    // adds a body segment to the body
    public void addSegment() {
        Direction in=body.get(this.body.size()-1).getDir();
        int newX=body.get(this.body.size()-1).getX();
        int newY=body.get(this.body.size()-1).getY();
        if (in==Direction.UP)
            newY=newY+20;
        else if (in==Direction.DOWN)
            newY=newY-20;
        else if (in==Direction.LEFT)
            newX=newX+20;
        else
            newX=newX-20;
        Segment segment = new Segment(newY, newX, false, in);
        body.add(segment);
    }

    // moves the segments in the body
    public void move() {
        Direction inh=body.get(0).getDir();
        for (int i=0;i<body.size();i++) {
            body.get(i).move();
            Direction temp=body.get(i).getDir();
            body.get(i).setDir(inh);
            inh=temp;
        }
    }

    // draws and moves each segment in the body ArrayList
    public void draw(Graphics g) {
        for (Segment segment: body) {
            if (segment.isHead()) {
                g.setColor(Color.orange);
            } else {
                g.setColor(Color.green);
            }
            g.fillRect(segment.getX(), segment.getY(), 20, 20);
        }
    }

    // returns the body ArrayList with the Segment objects
    public ArrayList<Segment> getBody() {
        return body;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // Changes direction of head segment based on arrow key presses
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            if(body.get(0).getDir()!=Direction.LEFT)
                body.get(0).setDir(Direction.RIGHT);
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            if(body.get(0).getDir()!=Direction.RIGHT)
                body.get(0).setDir(Direction.LEFT);
        if (e.getKeyCode() == KeyEvent.VK_UP)
            if(body.get(0).getDir()!=Direction.DOWN)
                body.get(0).setDir(Direction.UP);
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            if(body.get(0).getDir()!=Direction.UP)
                body.get(0).setDir(Direction.DOWN);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
