package birthdayGui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class DateStoreGui {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateStoreGui window = new DateStoreGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection con = null;
	public DateStoreGui() {
		con = DbConnector.dbCon();
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(220, 220, 220));
		frame.setResizable(false);
		frame.setBounds(100, 100, 610, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Date Store GUI");
		lblNewLabel.setForeground(new Color(248, 248, 255));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(119, 136, 153));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(227, 11, 119, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 70, 536, 334);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Read");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					ResultSet rs = stmt.executeQuery("select * from users order by id asc");
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(146, 415, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement pst2 = con.prepareStatement("delete from users where id =?");
					int column = 0;
					int row = table.getSelectedRow();
					int value = Integer.parseInt(table.getModel().getValueAt(row, column).toString());
					pst2.setInt(1, value);
					int rowD = pst2.executeUpdate();
					JOptionPane.showMessageDialog(null, rowD + " record deleted with id : " + value);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(344, 415, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = 0;
					int column = 0;
					row = table.getSelectedRow();
					column = table.getSelectedColumn();
					if(row==0 && column==0) {
						JOptionPane.showMessageDialog(null, "Nothing is updated!");
					}
					else {
						int id = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
						String value = table.getModel().getValueAt(row, column).toString();
						String field = table.getColumnName(column);
						Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
						if(field.equalsIgnoreCase("name") || field.equalsIgnoreCase("birthday")) {
							int rowU = stmt.executeUpdate("update users set "+field+"='"+value+"' where id ="+id);
							JOptionPane.showMessageDialog(null, rowU + " row updated with field : " + field + " and value : " + value);
						}
						else {
							JOptionPane.showMessageDialog(null, "Selected row is not updatable!");
						}
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(245, 415, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
