import java.awt.*;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Ellipse2D;
public class Ball {
    Ellipse2D.Double ballOne;
    double x1;
    double y1;
    double movementVar = 13;
    public Ball(double x, double y) {
        this.x1 = x;
        this.y1 = y;
        this.ballOne = new Ellipse2D.Double(x, y, 18.0, 18.0);
    }

    public Ellipse2D.Double getBall() {
        return ballOne;
    }

    public double getBallX() {
        return x1;
    }

    public double getBallY() {
        return y1;
    }

    public void move(double directionX, double directionY) {
            x1 += (directionX * movementVar);
            y1 += (directionY * movementVar);
            if (y1 < -1.0) {
                y1 = -1.0;
            }
            if (y1 > 645.0) {
                y1 = 645.0;
            }
            ballOne.setFrame(x1,y1,18.0,18.0);
    }
}
