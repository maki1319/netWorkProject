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
		String string = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";//��������0-9 �� ��Сд��ĸ
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
		         mail.setHost("smtp.qq.com"); 			//�����ʼ�������,�������QQ�����,�Լ����ҿ���ص�  
		         mail.setPortNumber("465");   			//�����ʼ��������˿ں�,Ĭ��25
		         mail.setSender("3048026550@qq.com");   			//������
		         mail.setName("�²�");   					//�������ǳ�
		         mail.setReceiver(s); 			//������  
		         mail.setUsername("3048026550@qq.com"); 			//��¼�˺�,һ�㶼�Ǻ�������һ��
		         mail.setPassword("ftgzwkeqrmgjdfgj");  //QQ�����¼�������ͻ���ʱ,����������롰��Ȩ�롱������֤���������������鿴�ʼ���������˵��
		         mail.setSubject("����");  
		         String s2=getCode(4);
		         setCodeString(s2);
		         mail.setMessage("<h1 style=color:red >�����֤��Ϊ:"+s2+",��Ч��Ϊ5����</font></h1>");  
		         if (new MailUtil().send(mail)) {
		        	JOptionPane.showInternalMessageDialog(null,"���ͳɹ�", "pan", JOptionPane.INFORMATION_MESSAGE);
		        	dispose();
		        	updatePassword uppass=new updatePassword();
		        	uppass.setVisible(true);
				} else {
					JOptionPane.showInternalMessageDialog(null,"����ʧ��", "pan", JOptionPane.ERROR_MESSAGE);
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
