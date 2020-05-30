package netWorkProject;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class SendMail {

	public static void main (String args [] )  throws Exception{
		
		Session session;
              Store store;
              String cc = null;   //抄送人
              String bcc = null;  //暗送
              try {
                String sendHost = "192.168.56.1";     //发送邮件服务器
                String receiveHost = "192.168.56.1";  //接收邮件服务器
                String sendProtocol = "smtp";      //发送邮件协议
                String receiveProtocol = "imap";   //接收邮件协议
                String username = "1319478636@qq.com";
                String password = "****";
                String fromAddr = "1319478636@qq.com"; //发送者地址
                String toAddr = "2951024832@qq.com"; //接收者地址
                String subject = "Hello";
                String content = "Welcome to JavaMail";
                Properties props = new Properties ();
                props.put ("mail.transport.protocol",sendProtocol);
                props.put("mail.store.protocol",receiveProtocol);
                props.put("mail.smtp.class","com.sun.mail.smtp.SMTPTransport");
                props.put("mail.imap.class","com.sun.mail.imap.IMAPStore");
                props.put ("mail.smtp.host",sendHost);  //设置发送邮件服务器
                session = Session.getDefaultInstance (props,null);   //获得邮件会话对象
                session.setDebug(true);  //输出跟踪日志
                store = session.getStore(receiveProtocol);     //创建Store对象
                store.connect(receiveHost,username,password);  //连接到收邮件服务器
                Message msg = new MimeMessage(session);        //创建一个邮件对象
                msg.setFrom(new InternetAddress(fromAddr));    //设置发言人
                if(toAddr!= null){                             //设置收信人
                    msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toAddr));
                    }
               
                msg.setSubject(subject);       //设置邮件主题
                msg.setText(content);          //设置邮件内容
                msg.setSentDate(new Date());   //发送日期
                Transport.send(msg);           //发送邮件
                System.out.println("email send!");
                }
                catch (Exception ex){
                  ex.printStackTrace();
                  }
               }
}




		
		