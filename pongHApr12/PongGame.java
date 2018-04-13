import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/** Main game class */
public class PongGame {
    /** Main method
     * @param args unused
     */
    public static void main(String[] args) throws InterruptedException {
        double ballXMod;
        double ballYMod;
        double ballAngle;
        double ballX;
        double ballY;
        double slider1y;
        double slider2y;
        JFrame window = new JFrame("Pong");
        JPanel pane = new JPanel();
        JPanel pane2 = new JPanel();
        pane.setLayout(new FlowLayout());
        pane.setSize(12,72);
        Displayables display = new Displayables();
        pane.add(display);
        pane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        pane.setVisible(true);
        window.add(pane);
        MyKeyListener listener = new MyKeyListener();
        window.addKeyListener(listener);
        window.pack();
        //window.setSize(1280,720);
        window.setVisible(true);
        boolean gameOver = false;
        BallCollide wallCollider = new BallCollide(631.0, 322.0, 1.0, 0.0, 90.0);
        // NEW OBJECT FOR SLIDER COLLISION HERE
        CollisionBallSlider sliderCollider = new CollisionBallSlider();
        ballAngle = wallCollider.getAngle();
        ballXMod = 1.0;
        ballYMod = 0.0;

        // Create game state object
        while (gameOver == false) {
            // While Loop

                // Keyboard listener moves slider
                long startTime = System.currentTimeMillis();
                double y1Modifier = listener.gety1();
                double y2Modifier = listener.gety2();
                ballX = display.returnBallX();
                ballY = display.returnBallY();
                slider1y = display.returnSlider1Y();
                slider2y = display.returnSlider2Y();
                wallCollider.collision(ballAngle, ballXMod, ballYMod);
                sliderCollider.collisionSlid(ballX, ballY, slider1y, slider2y);
                //ballX = xyz.getX();
                //ballY = xyz.getY();
                boolean isSlider = sliderCollider.collisionCheck();
                if (isSlider == true) {
                    ballAngle = sliderCollider.getAngle();
                    ballXMod = sliderCollider.getX();
                    ballYMod = sliderCollider.getY();
                    //System.out.println(ballAngle);
                }
                else {
                    ballAngle = wallCollider.getAngle();
                    ballXMod = wallCollider.getX();
                    ballYMod = wallCollider.getY();
                    //System.out.println(ballAngle);
                }
                display.movement(y1Modifier, y2Modifier, ballXMod, ballYMod);
                display.repaint();
                // Ball somehow moves itself
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                long endTime = System.currentTimeMillis();
                long totalTime = endTime - startTime;
                if (ballX < 23 || ballX > 1240) {
                    gameOver = true;
                }

                //Thread.sleep(1 - totalTime);
                Thread.sleep(15 - totalTime);
            }

                // Call Display Slider

                // Call Display Ball

                //Sleep (Dan, NO SLEEP???)

                // end once winner


    }
}
