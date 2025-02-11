import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Labels {
    public static void main(String[] args) {
        JPanel whiteframe = new JPanel();
        JPanel redframe = new JPanel();
        JLabel label = new JLabel();
      //  JPanel blueframe = new JPanel();

        ImageIcon icon = new ImageIcon("C:\\Users\\CapwellTheNerd\\Desktop\\DATA_\\JAVA\\n" + //
                        "dovu.jpg");
        label.setText("Hello");
        label.setIcon(icon);


        
       /* whiteframe.setBackground(Color.GREEN);
        whiteframe.setVisible(true);
        whiteframe.setBounds(0, 0, 400, 400);
        whiteframe.add(new JLabel(icon));


        redframe.setBackground(Color.red);
        redframe.setBounds(400, 0, 400, 400);
        redframe.setVisible(true);

        blueframe.setBackground(Color.blue);
        blueframe.setBounds(800,0,400,400);
        blueframe.setVisible(true);*/

        JPanel blackFrame = new JPanel();
        JPanel greenFrame  = new JPanel();


        blackFrame.setBackground(Color.black);
        blackFrame.setBounds(0, 0, 600, 100);
        blackFrame.setVisible(true);

        whiteframe.setBackground(Color.white);
        whiteframe.setBounds(0, 100, 600, 30);
        whiteframe.setVisible(true);

        redframe.setBackground(Color.red);
        redframe.setBounds(0, 130, 600, 100);
        redframe.setVisible(true);

        whiteframe.setBackground(Color.white);
        whiteframe.setBounds(0, 230, 600, 30);
        whiteframe.setVisible(true);

        greenFrame.setBackground(Color.green);
        greenFrame.setBounds(0, 260, 600, 100);
        greenFrame.setVisible(true);
        greenFrame.add(label);





        JFrame frame = new JFrame();
        frame.setTitle("This is an Awesome title");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        //frame.getContentPane().setBackground(Color.white);
        frame.setSize(550,550);
        frame.setIconImage(icon.getImage());
        frame.add(blackFrame);
        frame.add(whiteframe);
        frame.add(redframe);
        frame.add(whiteframe);
        frame.add(greenFrame);
    }
}
