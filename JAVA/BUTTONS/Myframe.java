package BUTTONS;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Myframe extends JFrame implements ActionListener{
    Button button;
    JLabel label;

    Myframe(){
        label = new JLabel();
        label.setText("This is a label");
        label.setBounds(0,0,200,100);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Comic Sans", Font.BOLD,15));
        label.setVisible(false);

        button = new Button();
        button.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,500);
        this.setVisible(true);
        this.add(button);
        this.add(label);
    }

    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button){
            //System.out.println("poo");
            label.setVisible(true);
        }
    }
}
