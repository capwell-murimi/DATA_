package OPENNEWGUI;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Newwindow {
    JFrame frame = new JFrame();
    JLabel label = new JLabel();

    Newwindow(){

        label.setText("HELLO");
        label.setFont(new Font("Sans Seriff",Font.BOLD,25));
        label.setBounds(0, 0, 100, 50);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(label);

    }
}
