
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import static javax.swing.JFrame.*;

public class GUI1 extends JFrame implements ActionListener {

    int nImg = 0;
    JButton btnClick = new JButton("Previous");
    JButton btnClick2 = new JButton("Next");
    JButton btnClick3 = new JButton("Exit");

    public static void main(String[] args) {
        new GUI1().setVisible(true);
    }

    public GUI1() {
        JPanel jp = new JPanel(new BorderLayout());
        JPanel jNav = new JPanel(new BorderLayout());
        setTitle("SlideShow");
        setSize(1028, 850);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        jp.add(jNav, BorderLayout.SOUTH);
        jNav.add(btnClick, BorderLayout.WEST);
        btnClick.addActionListener(this);
        jNav.add(btnClick2, BorderLayout.EAST);
        btnClick2.addActionListener(this);
        jNav.add(btnClick3, BorderLayout.CENTER);
        btnClick3.addActionListener(this);
        getContentPane().add(jp);
        JPanel jPic = new JPanel();
        jp.add(jPic, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent event) {
        PanImage1 panImage1 = new PanImage1();
        PanImage2 panImage2 = new PanImage2();
        PanImage3 panImage3 = new PanImage3();
        revalidate();
        if (event.getSource() == btnClick) {
            if (nImg == 0) {
                nImg = 3;
            } else {
                nImg--;
            }
        } else if (event.getSource() == btnClick2) {
            if (nImg == 4) {
                nImg = 1;
            } else {
                nImg++;
            }
        } else if (event.getSource() == btnClick3) {
            System.exit(0);
        }
        if (nImg == 1) {
            add(panImage1);
        }
        if (nImg == 2) {
            add(panImage2);
        }
        if (nImg == 3) {
            add(panImage3);
        }
    }
}

class PanImage1 extends JPanel {

    private Image image;

    public PanImage1() {
        try {
            image = ImageIO.read(new File("WALLPAPER02.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }
}

class PanImage2 extends JPanel {

    private Image image2;

    public PanImage2() {
        try {
            image2 = ImageIO.read(new File("Initial.D.full.501729.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        g.drawImage(image2, 0, 0, null);
    }
}

class PanImage3 extends JPanel {

    private Image image3;

    public PanImage3() {
        try {
            image3 = ImageIO.read(new File("sleeping_dogs_2012_video_game-wallpaper-1024x768.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        g.drawImage(image3, 0, 0, null);
    }
}
