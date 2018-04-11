import java.awt.*;
import javax.swing.*;
/** Class for slider objects */
public class Displayables extends JComponent{
    Slider rect1;
    Slider rect2;
    Rectangle usableRect1;
    Rectangle usableRect2;
    /** creates object */
    // Do we need to create modifiable coordinates too?
    /** paints the object */
    public Displayables(int x1, int y1, int x2, int y2) {
        rect1 = new Slider(x1,y1);
        rect2 = new Slider(x2,y2);
    }

    public void movement(int y1Mod, int y2Mod) {
        rect1.sliderMove(y1Mod);
        rect2.sliderMove(y2Mod);
    }

    public void paintComponent(Graphics g) {
        usableRect1 = rect1.getRect();
        usableRect2 = rect2.getRect();
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fill(usableRect1);
        g2.fill(usableRect2);
    }

    public Dimension getPreferredSize() {
        return new Dimension(1280,720); // appropriate constants
    }
}
