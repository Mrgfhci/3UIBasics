
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Player {
// verables

    private Image img;
    int x, y, dx, dy, backgroundX, BeginingY, nCounter = 0;
    long time;
    private final int SPEED = 2;
    private final int GRAV = 1;
    boolean left, right, isJumping;
    private int Xmin, Xmax, Ymin, Ymax;
    ImageIcon i1 = new ImageIcon("Pein_running_f1.png");
    ImageIcon i2 = new ImageIcon("Pein_running_f2.png");
    ImageIcon i3 = new ImageIcon("Pein_running_f3.png");
    ImageIcon i4 = new ImageIcon("Pein_running_f4.png");
    Image arnFrames[] = new Image[4];

// player image and place on the stage and other verable definations 
    public Player() {
        x = 350;
        y = 238;
        dx = 0;
        dy = 0;
        backgroundX = 0;
        left = false;
        right = false;
        isJumping = false;
        Xmin = 350;
        Xmax = 450;
        arnFrames[0] = i1.getImage();
        arnFrames[1] = i2.getImage();
        arnFrames[2] = i3.getImage();
        arnFrames[3] = i4.getImage();
    }
    // time delay for the jump function 

    public static void TimeDelay() {
        for (int i = 0; i < 1000; i++) {
        }
    }
    // how to move the stage to make it look liek the player is moving

    public void move() {
        x += dx;
        backgroundX = (backgroundX - dx);
    }
    // check the current state of the X cordinate of teh focoused stage

    public int getX() {
        return x;
    }
    // check the Current state of the Y cordinate of the focoused stage 

    public int getY() {
        return y;
    }
    // image stuff

    public Image getImage() {          
            img = arnFrames[nCounter];
            nCounter++;
       
         if (nCounter == 4) {
            nCounter = 0;
        }
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
            BeginingY = y;
            for (int i = 0; i < 10; i++) {
                y = BeginingY - 4;
            }
        }
    }
}