import java.awt.*;
import javax.swing.*;
/** Class for slider objects */
public class Slider {
    Rectangle rect1;
    int x1;
    int y1;
    int x2;
    int y2;
    /** creates object */
    // Do we need to create modifiable coordinates too?
    /** paints the object */
    public Slider(int x1, int y1) {
        this.rect1 = new Rectangle(x1,y1,12,120);
        this.x1 = x1;
        this.y1 = y1;

    }

    public void sliderMove(int y1Mod) {
        if (y1Mod == -1 || y1Mod == 1 || y1Mod == 0) {
            if (y1Mod != 0) {
                if (y1 > 0 && y1 < 542) {
                    y1Mod = y1Mod * 1;
                    y1 += y1Mod;
                    this.rect1.setLocation(x1, y1);
                }
                if (y1 == 0 && y1Mod == 1) {
                    y1 += 1;
                    this.rect1.setLocation(x1, y1);
                }
                if (y1 == 542 && y1Mod == -1) {
                    y1 += -1;
                    this.rect1.setLocation(x1,y1);
                }
            }
        }

    }
    public Rectangle getRect() {
        return rect1;
    }
}
