package minesweeper;
import javax.swing.JButton; 
import java.awt.GridLayout; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;

public class panGrid extends JPanel {
    int arnRandomBombs[] = new int[36];
    JPanel panTop = new JPanel();
    JButton[][] grid; //names the grid of buttons
    Random rand = new Random();
    int max = 144;
    int min = 0;
    private int randomNum;
    private int width, length;

    public panGrid() {
        width = 12;
        length = 12;
        int i = 0;
        setLayout(new GridLayout(width, length)); 
        //http://www.wikihow.com/Make-a-GUI-Grid-in-Java
        grid = new JButton[width][length]; 
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                i++;
                grid[x][y] = new JButton("" + i);
                add(grid[x][y]);
            }
        }
        //Min + (int)(Math.random() * ((Max - Min) + 1))
        //
        for (int n = 0; n < 36; n++) {
            randomNum = rand.nextInt((max - min) + 1) + min;
            for (int k = 0; k < 36; k++) {
                //checks to see if the new random number is not the same 
                //as any previous ones
                if (randomNum == arnRandomBombs[k]) {
                    randomNum = rand.nextInt((max - min) + 1) + min;

                } else {
                    arnRandomBombs[n] = randomNum;

                }
            }
        }//print out all the random numbers generated
        for (int n = 0; n < 36; n++) {
            System.out.println(arnRandomBombs[n]);
        }
        class ButtonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                //check the whole random array to see if the button we clicked matches with the rand
                //number

                for (int n = 0; n < arnRandomBombs.length; n++) {
                    if (event.getActionCommand().equals("" + arnRandomBombs[n])) {
                        
                        System.out.println("you hit a bomb at  " + arnRandomBombs[n]);
                    }
                }


                revalidate();
                setVisible(true);

            }
        }
        ActionListener buttonListener = new ButtonListener();
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                grid[x][y].addActionListener(buttonListener);
            }
        }

    }
}