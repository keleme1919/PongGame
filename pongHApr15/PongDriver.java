package pongpackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongDriver {
    public static void main(String[] args){
        JFrame window = new JFrame("Selection Screen");
        JPanel pane = new JPanel(new BorderLayout(500,500));
        JPanel pane2 = new JPanel(new BorderLayout());
        pane.setLayout(new FlowLayout());
        pane.setSize(500,500);
        pane2.setSize(500,500);
        JButton jbn = new JButton("Ball gets faster");
        JButton jbn2 = new JButton("Multiple Balls");
        JLabel message = new JLabel("Choose a mode!");
        jbn.setContentAreaFilled(true);
        ButtonListener1 listener1 = new ButtonListener1();
        jbn.addActionListener(listener1);
        jbn2.setContentAreaFilled(true);
        ButtonListener2 listener2 = new ButtonListener2();
        jbn2.addActionListener(listener2);
        pane2.add(message, BorderLayout.NORTH);
        pane2.add(jbn, BorderLayout.WEST);
        pane2.add(jbn2, BorderLayout.EAST);
        pane.add(pane2);
        window.add(pane);
        window.pack();
        //window.pack();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*while (true) {
            boolean click = listener1.getResult();
            boolean click2 = listener2.getResult();
            if (click == true) {
                click = false;
                PongGame.main(args);
            }
            if (click2 == true) {
                click2 = false;
                PongGame2.main(args);
            }
        }*/
    }

}
