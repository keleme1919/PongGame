import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/** Main game class */
public class PongGame {
    /** Main method
     * @param args unused
     */
    public static void main(String[] args) throws InterruptedException {
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

        // Create game state object
        while (gameOver == false) {
            // While Loop

                // Keyboard listener moves slider
                double y1Modifier = listener.gety1();
                double y2Modifier = listener.gety2();
                display.movement(y1Modifier, y2Modifier,0.5,0.0);
                display.repaint();
                // Ball somehow moves itself
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Thread.sleep(1);
            }

                // Call Display Slider

                // Call Display Ball

                //Sleep (Dan, NO SLEEP???)

                // end once winner


    }
}
