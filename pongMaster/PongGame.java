package pongpackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/** Main game class */
public class PongGame implements Runnable {
    /** Main method
     * @param args unused
     */
    public PongGame() {}

    public void run() {
        double ballXMod = 0;
        double ballYMod = 0;
        double ballAngle;
        double ballX;
        double ballY;
        double slider1y;
        double slider2y;
        double movementVar = 0;
        int winnerVal;
        double y1Modifier = 0;
        double y2Modifier = 0;
        int rallyCounter = 0;
        int longestRally = 0;
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
        int playerOneScore = 0;
        int playerTwoScore = 0;
        while (playerOneScore < 5 && playerTwoScore < 5) {
            boolean gameOver = false;
            CollisionBallWall wallCollider = new CollisionBallWall(631.0, 322.0, 1.0, 0.0, 90.0);
            // NEW OBJECT FOR SLIDER COLLISION HERE
            CollisionBallSlider sliderCollider = new CollisionBallSlider();
            ballAngle = wallCollider.getAngle();
            ballXMod = 1.0;
            ballYMod = 0.0;
            movementVar = 9;

            // Create game state object
            while (gameOver == false) {
                // While Loop

                    // Keyboard listener moves slider
                    long startTime = System.currentTimeMillis();
                    y1Modifier = listener.gety1();
                    y2Modifier = listener.gety2();
                    ballX = display.returnBallX();
                    ballY = display.returnBallY();
                    slider1y = display.returnSlider1Y();
                    slider2y = display.returnSlider2Y();
                    wallCollider.collision(ballAngle, ballXMod, ballYMod, movementVar);
                    sliderCollider.collisionSlid(ballX, ballY, slider1y, slider2y, movementVar);
                    //ballX = xyz.getX();
                    //ballY = xyz.getY();
                    boolean isSlider = sliderCollider.collisionCheck();
                    if (isSlider == true) {
                        ballAngle = sliderCollider.getAngle();
                        ballXMod = sliderCollider.getX();
                        ballYMod = sliderCollider.getY();
                        rallyCounter += 1;
                        //System.out.println(ballAngle);
                    }
                    else {
                        ballAngle = wallCollider.getAngle();
                        ballXMod = wallCollider.getX();
                        ballYMod = wallCollider.getY();
                        //System.out.println(ballAngle);
                    }
                    display.movement(y1Modifier, y2Modifier, ballXMod, ballYMod, movementVar, playerOneScore, playerTwoScore, rallyCounter, longestRally);
                    display.repaint();
                    // Ball somehow moves itself
                    window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    long endTime = System.currentTimeMillis();
                    long totalTime = endTime - startTime;
                    if (ballX < 23) {
                        playerTwoScore += 1;
                        gameOver = true;
                        if (longestRally <= rallyCounter) {
                            longestRally = rallyCounter;
                        }
                    }

                    if (ballX > 1240) {
                        playerOneScore += 1;
                        gameOver = true;
                        if (longestRally <= rallyCounter) {
                            longestRally = rallyCounter;
                        }
                    }
                    movementVar = movementVar + 0.006;
                    //Thread.sleep(1 - totalTime);
                    try {
                        Thread.sleep(17 - totalTime);
                    }
                    catch(InterruptedException e) {}
                }
                if (playerOneScore < 5 && playerTwoScore < 5) {
                    rallyCounter = 0;
                }
                display.reset();

            movementVar = 0;
            display.movement(y1Modifier, y2Modifier, ballXMod, ballYMod, movementVar, playerOneScore, playerTwoScore, rallyCounter, longestRally);
            display.repaint();
        }

    }

}
