
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panButtons extends JPanel // panel definition
{
//create buttons
    private JButton btnRight;
    private JButton btnLeft;
    private JButton btnUp;
    private JButton btnDown;
    int dX = 200, dY = 300;


    public panButtons() {
        setLayout(new BorderLayout());

        btnRight = new JButton("Move Right");
        btnRight.setName("Right");
        btnLeft = new JButton("Move Left");
        btnLeft.setName("Left");
        btnUp = new JButton("Move Up");
        btnUp.setName("Up");
        btnDown = new JButton("Move Down");
        btnDown.setName("Down");
        add(btnRight, BorderLayout.EAST);
        add(btnLeft, BorderLayout.WEST);
        add(btnUp, BorderLayout.NORTH);
        add(btnDown, BorderLayout.SOUTH);
//make buttons work        
        class DrawRect implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                if (event.getActionCommand().equals("Move Right")) {
                    dX += 8;
                    System.out.println("Move Left");

                } else if (event.getActionCommand().equals("Move Left")) {
                    dX -= 8;
                    System.out.println("Move Left");
                }
                if (event.getActionCommand().equals("Move Up")) {
                    dY -= 8;
                    System.out.println("Move Up");
                } else if (event.getActionCommand().equals("Move Down")) {
                    dY += 8;
                    System.out.println("Move Down");
                }


                revalidate();
                setVisible(true);

            }
        }
        ActionListener drawRect = new DrawRect();
        btnRight.addActionListener(drawRect);
        btnLeft.addActionListener(drawRect);
        btnUp.addActionListener(drawRect);
        btnDown.addActionListener(drawRect);
    }

    public int getdX() {
        return dX;

    }

    public int getdY() {

        return dY;
    }
}