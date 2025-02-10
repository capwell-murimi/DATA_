package GUI;
import javax.swing.JFrame;
import java.awt.Color;

public class Gui extends JFrame{

    Gui(){
        //JFrame frame = new JFrame();
        this.setTitle("This is a title");
        this.setSize(250,250); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.GRAY);
    }
    
}
