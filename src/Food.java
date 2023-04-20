import java.awt.*;

public class Food {

    // draws the cookie onto the board
    public void paintCookie(Graphics g, int x, int y ) {
        g.setColor(new Color(173, 93, 41)); // set color of cookie
        g.fillOval(x, y, 20, 20); // draw cookie shape
    }

    Food() {

    }
}
