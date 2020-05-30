package netWorkProject;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class ClientTalkDialog extends JFrame {
	private Socket client;
	private BufferedReader reader;
	private BufferedWriter writer;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientTalkDialog frame = new ClientTalkDialog();
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
	public ClientTalkDialog() {
		String ip="localhost";
		String port="5555";

		try {
			client=new Socket(ip, Integer.parseInt(port));
			writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setTitle("好友");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 397, 214);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 249, 397, 139);
		contentPane.add(scrollPane_1);

		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);

		JButton btnSend = new JButton("发送");
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String message=textArea_1.getText();
				textArea.append(" 我"+new Date().toLocaleString()+":\r\n"+message+"\r\n\r\n");
				textArea_1.setText("");
				try {
					writer.write(message);
					writer.newLine();
					writer.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
         }
		});
		btnSend.setBounds(211, 425, 93, 23);
		contentPane.add(btnSend);

		JButton btnClose = new JButton("取消");
		btnClose.setBounds(314, 425, 93, 23);
		contentPane.add(btnClose);
        btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea_1.setText("");
			}
		});
		new Thread() {

				public void run() {
					while(true) {
						try {
							String message=reader.readLine();
							textArea.append("好友"+new Date().toLocaleString()+":\r\n"+message+"\r\n\r\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				};
			}.start();
	}
}
