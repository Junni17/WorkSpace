package helloworld;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class E1_17 {
	public static void main(String[] args) throws Exception {
		URL imageLocation = new URL(
				"http://www.designsnext.com/wp-content/uploads/2014/09/funny-pictures-tumblr-gif-2.gif");
		JOptionPane.showMessageDialog(null, "How are we all doing?", "SMMMOOOOKIN'", JOptionPane.PLAIN_MESSAGE,
				new ImageIcon(imageLocation));
	}
}
