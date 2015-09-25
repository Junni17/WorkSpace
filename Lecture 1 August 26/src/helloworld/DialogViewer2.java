package helloworld;

import javax.swing.JOptionPane;

public class DialogViewer2 {
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("What is your name?");
		JOptionPane.showInputDialog(null, "Hello " + name + ", what would you like me to do?");
		JOptionPane.showMessageDialog(null, "I'm sorry, " + name + ", I'm afraid I can't do that.");
	}
}
