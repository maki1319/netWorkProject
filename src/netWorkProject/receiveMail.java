package netWorkProject;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.io.*;

public class receiveMail {

	public static void main (String [] args ) {
         Properties props = new Properties ();
         String receiveHost = "192.168.56.1";  //接收邮件服务器
         String username = "1319478636@qq.com";
         String password = "chen201419";
         String provider = "pop3";
         try {
          /*连接到POP3服务器*/
          Session session = Session.getDefaultInstance (props,null);
          Store store = session.getStore(provider);
          store.connect(receiveHost,username,password);
          /*打开邮件夹*/
          Folder folder = store.getFolder("inbox");
          if (folder == null){
            System.out.println("No Inbox");
            System.exit(1);
            }
          folder.open(Folder.READ_ONLY);
          System.out.println("You have"+folder.getMessageCount()+"messages in Inbox.");
          System.out.println("You have"+folder.getUnreadMessageCount()+"unread messages in Inbox.");
          /*获取服务器的邮件消息*/
         Message[] messages = folder.getMessages();
         for(int i = 0;i < messages.length;i++){
         System.out.println("----------Message" + (i+1) + "----------");
         messages[i].writeTo(System.out);
         }
        /*关闭连接*/
        folder.close(false);
        store.close();  
      }
      catch (Exception ex){
      ex.printStackTrace();
      }
      }
    } 




