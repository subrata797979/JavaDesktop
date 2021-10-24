package demo.swing;
import javax.swing.*;
import java.awt.event.*;

public class ClickCountingApp {
    public static void main(String args[]) {
        JButton button = new JButton("Button never pressed...");
        button.addActionListener(new ButtonListener());

        JFrame frame = new JFrame("Click Counting App");
        frame.getContentPane().add(button);
        frame.setSize(300, 80);
        frame.setVisible(true);
    }

    static class ButtonListener implements ActionListener {
        int timesPressed;

        @Override
        public void actionPerformed(ActionEvent event) {
            timesPressed++;
            JButton button = (JButton) event.getSource();
            button.setText("Times pressed: " + timesPressed);
        }
    }
}