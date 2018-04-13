import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/** Main game class */
public class PongGame2 {
    /** Main method
     * @param args unused
     */
    public static void main(String[] args) throws InterruptedException {
        double ballXMod;
        double ballYMod;
        double ball2XMod;
        double ball2YMod;
        double ball3XMod;
        double ball3YMod;
        double ballAngle;
        double ball2Angle;
        double ball3Angle;
        double ballX;
        double ballY;
        double ball2X;
        double ball2Y;
        double ball3X;
        double ball3Y;
        double slider1y;
        double slider2y;
        double movementVar;
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
        int games = 0;
        while (games < 5) {
            boolean gameOver = false;
            BallCollide wallCollider = new BallCollide(631.0, 322.0, 1.0, 0.0, 90.0);
            BallCollide wallCollider2 = new BallCollide(631.0, 322.0, -1.0, 0.0, 270.0);
            BallCollide wallCollider3 = new BallCollide(631.0, 322.0, 1.0, 0.0, 90.0);
            // NEW OBJECT FOR SLIDER COLLISION HERE
            CollisionBallSlider sliderCollider = new CollisionBallSlider();
            CollisionBallSlider sliderCollider2 = new CollisionBallSlider();
            CollisionBallSlider sliderCollider3 = new CollisionBallSlider();
            ball3Angle = wallCollider3.getAngle();
            ball2Angle = wallCollider2.getAngle();
            ballAngle = wallCollider.getAngle();
            ball3XMod = 1.0;
            ball3YMod = 0.0;
            ball2XMod = -1.0;
            ball2YMod = 0.0;
            ballXMod = 1.0;
            ballYMod = 0.0;
            movementVar = 8;
            // Create game state object
            while (gameOver == false) {
                // While Loop
                    // Keyboard listener moves slider
                    long startTime = System.currentTimeMillis();
                    int ballCheck = listener.ballStatus();
                    double y1Modifier = listener.gety1();
                    double y2Modifier = listener.gety2();
                    ballX = display.returnBallX();
                    ballY = display.returnBallY();
                    ball2X = display.returnBall2X();
                    ball2Y = display.returnBall2Y();
                    ball3X = display.returnBall3X();
                    ball3Y = display.returnBall3Y();
                    slider1y = display.returnSlider1Y();
                    slider2y = display.returnSlider2Y();
                    System.out.println(ballCheck);
                    if (ballCheck == 0) {
                        wallCollider.collision(ballAngle, ballXMod, ballYMod, movementVar);
                        sliderCollider.collisionSlid(ballX, ballY, slider1y, slider2y, movementVar);
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
                        display.movement(y1Modifier, y2Modifier, ballXMod, ballYMod, movementVar);
                        display.repaint();
                    }
                    if (ballCheck == 1) {
                        wallCollider.collision(ballAngle, ballXMod, ballYMod, movementVar);
                        wallCollider2.collision(ball2Angle, ball2XMod, ball2YMod, movementVar);
                        sliderCollider.collisionSlid(ballX, ballY, slider1y, slider2y, movementVar);
                        sliderCollider2.collisionSlid(ball2X, ball2Y, slider1y, slider2y, movementVar);
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
                        boolean isSlider2 = sliderCollider2.collisionCheck();
                        if (isSlider2 == true) {
                            ball2Angle = sliderCollider2.getAngle();
                            ball2XMod = sliderCollider2.getX();
                            ball2YMod = sliderCollider2.getY();
                            //System.out.println(ballAngle);
                        }
                        else {
                            ball2Angle = wallCollider2.getAngle();
                            ball2XMod = wallCollider2.getX();
                            ball2YMod = wallCollider2.getY();
                            //System.out.println(ballAngle);
                        }
                        display.movement2(y1Modifier, y2Modifier, ballXMod, ballYMod, ball2XMod, ball2YMod, movementVar);
                        display.repaint();
                    }
                    if (ballCheck == 2) {
                        wallCollider.collision(ballAngle, ballXMod, ballYMod, movementVar);
                        wallCollider2.collision(ball2Angle, ball2XMod, ball2YMod, movementVar);
                        wallCollider3.collision(ball3Angle, ball3XMod, ball3YMod, movementVar);
                        sliderCollider.collisionSlid(ballX, ballY, slider1y, slider2y, movementVar);
                        sliderCollider2.collisionSlid(ball2X, ball2Y, slider1y, slider2y, movementVar);
                        sliderCollider3.collisionSlid(ball3X, ball3Y, slider1y, slider2y, movementVar);
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
                        boolean isSlider2 = sliderCollider2.collisionCheck();
                        if (isSlider2 == true) {
                            ball2Angle = sliderCollider2.getAngle();
                            ball2XMod = sliderCollider2.getX();
                            ball2YMod = sliderCollider2.getY();
                            //System.out.println(ballAngle);
                        }
                        else {
                            ball2Angle = wallCollider2.getAngle();
                            ball2XMod = wallCollider2.getX();
                            ball2YMod = wallCollider2.getY();
                            //System.out.println(ballAngle);
                        }
                        boolean isSlider3 = sliderCollider3.collisionCheck();
                        if (isSlider3 == true) {
                            ball3Angle = sliderCollider3.getAngle();
                            ball3XMod = sliderCollider3.getX();
                            ball3YMod = sliderCollider3.getY();
                            //System.out.println(ballAngle);
                        }
                        else {
                            ball3Angle = wallCollider3.getAngle();
                            ball3XMod = wallCollider3.getX();
                            ball3YMod = wallCollider3.getY();
                            //System.out.println(ballAngle);
                        }
                        display.movement3(y1Modifier, y2Modifier, ballXMod, ballYMod, ball2XMod, ball2YMod, ball3XMod, ball3YMod, movementVar);
                        display.repaint();
                    }
                    // Ball somehow moves itself
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    long endTime = System.currentTimeMillis();
                    long totalTime = endTime - startTime;
                    if (ballX < 23 || ballX > 1240) {
                        games += 1;
                        gameOver = true;
                    }
                    if (ball2X < 23 || ball2X > 1240) {
                        games += 1;
                        gameOver = true;
                    }
                    if (ball3X < 23 || ball3X > 1240) {
                        games += 1;
                        gameOver = true;
                    }
                    //Thread.sleep(1 - totalTime);
                    Thread.sleep(15 - totalTime);
                }
                display.reset();
                listener.reset();
            }

                // Call Display Slider

                // Call Display Ball

                //Sleep (Dan, NO SLEEP???)

                // end once winner


    }
}
