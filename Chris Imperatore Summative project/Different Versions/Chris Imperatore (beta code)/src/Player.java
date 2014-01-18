
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Player {
// verables
    private Image img;
    int x, y, dx, dy, nx;
    long time;
    private final int SPEED = 2;
    private final int GRAV = 1;
    boolean left, right, isJumping;
// player image and place on the stage and other verable definations 
    public Player() {
        ImageIcon i = new ImageIcon("Sonic.jpg");
        img = i.getImage();
        x = 350;
        y = 260;
        dx = 0;
        dy = 0;
        nx = 0;
        left = false;
        right = false;
        isJumping = false;
    }
        // time delay for the jump function 
    public void TimeDelay() {
        for (int i = 0; i < 1000; i++) {
        }
    }
    // how to move the stage to make it look liek the player is moving
    public void move() {
        x += dx;
        nx = (nx - dx);
    }
        // check the current state of the X cordinate of teh focoused stage
    public int getX() {
        return x;
    }
        // check teh Current state of the Y cordinate of the focoused stage 
    public int getY() {
        return y;
    }
        // image stuff
    public Image getImage() {
        return img;
    }
        // check what key is pressed 
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
            // code to make character (Stage) to the left
        if (code == KeyEvent.VK_LEFT) {
            left = false;
            if (right) {
                dx = SPEED;
            } else {
                dx = 0;
            }
            // code to make character (Stage) to the right
        } else if (code == KeyEvent.VK_RIGHT) {
            right = false;
            if (left) {
                dx = -SPEED;
            } else {
                dx = 0;
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        //if the lest key is pressed the player will move to the left
        if (code == KeyEvent.VK_LEFT) {
            left = true;
            dx = -SPEED;
            //if the right key is pressed the player will move to the right
        } else if (code == KeyEvent.VK_RIGHT) {
            right = true;
            dx = SPEED;
        } // if the up key is pressed the player move up
        else if (code == KeyEvent.VK_UP) {
            isJumping = true;
            for (int i = 0; i < 30; i++) {
            // need time delay in between counter steps
                // make own time delay?
                // can't use sleep or it stops program
                
                y = 260 - i;
            }
        }
    }
}