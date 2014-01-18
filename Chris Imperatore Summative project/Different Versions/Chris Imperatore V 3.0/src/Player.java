
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Player {
// verables
// beta tester peter
// artist austin

    private Image img;
    int x, y, dx, dy, backgroundX, BeginingY, nCounter = 0;
    long time;
    private final int SPEED = 8;
    private final int GRAV = 1;
    boolean left, right, isJumping, isCrouching, releaseRight, releaseLeft;
    private int Xmin, Xmax, Ymin, Ymax;
    // images for the right running action
    ImageIcon i1 = new ImageIcon("Sasuke_running_f1_R.png ");
    ImageIcon i2 = new ImageIcon("Sasuke_running_f2_R.png");
    ImageIcon i3 = new ImageIcon("Sasuke_running_f3_R.png");
    ImageIcon i4 = new ImageIcon("Sasuke_running_f4_R.png");
    ImageIcon i5 = new ImageIcon("Sasuke_running_f5_R.png");
    ImageIcon i6 = new ImageIcon("Sasuke_running_f6_R.png");
    // images for the left running action
    ImageIcon i7 = new ImageIcon("Sasuke_running_f1_L.png");
    ImageIcon i8 = new ImageIcon("Sasuke_running_f2_L.png");
    ImageIcon i9 = new ImageIcon("Sasuke_running_f3_L.png");
    ImageIcon i10 = new ImageIcon("Sasuke_running_f4_L.png");
    ImageIcon i11 = new ImageIcon("Sasuke_running_f5_L.png");
    ImageIcon i12 = new ImageIcon("Sasuke_running_f6_L.png");
    // images for the standing left and right actions  
    ImageIcon i13 = new ImageIcon("sasuke_standing_R.png");
    ImageIcon i14 = new ImageIcon("sasuke_standing_L.png");
    // images for the jumping right action
    ImageIcon i15 = new ImageIcon("sasuke_jumping-f1_R.png");
    ImageIcon i16 = new ImageIcon("sasuke_jumping-f2_R.png");
    ImageIcon i17 = new ImageIcon("sasuke_jumping-f3_R.png");
    ImageIcon i18 = new ImageIcon("sasuke_jumping-f4_R.png");
    ImageIcon i19 = new ImageIcon("sasuke_jumping-f5_R.png");
    // array's holding the sets of images
    Image arnRunning_R[] = new Image[6];
    Image arnRunning_L[] = new Image[6];
    Image arnjumping_R[] = new Image[5];

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
        isCrouching = false;
        Xmin = 350;
        Xmax = 450;
        releaseRight = false;
        releaseLeft = false;


        // images set to running right array
        arnRunning_R[0] = i1.getImage();
        arnRunning_R[1] = i2.getImage();
        arnRunning_R[2] = i3.getImage();
        arnRunning_R[3] = i4.getImage();
        arnRunning_R[4] = i5.getImage();
        arnRunning_R[5] = i6.getImage();
        //images set to running left array
        arnRunning_L[0] = i7.getImage();
        arnRunning_L[1] = i8.getImage();
        arnRunning_L[2] = i9.getImage();
        arnRunning_L[3] = i10.getImage();
        arnRunning_L[4] = i11.getImage();
        arnRunning_L[5] = i12.getImage();
        // images set to jumping right
        arnjumping_R[0] = i15.getImage();
        arnjumping_R[1] = i16.getImage();
        arnjumping_R[2] = i17.getImage();
        arnjumping_R[3] = i18.getImage();
        arnjumping_R[4] = i19.getImage();

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

        img = i13.getImage();
        
        if (right == true) {
            releaseLeft = false;
            img = arnRunning_R[nCounter];
            nCounter++;

            if (nCounter == 6) {
                nCounter = 0;
            }
            
            if(right == false){
            nCounter = 0;
            }
        }     
        if (left == true) {  
            releaseRight = false;
            img = arnRunning_L[nCounter];
            nCounter++;
            if (nCounter == 6) {
                nCounter = 0;
            }
             if(left == false){
            nCounter = 0;
            }
        }
        if (isJumping == true) {
            //for(int i = 0; i < 5; i++){
            img = arnjumping_R[nCounter];
            //nCounter++;
             if(isJumping == false){
            nCounter = 0;
            }

        } else if (releaseLeft == true) {
            img = i14.getImage();
        } //else if (releaseRight == true) {
        // img = i13.getImage();
        //}

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
        } else if (code == KeyEvent.VK_UP) {
            isJumping = false;
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
            // y = y - 4;

        } else if (code == KeyEvent.VK_DOWN) {
            isCrouching = true;
            //y = y + 4;

        }
    }
}