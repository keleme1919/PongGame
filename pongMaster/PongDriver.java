package pongpackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongDriver {
    public static void main(String[] args){
        JFrame window = new JFrame("Selection Screen");
        JPanel pane = new JPanel(new BorderLayout());
        JPanel pane2 = new JPanel(new BorderLayout());
        pane.setLayout(new FlowLayout());
        pane.setSize(500,500);
        pane2.setSize(500,500);
        JButton jbn = new JButton("Ball gets faster");
        JButton jbn2 = new JButton("Multiple Balls");
        JLabel message = new JLabel("Choose a mode!");
        JLabel welcomeMessage = new JLabel("Beer-less Pong!");
        welcomeMessage.setFont(new Font("Impact", Font.BOLD, 40));
        jbn.setContentAreaFilled(true);
        ButtonListener1 listener1 = new ButtonListener1();
        jbn.addActionListener(listener1);
        jbn2.setContentAreaFilled(true);
        ButtonListener2 listener2 = new ButtonListener2();
        jbn2.addActionListener(listener2);
        jbn.setSize(75,75);
        jbn2.setSize(75,75);
        pane2.add(message, BorderLayout.SOUTH);
        pane2.add(jbn, BorderLayout.EAST);
        pane2.add(jbn2, BorderLayout.WEST);
        pane2.add(welcomeMessage, BorderLayout.NORTH);
        pane.add(pane2, BorderLayout.CENTER);
        window.add(pane);
        window.pack();
        //window.pack();
        window.setVisible(true);
        window.setLocation(800,500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
