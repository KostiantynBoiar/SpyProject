package SpyCode.SendMail;


import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
    public static void main(String[] args) throws MessagingException {

        String host = "smtp.gmail.com";
        String from = "kostya20041234@gmail.com";
        String to = "opezdalya@gmail.com";

// Set properties
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl", "true");
        props.put("mail.debug", "true");

// Get session
        Session session = Session.getInstance(props);

        try {
            // Instantiate a message
            Message msg = new MimeMessage(session);

            // Set the FROM message
            msg.setFrom(new InternetAddress(from));

            // The recipients can be more than one so we use an array but you can
            // use 'new InternetAddress(to)' for only one address.
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);

            // Set the message subject and date we sent it.
            msg.setSubject("Email from JavaMail test");
            msg.setSentDate(new Date());

            // Set message content
            msg.setText("This is the text for this simple demo using JavaMail.");

            // Send the message
            Transport.send(msg);
        }
        catch (MessagingException mex) {
            mex.printStackTrace();
        }


    }
}
