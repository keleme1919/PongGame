import java.awt.*;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Ellipse2D;
public class Ball {
    Ellipse2D.Double ballOne;
    double x1;
    double y1;
    public Ball(double x, double y) {
        this.x1 = x;
        this.y1 = y;
        this.ballOne = new Ellipse2D.Double(x, y, 18.0, 18.0);
    }

    public Ellipse2D.Double getBall() {
        return ballOne;
    }

    public void move(double directionX, double directionY) {
            x1 += directionX;
            y1 += directionY;
            ballOne.setFrame(x1,y1,18.0,18.0);
    }
}
