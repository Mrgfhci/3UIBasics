
package minesweeper;

import javax.swing.*;
import java.awt.*;

public class panMain extends JPanel{
    
    panGrid grid = new panGrid();
    panTop panTop = new panTop();
    panBottom panBottom = new panBottom();
    public panMain(){
        setLayout(new BorderLayout());
        
        
        
        
        add(panTop, BorderLayout.NORTH);
        add(grid, BorderLayout.CENTER);
        add(panBottom, BorderLayout.SOUTH);
    }
}
