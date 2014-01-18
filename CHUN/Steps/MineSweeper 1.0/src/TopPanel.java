

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel{
    
    
    public TopPanel(){
        setLayout(new BorderLayout());//Borderlayout was the problem here
        //what i wanted to do was set a certain size to this panel, I wasn't sure if this was possible
        //so the end product would be about 1 third of the window would be red, the rest would be blue
    
        setBackground(Color.yellow);//learned not to put the color here
        setSize(500, 100);// set size does not work
        
    }
    
}
