package minesweeper;

import javax.swing.JFrame;


public class MinesweeperMain {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ray's Minesweeper");
        frame.add(new panMain());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        
    }
}
