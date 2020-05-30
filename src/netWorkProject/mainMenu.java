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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ImageIcon;

public class mainMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainMenu frame = new mainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public mainMenu() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u8D26\u53F7");

		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");

		textField = new JTextField();
		textField.setColumns(10);
		JButton btnNewButton = new JButton("\u767B\u9646");
		btnNewButton.setFont(new Font("新宋体", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textField.getText();
				String str = passwordField.getText();
				Connection conn = null;
				PreparedStatement st = null;
				ResultSet rs = null;
				String sql = "select password from user where name like'" + s + "'";
				try {
					conn = jdbcUtil.getConnection();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					st = conn.prepareStatement(sql);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				try {
					rs = st.executeQuery(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String p = null;
				try {
					while (rs.next())
						p = rs.getString("password");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				boolean flag = str.equals(p);
				if (flag) {
					jdbcUtil.free(rs, st, conn);
					dispose();
					JFrame list= new List();
				   list.setVisible(true);
				   	
				} else {
					jdbcUtil.free(rs, st, conn);
					JOptionPane.showMessageDialog(null, "账号或密码有错误", "标题", JOptionPane.ERROR_MESSAGE);
				}
			}

		}

		);
		JButton btnNewButton_1 = new JButton("\u6CE8\u518C\u8D26\u53F7");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrame register = null;
				try {
					register = new register();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				register.setVisible(true);
			}
		});

		passwordField = new JPasswordField();

		JButton btnNewButton_2 = new JButton("\u627E\u56DE\u5BC6\u7801");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emailUpdate update=new emailUpdate();
				update.setVisible(true);
			}
		});
		btnNewButton_2.setForeground(Color.RED);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u81EA\u52A8\u767B\u5F55");

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u8BB0\u4F4F\u5BC6\u7801");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap().addComponent(btnNewButton_1)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(57)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 53,
														Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.UNRELATED))
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_1)
												.addGap(39)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(passwordField)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
				.addGap(121))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(81).addComponent(rdbtnNewRadioButton).addGap(12)
						.addComponent(rdbtnNewRadioButton_1).addGap(18).addComponent(btnNewButton_2)
						.addContainerGap(88, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(114, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(14)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(10)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(rdbtnNewRadioButton)
										.addComponent(rdbtnNewRadioButton_1).addComponent(btnNewButton_2))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 45,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)));
		
		contentPane.setLayout(gl_contentPane);
	}
	
}
