package netWorkProject;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class SendMail {

	public static void main (String args [] )  throws Exception{
		
		Session session;
              Store store;
              String cc = null;   //������
              String bcc = null;  //����
              try {
                String sendHost = "192.168.56.1";     //�����ʼ�������
                String receiveHost = "192.168.56.1";  //�����ʼ�������
                String sendProtocol = "smtp";      //�����ʼ�Э��
                String receiveProtocol = "imap";   //�����ʼ�Э��
                String username = "1319478636@qq.com";
                String password = "****";
                String fromAddr = "1319478636@qq.com"; //�����ߵ�ַ
                String toAddr = "2951024832@qq.com"; //�����ߵ�ַ
                String subject = "Hello";
                String content = "Welcome to JavaMail";
                Properties props = new Properties ();
                props.put ("mail.transport.protocol",sendProtocol);
                props.put("mail.store.protocol",receiveProtocol);
                props.put("mail.smtp.class","com.sun.mail.smtp.SMTPTransport");
                props.put("mail.imap.class","com.sun.mail.imap.IMAPStore");
                props.put ("mail.smtp.host",sendHost);  //���÷����ʼ�������
                session = Session.getDefaultInstance (props,null);   //����ʼ��Ự����
                session.setDebug(true);  //���������־
                store = session.getStore(receiveProtocol);     //����Store����
                store.connect(receiveHost,username,password);  //���ӵ����ʼ�������
                Message msg = new MimeMessage(session);        //����һ���ʼ�����
                msg.setFrom(new InternetAddress(fromAddr));    //���÷�����
                if(toAddr!= null){                             //����������
                    msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toAddr));
                    }
               
                msg.setSubject(subject);       //�����ʼ�����
                msg.setText(content);          //�����ʼ�����
                msg.setSentDate(new Date());   //��������
                Transport.send(msg);           //�����ʼ�
                System.out.println("email send!");
                }
                catch (Exception ex){
                  ex.printStackTrace();
                  }
               }
}




		
		