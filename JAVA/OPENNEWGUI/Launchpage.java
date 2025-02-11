package OPENNEWGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Launchpage implements ActionListener{
    JFrame frame = new JFrame();
    JButton button = new JButton();

    Launchpage (){
        button.setText("Click here");
        button.setBounds(100, 160, 100, 40);
        button.addActionListener(this);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.add(button);




        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        frame.dispose();
        new Newwindow();
    }
}
