package minesweeper;

import javax.swing.*;
import java.awt.*;
//import java.io.IOException;
//import javax.imageio.ImageIO;

public class panTop extends JPanel{
    
    JButton reset = new JButton();
    public panTop(){
        setBackground(Color.LIGHT_GRAY);
        //http://stackoverflow.com/questions/4801386/how-do-i-add-an-image-to-a-jbutton
        ImageIcon img = new ImageIcon("Happy Face.jpg");
        reset.setIcon(img);
        reset.setPreferredSize(new Dimension(52, 52));
        add(reset);
        
        
        
       
        
    }
    
}
