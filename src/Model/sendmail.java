package Model;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.*;
public class sendmail{
	 Connection currentCon = null;
	

	public  String getName(String messid)
	{
		String mname=null;
		  PreparedStatement stmt3=null;
		  ResultSet rs2=null;
		  
		  try
		  {

				ConnectionManager cm=new ConnectionManager();
							currentCon = cm.getConnection();
			
		  
		  
		  String msql="select name from prayas.login where id='"+messid+"'";
	      stmt3=currentCon.prepareStatement(msql);
	      rs2=stmt3.executeQuery();
	      
	      while ( rs2.next() ) {
	          mname=rs2.getString(1);
	          }}
		   catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally {
			        try {
			            
			           
			            
			            if(currentCon != null)
			                currentCon.close();
			        } catch (SQLException e) {}
			  
		 }
		  return mname;
	}
	
	
	public  void sendrecharge(BeanRecharge br) {
 
		final String username = "amarosei13@gmail.com";
		final String password = "iiit@amarosei_2013";
		String mn=br.getMessName();
		String dt=br.getDate();
		 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("amarosei13@gmail.com"));
			
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(br.getStudentId()+"@iiit-bh.ac.in"));
			
			
			
			message.setSubject("RECHARGE INFORMATION:"+dt);
			message.setText("YOU HAVE RECHARGED at time "+dt+"\n at "+mn+" \nwith an amount: Rs."+br.getAmount()+".00");
 
			Transport.send(message);
 
			System.out.println("\nDone email");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	public void sendissue(String bid,String stdid,String messid,double bprice,double lprice,double dprice,double totalprice)
	{
		final String username = "amarosei13@gmail.com";
		final String password = "iiit@amarosei_2013";
		
		 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
		 
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		   //get current date time with Date()
		   Date date = new Date();
		   
	    String t1=dateFormat.format(date);
	    String mn=getName(messid);
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("amarosei13@gmail.com"));
			
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(stdid+"@iiit-bh.ac.in"));
			
			
			
			message.setSubject("ISSUE INFORMATION:"+t1);
			message.setText("You have booked at time "+t1+" at "+mn+" with an amount of Rs."+totalprice+" \n Total breakfast amount: Rs."+bprice+" \n Total lunch amount: Rs."+lprice+" \n Total dinner amount: Rs."+dprice);
 
			Transport.send(message);
 
			System.out.println("\nDone email");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
		
	}

}