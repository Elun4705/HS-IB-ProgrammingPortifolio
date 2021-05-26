/**
* The EmailReporter class sends info through email for
* logs and reports so that we can monitor the system
*
* @author  Joseph Wardle, Tyler Roache
* @version 1.0
* @since   2020.12.02
*/

// This only works when both the JAF and Java mail APi are within the file classpath. I can do it in Eclipse, but nowhere else.

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailReporter {

	//Given that what we are doing is soley STMP Server, this is final
	private final String host = "smtp.gmail.com";
	private final String from = "smtp@gmail.com";

	private String Recipient = "";
	private String username = "";
	private String password = "";
	private String header = "";
	private String bodyText = "";


	// Sets the address of the email
	public EmailReporter(String to) {
		Recipient = to;
	}

	// This method sets in the authentication for the email
	public void SetUserAndPass(String user, String pass) {
		username = user;
		password = pass;
	}

	// This method creates the header of the email text
	public void setSubject(String header) {
		this.header = header;
	}

	// This method creates the body of the email text
	public void setMessage(String body) {
		bodyText = body;
	}

	public void SendEmail() {
		 Properties props = new Properties();
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.smtp.host", host);
		    props.put("mail.smtp.port", "587");

		    Session session = Session.getInstance(props,
		    	      new javax.mail.Authenticator() {
		    	         protected PasswordAuthentication getPasswordAuthentication() {
		    	            return new PasswordAuthentication(username, password);
		    	         }
		    	      });
		    try {
		         // Create a default MimeMessage object.
		         Message message = new MimeMessage(session);

		         // Set From: header field of the header.
		         message.setFrom(new InternetAddress(from));

		         // Set To: header field of the header.
		         message.setRecipients(Message.RecipientType.TO,
		         InternetAddress.parse(Recipient));
		         message.setSubject(header);
		         message.setText(bodyText);
		         Transport.send(message);

		      } catch (MessagingException e) {
		            throw new RuntimeException(e);
		      }
	}

}
