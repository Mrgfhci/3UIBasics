//Brett Fournier
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;

public class Quiz {

    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setBackground(Color.red);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class Frame extends JFrame {

    public Frame() {
        setTitle("Math Quiz");
        setSize(700, 600);
        PanMult panMult = new PanMult();
        add(panMult);
    }
}

class PanMult extends JPanel {

    public static JTextField txtAns = new JTextField(10);
    JLabel lblMult = new JLabel("Multiplication Quiz");
    JLabel lblCrrct = new JLabel();
    JLabel lblNum1 = new JLabel();
    JLabel lblNum2 = new JLabel();
    JLabel lblSign = new JLabel("x");
    JLabel lblScore = new JLabel();
    JLabel lblQstn = new JLabel();
    int nNum1 = (int) (Math.random() * 12 + 1);
    int nNum2 = (int) (Math.random() * 12 + 1);
    int i = 0;
    int nScore = 0;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(4));
        g2.setColor(Color.WHITE);
        g2.drawLine(200, 280, 340, 280); // draw the line
    }

    public PanMult() {
        TextFieldListener tfListener = new TextFieldListener();
        txtAns.addActionListener(tfListener);
        setBackground(Color.RED);
        setLayout(null);
        txtAns.setBounds(250, 300, 50, 40);
        add(txtAns);
        lblMult.setBounds(150, -10, 400, 100);
        lblMult.setFont(new Font("Serif", Font.PLAIN, 45));
        lblMult.setForeground(Color.WHITE);
        add(lblMult);
        lblSign.setBounds(200, 230, 50, 50);
        lblSign.setFont(new Font("Serif", Font.PLAIN, 45));
        lblSign.setForeground(Color.WHITE);
        add(lblSign);
        nNum1 = (int) (Math.random() * 12 + 1);
        nNum2 = (int) (Math.random() * 12 + 1);
        System.out.println(nNum1);
        System.out.println(nNum2);
        String sNum1, sNum2;
        sNum1 = Integer.toString(nNum1);
        sNum2 = Integer.toString(nNum2);
        lblNum1.setText(sNum1);
        lblNum1.setBounds(250, 70, 100, 100);
        lblNum1.setForeground(Color.WHITE);
        lblNum1.setFont(new Font("Serif", Font.PLAIN, 80));
        lblNum2.setText(sNum2);
        lblNum2.setBounds(250, 170, 100, 100);
        lblNum2.setForeground(Color.WHITE);
        lblNum2.setFont(new Font("Serif", Font.PLAIN, 80));
        lblQstn.setText("Question: 1");
        lblQstn.setBounds(10, 80, 210, 50);
        lblQstn.setForeground(Color.WHITE);
        lblQstn.setFont(new Font("Serif", Font.PLAIN, 40));
        add(lblNum1);
        add(lblNum2);
        add(lblQstn);
        i++;
    }

    public class TextFieldListener implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
             i++;
            String sNum = txtAns.getText();
            txtAns.setText("");
            int nNum = Integer.parseInt(sNum);
            lblCrrct.setBounds(200, 340, 600, 100);
            lblCrrct.setForeground(Color.WHITE);
            lblCrrct.setFont(new Font("Serif", Font.PLAIN, 50));
            lblScore.setForeground(Color.WHITE);
            lblScore.setBounds(150, 420, 500, 100);
            lblScore.setFont(new Font("Serif", Font.PLAIN, 60));
            lblQstn.setBounds(10, 80, 210, 50);
            lblQstn.setForeground(Color.WHITE);
            lblQstn.setFont(new Font("Serif", Font.PLAIN, 40));
            if (nNum == nNum1 * nNum2) {
                System.out.println("Correct");
                lblCrrct.setText("Correct");
                nScore++;
                add(lblCrrct);
            } else {
                System.out.println("Wrong");
                lblCrrct.setText("Wrong");
                add(lblCrrct);
            }
            if (i < 11) {
                nNum1 = (int) (Math.random() * 12 + 1);
                nNum2 = (int) (Math.random() * 12 + 1);
                System.out.println(nNum1);
                System.out.println(nNum2);
                String sNum1, sNum2;
                sNum1 = Integer.toString(nNum1);
                sNum2 = Integer.toString(nNum2);
                lblNum1.setText(sNum1);
                lblNum1.setBounds(250, 70, 100, 100);
                lblNum1.setForeground(Color.WHITE);
                lblNum1.setFont(new Font("Serif", Font.PLAIN, 80));
                lblNum2.setText(sNum2);
                lblNum2.setBounds(250, 170, 100, 100);
                lblNum2.setForeground(Color.WHITE);
                lblNum2.setFont(new Font("Serif", Font.PLAIN, 80));
                add(lblNum1);
                add(lblNum2);
                lblScore.setText("Score: " + nScore + "/" + 10);
                add(lblScore);
                lblQstn.setText("Question: "+i);
                add(lblScore);
            } else {
                System.out.println(nScore + "/" + 10);
                lblScore.setText("Final Score: " + nScore + "/" + 10);
                add(lblScore);
                txtAns.disable();
            }

        }
    }
}
