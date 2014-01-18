

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel{

    TopPanel panTop = new TopPanel();
    public MainPanel(){
        setLayout(new BorderLayout());
        add(panTop,BorderLayout.NORTH);
        setBackground(Color.BLUE);
       
    }
}
