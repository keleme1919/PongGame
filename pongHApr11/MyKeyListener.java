import java.awt.event.*;
public class MyKeyListener implements KeyListener {
    boolean y1up;
    boolean y1down;
    boolean y2up;
    boolean y2down;

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            y1up = true;
        }
        if (code == KeyEvent.VK_S) {
            y1down = true;
        }
        if (code == KeyEvent.VK_UP) {
            y2up = true;
        }
        if (code == KeyEvent.VK_DOWN) {
            y2down = true;
        }
    }
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            y1up = false;
        }
        if (code == KeyEvent.VK_S) {
            y1down = false;
        }
        if (code == KeyEvent.VK_UP) {
            y2up = false;
        }
        if (code == KeyEvent.VK_DOWN) {
            y2down = false;
        }
    }

    public void keyTyped(KeyEvent e) {}

    public int gety1() {
        if (y1up == true && y1down == true) {
            return 0;
        }
        //if (y1up == true || y1down == true) {
            //return y1;
        //}
        if (y1up == true) {
            return -1;
        }
        if (y1down == true) {
            return 1;
        }
        else {
            return 0;
        }

    }

    public int gety2() {
        if (y2up == true && y2down == true) {
            return 0;
        }
        //if (y2up == true || y2down == true){
        //    return y2;
        //}
        if (y2up == true) {
            return -1;
        }
        if (y2down == true) {
            return 1;
        }
        else {
            return 0;
        }
    }



}



    //create what to listen for and what to return when recieved
        // If key is pressed for slider down, return 1
        // If no key is pressed, return 0
        // if key is pressed for slider up, return -1
