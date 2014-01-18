
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Player {
// verables

    private Image img;
    int x, y, dx, dy, backgroundX, BeginingY, nCounter = 0;
    long time;
    private final int SPEED = 8;
    private final int GRAV = 1;
    boolean left, right, isJumping, releaseRight, releaseLeft;
    private int Xmin, Xmax, Ymin, Ymax;
    // images for the right running action
    ImageIcon i1 = new ImageIcon("Pein_running_f1_R.png ");
    ImageIcon i2 = new ImageIcon("Pein_running_f2_R.png");
    ImageIcon i3 = new ImageIcon("Pein_running_f3_R.png");
    ImageIcon i4 = new ImageIcon("Pein_running_f4_R.png");
    // images for the left running action
    ImageIcon i5 = new ImageIcon("Pein_running_f1_L.png");
    ImageIcon i6 = new ImageIcon("Pein_running_f2_L.png");
    ImageIcon i7 = new ImageIcon("Pein_running_f3_L.png");
    ImageIcon i8 = new ImageIcon("Pein_running_f4_L.png");
    // images for the standing left and right actions
    ImageIcon i9 = new ImageIcon("Pein_standing_f1_R.png");
    ImageIcon i17 = new ImageIcon("Pein_standing_f1_L.png");
    /*ImageIcon i10 = new ImageIcon("Pein_standing_f2_R.png");
     ImageIcon i11 = new ImageIcon("Pein_standing_f3_R.png");
     ImageIcon i12 = new ImageIcon("Pein_standing_f4_R.png");
     ImageIcon i13 = new ImageIcon("Pein_standing_f5_R.png");
     ImageIcon i14 = new ImageIcon("Pein_standing_f6_R.png");
     ImageIcon i15 = new ImageIcon("Pein_standing_f7_R.png");
     ImageIcon i16 = new ImageIcon("Pein_standing_f8_R.png");*/
    Image arnRunning_R[] = new Image[4];
    Image arnRunning_L[] = new Image[4];
    // Image arnStanding_R[] = new Image[8];

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
        releaseRight = false;
        releaseLeft = false;



        arnRunning_R[0] = i1.getImage();
        arnRunning_R[1] = i2.getImage();
        arnRunning_R[2] = i3.getImage();
        arnRunning_R[3] = i4.getImage();

        arnRunning_L[0] = i5.getImage();
        arnRunning_L[1] = i6.getImage();
        arnRunning_L[2] = i7.getImage();
        arnRunning_L[3] = i8.getImage();

        /*arnStanding_R[0] = i9.getImage();
         arnStanding_R[1] = i10.getImage();
         arnStanding_R[2] = i11.getImage();
         arnStanding_R[3] = i12.getImage();
         arnStanding_R[4] = i13.getImage();
         arnStanding_R[5] = i14.getImage();
         arnStanding_R[6] = i15.getImage();
         arnStanding_R[7] = i16.getImage();*/

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


        img = i9.getImage();

        if (right == true) {
            releaseLeft = false;
            img = arnRunning_R[nCounter];
            nCounter++;

            if (nCounter == 4) {
                nCounter = 0;
            }
        } else if (left == true) {
            releaseRight = false;
            img = arnRunning_L[nCounter];
            nCounter++;
            if (nCounter == 4) {
                nCounter = 0;
            }
        } else if (releaseLeft == true) {
            img = i17.getImage();
        } else if (releaseRight == true) {
            img = i9.getImage();
        }

        /*else {
         img = arnStanding_R[nCounter];
         nCounter++;

         if (nCounter == 8) {
         nCounter = 0;
         }
         }*/

        return img;
    }
    // check what key is pressed 

    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        // code to make character (Stage) to the left
        if (code == KeyEvent.VK_LEFT) {
            left = false;
            releaseLeft = true;
            if (right) {
                dx = SPEED;
            } else {
                dx = 0;
            }
            // code to make character (Stage) to the right
        } else if (code == KeyEvent.VK_RIGHT) {
            right = false;
            releaseRight = true;
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
            y = y - 4;

        } else if (code == KeyEvent.VK_DOWN) {
            y = y + 4;

        }
    }
}