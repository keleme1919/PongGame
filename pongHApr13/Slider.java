import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D.Double;
import java.awt.geom.Rectangle2D;

/** Class for slider objects */
public class Slider {
    Rectangle2D.Double rect1;
    double x1;
    double y1;
    double x2;
    double y2;
    /** creates object */
    // Do we need to create modifiable coordinates too?
    /** paints the object */
    public Slider(int x1, int y1) {
        this.rect1 = new Double(x1,y1,12,120);
        this.x1 = x1;
        this.y1 = y1;

    }

    public void move(double y1Mod) {
        if (y1Mod == -1.0 || y1Mod == 1.0 || y1Mod == 0.0) {
            if (y1Mod != 0.0) {
                if (y1 > 0.0 && y1 < 542.0) {
                    y1Mod = y1Mod * 10;
                    y1 += y1Mod;
                    this.rect1.setRect(x1, y1,12,120);
                }
                if (y1 < 0.0) {
                    y1 = 0.0;
                }
                if (y1 > 542.0) {
                    y1 = 542.0;
                }
                if (y1 == 0.0 && y1Mod == 1.0) {
                    y1 += 1.0;
                    this.rect1.setRect(x1, y1,12,120);
                }
                if (y1 == 542.0 && y1Mod == -1.0) {
                    y1 += -1.0;
                    this.rect1.setRect(x1,y1,12,120);
                }
            }
        }

    }
    public Rectangle2D.Double getRect() {
        return rect1;
    }

    public double getSliderY() {
        return y1;
    }
}
