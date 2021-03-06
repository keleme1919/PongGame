import java.awt.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Ellipse2D;
/** Class for slider objects */
public class Displayables extends JComponent{
    Slider rect1;
    Slider rect2;
    Ball ballOne;
    Rectangle usableRect1;
    Rectangle usableRect2;
    Ellipse2D.Double usableBallOne;


    /** creates object */
    // Do we need to create modifiable coordinates too?
    /** paints the object */
    public Displayables() {
        rect1 = new Slider(60,271);
        rect2 = new Slider(1208,271);
        ballOne = new Ball(631, 322);
    }

    public void movement(int y1Mod, int y2Mod, double ballX, double ballY) {
        rect1.move(y1Mod);
        rect2.move(y2Mod);
        ballOne.move(ballX, ballY);
    }

    public void paintComponent(Graphics g) {
        usableRect1 = rect1.getRect();
        usableRect2 = rect2.getRect();
        usableBallOne = ballOne.getBall();
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fill(usableRect1);
        g2.fill(usableRect2);
        g2.setColor(Color.BLUE);
        g2.fill(usableBallOne);
        }

    public Dimension getPreferredSize() {
        return new Dimension(1280,662); // appropriate constants
    }
}
