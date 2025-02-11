import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Flowlayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));


        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(100,250));
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.gray);



        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        panel.add(new JButton("7"));
        panel.add(new JButton("8"));
        panel.add(new JButton("9"));
        panel.add(new JButton("10"));


        frame.add(panel);
        frame.setVisible(true);
    }
}
