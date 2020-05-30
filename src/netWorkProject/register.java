package netWorkProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public register() throws SQLException {
		setTitle("\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label = new JLabel("\u60A8\u597D\uFF0C\u8BF7\u5148\u6CE8\u518C");
		label.setForeground(new Color(255, 140, 0));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 16));

		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u60A8\u7684\u6635\u79F0\uFF084-10\u4F4D\uFF09");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 16));

		textField = new JTextField();
		textField.setColumns(10);

		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u60A8\u7684\u90AE\u7BB1");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 16));

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u60A8\u7684\u5BC6\u7801\uFF084-10\u4F4D\uFF09");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 16));

		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = textField.getText();
				String s2 = new String(passwordField.getPassword());
				String s3 = textField_1.getText();
				String reg1 = "\\w+@\\w+\\.com";
				boolean flag = s3.matches(reg1);
				if (flag) {
					Connection conn = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					String sql="insert into user values(null,?,?,?)";
					try {
						conn = jdbcUtil.getConnection();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						ps =  conn.prepareStatement(sql);
						ps.setString(1, s1);
						ps.setString(2, s2);
						ps.setString(3, s3);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						int i= ps.executeUpdate();
						if(i==1) {
							JOptionPane.showMessageDialog(null, "×¢²á³É¹¦", 
									"±êÌâ", JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "Çë×ÐÏ¸ºË¶ÔÄúµÄÐÅÏ¢", 
									"±êÌâ", JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} finally {
					jdbcUtil.free(rs, ps, conn);
                    }
                    dispose();
                    
					
					JFrame mainMenu = null;
					try {
						mainMenu = new mainMenu();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					mainMenu.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Çë×ÐÏ¸ºË¶ÔÄúµÄÐÅÏ¢", 
							"±êÌâ", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrame mainMenu = null;
				try {
					mainMenu = new mainMenu();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				mainMenu.setVisible(true);
			}
		});

		passwordField = new JPasswordField();

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(167)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(195, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(66)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(label_1)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 213,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1))
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(222, Short.MAX_VALUE)
								.addComponent(button)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING,
										gl_contentPane.createSequentialGroup().addGap(18).addComponent(button_1)
												.addGap(213))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(51)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(passwordField, Alignment.LEADING)
												.addComponent(textField_1, Alignment.LEADING).addComponent(textField,
														Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 117,
														Short.MAX_VALUE))
										.addContainerGap(120, Short.MAX_VALUE)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(18).addComponent(label).addGap(32)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(
						textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(30)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label_1).addComponent(
						textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(27)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(88).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(button_1)
						.addComponent(button))
				.addGap(26)));
		contentPane.setLayout(gl_contentPane);
	}

}
