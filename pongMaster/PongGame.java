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
        double ballYMOD;
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
        BallCollide wallCollider = new BallCollide(631.0, 322.0);
        // NEW OBJECT FOR SLIDER COLLISION HERE
        ballAngle = wallCollider.getAngle();

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
                wallCollider.collision(ballAngle);
                xxxxx.collision(ballX, ballY, slider1y, slider2y);
                //ballX = xyz.getX();
                //ballY = xyz.getY();
                boolean isSlider = xxxxx.collisionCheck();
                if (isSlider == true) {
                    ballAngle = xxxxx.getAngle();
                    ballXMod = xxxxx.getX();
                    ballYMod = xxxxx.getY();
                }
                else {
                    ballAngle = wallCollider.getAngle();
                    ballXMod = wallCollider.getX();
                    ballYMod = wallCollider.getY();
                }
                display.movement(y1Modifier, y2Modifier, ballX, ballY);
                display.repaint();
                // Ball somehow moves itself
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                long endTime = System.currentTimeMillis();
                long totalTime = endTime - startTime;
                //Thread.sleep(1 - totalTime);
                Thread.sleep(10 - totalTime);
            }

                // Call Display Slider

                // Call Display Ball

                //Sleep (Dan, NO SLEEP???)

                // end once winner


    }
}
