package BUTTONS;
import java.awt.Font;

import javax.swing.JButton;

public class Button extends JButton{
    Button(){
        this.setBounds(100, 100, 200, 50);
        this.setText("I am a button");
        this.setFont(new Font("sans serrif", Font.BOLD, 25));
    }
}
