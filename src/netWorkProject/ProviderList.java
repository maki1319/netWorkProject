package netWorkProject;

import javax.mail.*;
import javax.mail.internet.*;

public class ProviderList {

	public static void main(String args [])  throws Exception{
		
		
		Session mySession = Session.getDefaultInstance(System.getProperties (),null);
		Provider [] providerList = mySession.getProviders();
              for (int i = 0; i< providerList.length;i++){
              System.out.println("Protocol:" + providerList [i].getProtocol());
              if (providerList [i].getType () == Provider.Type.STORE)
              System.out.println("Provider type : STORE");
              else
                  System.out.println ("Provider type : TRANSPORT");
                  System.out.println ("Vendor :" + providerList [i].getVendor ());
                  }
              }
        }
