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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Random;
import java.awt.event.ActionEvent;

public class emailUpdate extends JFrame implements Serializable {

	private JPanel contentPane;
	private JTextField textField;
    public static String getEmialString() {
		return emialString;
	}

	public void setEmialString(String emialString) {
		this.emialString = emialString;
	}

	public static String getCodeString() {
		return codeString;
	}

	public void setCodeString(String codeString) {
		this.codeString = codeString;
	}
	private static String emialString;
    private static String codeString;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					emailUpdate frame = new emailUpdate();
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
	public static String getCode(int n) {
		String string = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";//保存数字0-9 和 大小写字母
		char[] ch = new char[n]; 
		for (int i = 0; i < n; i++) {
			Random random = new Random();
			int index = random.nextInt(string.length());
			ch[i] = string.charAt(index);
		}
		
		String result = String.valueOf(ch);
		return result;

	}
	public emailUpdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u4F60\u7684\u90AE\u7BB1");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=textField.getText();
				setEmialString(s);
				Mail mail = new Mail();  
		         mail.setHost("smtp.qq.com"); 			//设置邮件服务器,如果不用QQ邮箱的,自己找找看相关的  
		         mail.setPortNumber("465");   			//设置邮件服务器端口号,默认25
		         mail.setSender("3048026550@qq.com");   			//发送人
		         mail.setName("陈博");   					//发送人昵称
		         mail.setReceiver(s); 			//接收人  
		         mail.setUsername("3048026550@qq.com"); 			//登录账号,一般都是和邮箱名一样
		         mail.setPassword("ftgzwkeqrmgjdfgj");  //QQ邮箱登录第三方客户端时,密码框请输入“授权码”进行验证。其他的密码具体查看邮件服务器的说明
		         mail.setSubject("标题");  
		         String s2=getCode(4);
		         setCodeString(s2);
		         mail.setMessage("<h1 style=color:red >你的验证码为:"+s2+",有效期为5分钟</font></h1>");  
		         if (new MailUtil().send(mail)) {
		        	JOptionPane.showInternalMessageDialog(null,"发送成功", "pan", JOptionPane.INFORMATION_MESSAGE);
		        	dispose();
		        	updatePassword uppass=new updatePassword();
		        	uppass.setVisible(true);
				} else {
					JOptionPane.showInternalMessageDialog(null,"发送失败", "pan", JOptionPane.ERROR_MESSAGE);
				} 
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(81)
					.addComponent(lblNewLabel)
					.addGap(38)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(52, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(171, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(162))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(83)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(37))
		);
		contentPane.setLayout(gl_contentPane);
	}



}
