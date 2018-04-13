import java.awt.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
/** Class for slider objects */
public class Displayables extends JComponent{
    Slider rect1;
    Slider rect2;
    Ball ballOne;
    Ball ballTwo;
    Ball ballThree;
    Rectangle2D.Double usableRect1;
    Rectangle2D.Double usableRect2;
    Ellipse2D.Double usableBallOne;
    Ellipse2D.Double usableBallTwo;
    Ellipse2D.Double usableBallThree;
    double movementVar;
    boolean twoBallTrue = false;
    boolean threeBallTrue = false;


    /** creates object */
    // Do we need to create modifiable coordinates too?
    /** paints the object */
    public Displayables() {
        this.reset();
    }
    public void reset() {
        rect1 = new Slider(60,271);
        rect2 = new Slider(1208,271);
        ballOne = new Ball(631, 322);
        ballTwo = new Ball(631,322);
        ballThree = new Ball(631,322);
        twoBallTrue = false;
        threeBallTrue = false;
    }

    public void movement(double y1Mod, double y2Mod, double ballX, double ballY, double movementVar) {
        this.movementVar = movementVar;
        rect1.move(y1Mod);
        rect2.move(y2Mod);
        ballOne.move(ballX, ballY, movementVar);
    }

    public void movement2(double y1Mod, double y2Mod, double ballX, double ballY, double ballX2, double ballY2, double movementVar) {
        twoBallTrue = true;
        this.movementVar = movementVar;
        rect1.move(y1Mod);
        rect2.move(y2Mod);
        ballOne.move(ballX, ballY, movementVar);
        ballTwo.move(ballX2, ballY2, movementVar);
    }

    public void movement3(double y1Mod, double y2Mod, double ballX, double ballY, double ballX2, double ballY2, double ballX3, double ballY3, double movementVar) {
        threeBallTrue = true;
        this.movementVar = movementVar;
        rect1.move(y1Mod);
        rect2.move(y2Mod);
        ballOne.move(ballX, ballY, movementVar);
        ballTwo.move(ballX2, ballY2, movementVar);
        ballThree.move(ballX3, ballY3, movementVar);
    }

    public void paintComponent(Graphics g) {
        usableRect1 = rect1.getRect();
        usableRect2 = rect2.getRect();
        usableBallOne = ballOne.getBall();
        usableBallTwo = ballTwo.getBall();
        usableBallThree = ballThree.getBall();
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fill(usableRect1);
        g2.fill(usableRect2);
        g2.setColor(Color.BLUE);
        g2.fill(usableBallOne);
        if (twoBallTrue == true) {
            g2.setColor(Color.RED);
            g2.fill(usableBallTwo);
        }
        if (threeBallTrue == true) {
            g2.setColor(Color.GREEN);
            g2.fill(usableBallThree);
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(1280,662); // appropriate constants
    }

    public double returnBallX() {
        double xxx = ballOne.getBallX();
        return xxx;
    }

    public double returnBallY() {
        double yyy = ballOne.getBallY();
        return yyy;
    }
    public double returnBall2X() {
        double xxx = ballTwo.getBallX();
        return xxx;
    }

    public double returnBall2Y() {
        double yyy = ballTwo.getBallY();
        return yyy;
    }
    public double returnBall3X() {
        double xxx = ballThree.getBallX();
        return xxx;
    }

    public double returnBall3Y() {
        double yyy = ballThree.getBallY();
        return yyy;
    }

    public double returnSlider1Y() {
        double slide1Y = rect1.getSliderY();
        return slide1Y;
    }

    public double returnSlider2Y() {
        double slide2Y = rect2.getSliderY();
        return slide2Y;
    }
}
