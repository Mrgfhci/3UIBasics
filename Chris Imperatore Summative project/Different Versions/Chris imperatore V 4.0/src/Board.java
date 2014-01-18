import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
//import java.util.Date;

public class Board extends JPanel implements ActionListener {
    static boolean drawn = false;
    
    private Player p;
    private Timer timer;
    private Image background, RedPlatform1, RedPlatform2;
    // loading in the background image and set (timer/ speed) of the movment of the background 
    public Board() {
        super();
        p = new Player();
        addKeyListener(new ActionListener());
        setFocusable(true);
        ImageIcon i1 = new ImageIcon("peter's background.png");
        ImageIcon i2 = new ImageIcon("Platform_red.png");       
        background = i1.getImage();
        RedPlatform1 = i2.getImage();      
        timer = new Timer(80, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent arg0) {
        p.move();
        repaint();
    }

    public void paint(Graphics g) {

        // draw the background image to the stage
        super.paint(g);
       // System.out.println(new Date());
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, p.backgroundX, 0, null);
        g2d.drawImage(p.getImage(), 350, p.getY(), null);
        g2d.drawImage(RedPlatform1, p.RedPlatformX1, 220, null);    
    }

    private class ActionListener extends KeyAdapter {
        // set key pressed and release actions 

        public void keyReleased(KeyEvent e) {
            p.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            p.keyPressed(e);
        }
    }
}