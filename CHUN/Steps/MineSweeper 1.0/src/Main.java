

import javax.swing.JFrame;





public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello");
        frame.add(new MainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
    }
}
