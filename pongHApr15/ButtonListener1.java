package pongpackage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ButtonListener1 implements ActionListener {
    boolean buttonClicked = false;
    public void actionPerformed(ActionEvent e) {
        buttonClicked = true;
        Thread game = new Thread(new PongGame());
        game.setPriority(Thread.MIN_PRIORITY);
        game.start();
    }
    public boolean getResult() {
        if (buttonClicked == true) {
            return true;
        }
        else {
            return false;
        }

    }
}
