package src;

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

    // adds a new Segment object to body ArrayList
    // currently only adds head segment
    public void addSegment() {
        Segment segment = new Segment(360, 360, true, Direction.DOWN);
        body.add(segment);
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
        for (Segment segment: body) {
            if (!segment.move()) {
                segment.move();
            } else {
                Game.lose=true;
                break; //this happens if the Snake crashes
            }
        }
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
