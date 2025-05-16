package co.edu.unbosque.util.mail;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


public class MailService {
    private static String emailFrom = "neoleaguearena.oficial@gmail.com";
    private static String passwordFrom = "sxkdmauvnudfxxeh";
    private String emailTo;
    private String subject;
    private String content;

    private Session mSession;
    private MimeMessage mCorreo;
    
    public MailService() {
	}
    
    public void createEmail(String destinatario, String asunto, String mensaje, Properties prop) {
        emailTo = destinatario;
        subject = asunto;
        content = mensaje;
        
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.setProperty("mail.smtp.starttls.enable", "true");
        prop.setProperty("mail.smtp.port", "587");
        prop.setProperty("mail.smtp.user",emailFrom);
        prop.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        prop.setProperty("mail.smtp.auth", "true");
        
        mSession = Session.getDefaultInstance(prop);
        
        
        try {
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            mCorreo.setSubject(subject);
            mCorreo.setText(content, "ISO-8859-1", "html");
                     
            
        } catch (AddressException ex) {
        } catch (MessagingException ex) {
        }
    }

    public void sendEmail() {
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom, passwordFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();
            
            JOptionPane.showMessageDialog(null, "Correo enviado");
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(MailService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(MailService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}