package simple;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatorGuiDemo {

	private JFrame frmCalculator;
	private JTextField firstText;
	private JTextField secondText;
	private JTextField restultText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorGuiDemo window = new CalculatorGuiDemo();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculatorGuiDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.getContentPane().setForeground(Color.DARK_GRAY);
		frmCalculator.getContentPane().setBackground(Color.WHITE);
		frmCalculator.getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 14));
		frmCalculator.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\zWork\\JavaD\\Java2021\\src\\demo\\swing\\naruto.png"));
		frmCalculator.setTitle("Calculator");
		frmCalculator.setBounds(100, 100, 497, 411);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		
		JLabel firstNumberLabel = new JLabel("Enter the 1st number : ");
		firstNumberLabel.setBounds(72, 119, 172, 14);
		frmCalculator.getContentPane().add(firstNumberLabel);
		
		JLabel operationLabel = new JLabel("Operation : ");
		operationLabel.setBounds(72, 144, 119, 14);
		frmCalculator.getContentPane().add(operationLabel);
		
		JLabel secondNumberLabel = new JLabel("Enter the 2nd number : ");
		secondNumberLabel.setBounds(72, 169, 172, 14);
		frmCalculator.getContentPane().add(secondNumberLabel);
		
		JComboBox<String> selectionBox = new JComboBox<>();
		selectionBox.setModel(new DefaultComboBoxModel<String>(new String[] {"+", "-", "*", "/","%"}));
		selectionBox.setBounds(242, 140, 61, 22);
		frmCalculator.getContentPane().add(selectionBox);
		
		JLabel headingLabel = new JLabel("WELCOME TO AYAN'S CALCULATOR");
		headingLabel.setBackground(Color.DARK_GRAY);
		headingLabel.setForeground(SystemColor.textHighlight);
		headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headingLabel.setBounds(128, 27, 217, 47);
		frmCalculator.getContentPane().add(headingLabel);
		
		firstText = new JTextField();
		firstText.setBounds(232, 116, 86, 20);
		frmCalculator.getContentPane().add(firstText);
		firstText.setColumns(10);
		
		secondText = new JTextField();
		secondText.setBounds(232, 166, 86, 20);
		frmCalculator.getContentPane().add(secondText);
		secondText.setColumns(10);
		
		JButton resutlButton = new JButton("Result");
		resutlButton.setBounds(188, 282, 89, 23);
		resutlButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int num1 = Integer.parseInt(firstText.getText());
				int num2 = Integer.parseInt(secondText.getText());
				int result = 0;
				String select = selectionBox.getSelectedItem().toString();
				switch(select) {
				case "+": result = num1 + num2; break;
				case "-": result = num1 - num2; break;
				case "*": result = num1 * num2; break;
				case "/": result = num1 / num2; break;
				case "%": result = num1 % num2; break;
				default: break;
				}
				restultText.setText(String.valueOf(result));
			}
		});
		frmCalculator.getContentPane().add(resutlButton);
		
		restultText = new JTextField();
		restultText.setBounds(188, 228, 86, 20);
		frmCalculator.getContentPane().add(restultText);
		restultText.setColumns(10);
	}
	
	
	
	
}
