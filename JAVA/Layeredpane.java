import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Layeredpane {
    public static void main(String[] args) {
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();

        JFrame frame = new JFrame();
        JLayeredPane layeredPane = new JLayeredPane();

        label1.setOpaque(true);
        label1.setBackground(Color.red);
        label1.setBounds(50, 50, 200, 200);

        label2.setOpaque(true);
        label2.setBackground(Color.green);
        label2.setBounds(100, 100, 200, 200);

        label3.setOpaque(true);
        label3.setBackground(Color.blue);
        label3.setBounds(150, 150, 200, 200);

        

        layeredPane.setBounds(0, 0, 500, 500);
        layeredPane.add(label1,Integer.valueOf(1));
        layeredPane.add(label2, Integer.valueOf(0));
        layeredPane.add(label3,Integer.valueOf(2));


        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.add(layeredPane);



        frame.setVisible(true);
    }
}
