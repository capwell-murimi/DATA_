import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		String name = JOptionPane.showInputDialog("Enter your Name");
		JOptionPane.showMessageDialog(null, "Hello "+name);
		
		
		int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your Age"));
		JOptionPane.showMessageDialog(null, "Capwell is"+age+" years old");
		
		
		double height = Float.parseFloat( JOptionPane.showInputDialog("What is your Height"));
		JOptionPane.showMessageDialog(null, "A "+age+" year old, "+name+" is "+height+" tall");
		
	}

}