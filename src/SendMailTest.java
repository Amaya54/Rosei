import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendMailTest {
 
	public static void main(String[] args) {
 
		final String username = "kanha.prayas@gmail.com";
		final String password = "ramakantanayak";
 
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
			message.setFrom(new InternetAddress("kanha.prayas@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("haworang.abinash@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear FUCKER,"
				+ "GANDI THEORY WORKED WELL"+"gandi bhala rakhile kichi habani toki pata");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}