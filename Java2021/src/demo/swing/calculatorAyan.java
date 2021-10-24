package demo.swing;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class calculatorAyan {

	public static void main(String[] args) {
		JFrame 	frame = new JFrame();
		frame.setTitle("Ayan's Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(300,300);
		frame.setVisible(true);
		
		ImageIcon image = new ImageIcon(System.getProperty("user.dir")+"\\src\\demo\\swing\\naruto.png");
		frame.setIconImage(image.getImage());
		frame.getContentPane().setBackground(new Color(0xB0C4DE));  //Hex value or Color(255,255,255) RGB code
	}
}
