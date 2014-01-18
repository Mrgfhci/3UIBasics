import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel // panel definition
{
    int x;
    int y;
    panButtons panbuttons = new panButtons();
    Image background;
    Image image;
    JButton btn;
    

    public MainPanel() {
  
    
        setLayout(new BorderLayout());
        background = Toolkit.getDefaultToolkit().createImage("background.jpg");
        image = Toolkit.getDefaultToolkit().createImage("Naruto_Standstill.gif");
       
      add(panbuttons, BorderLayout.SOUTH);
    }
    
    public void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, 700, 400, this);
         x =  panbuttons.getdX();
         y =  panbuttons.getdY();
        g.drawImage(image, x, y, this);
        
    }
       
        
    }

   

 
  
