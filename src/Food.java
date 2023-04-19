import java.awt.*;

public class Food {
    public void paintCookie(Graphics g, int x, int y ) {
        g.setColor(new Color(173, 93, 41)); // set color of cookie
        g.fillOval(x, y, 20, 20); // draw cookie shape
        g.setColor(new Color(120, 63, 4)); // set color of chocolate chips
        int numChips = 10; // number of chocolate chips on cookie
//        for (int i=0; i < numChips; i++) {
//            int chipX = x + (int)(Math.random() * 20);
//            int chipY = y + (int)(Math.random() * 20);
//            int chipSize = (int)(20 * 0.1);
//            g.fillOval(chipX, chipY, chipSize, chipSize);
//        }
    }

    Food() {

    }
}
