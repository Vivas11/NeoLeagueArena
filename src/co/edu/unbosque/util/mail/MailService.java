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

/**
 * Servicio para el envío de correos electrónicos utilizando la cuenta oficial de NeoLeagueArena.
 * Permite crear y enviar mensajes de correo electrónico a través del protocolo SMTP de Gmail.
 * 
 */
public class MailService {
    /** Correo electrónico del remitente (cuenta oficial de NeoLeagueArena) */
    private static String emailFrom = "neoleaguearena.oficial@gmail.com";
    /** Contraseña de aplicación para el correo del remitente */
    private static String passwordFrom = "sxkdmauvnudfxxeh";
    /** Correo electrónico del destinatario */
    private String emailTo;
    /** Asunto del correo */
    private String subject;
    /** Contenido del correo */
    private String content;

    /** Sesión de correo utilizada para el envío */
    private Session mSession;
    /** Mensaje de correo a enviar */
    private MimeMessage mCorreo;
    
    /**
     * Constructor por defecto.
     */
    public MailService() {
    }
    
    /**
     * Crea el mensaje de correo electrónico con los parámetros especificados.
     * 
     * @param destinatario Correo electrónico del destinatario.
     * @param asunto Asunto del correo.
     * @param mensaje Contenido del correo.
     * @param prop Propiedades de configuración para la sesión SMTP.
     */
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
            // Manejo de error de dirección inválida
        } catch (MessagingException ex) {
            // Manejo de error de mensaje
        }
    }

    /**
     * Envía el correo electrónico previamente creado.
     * Muestra un mensaje de confirmación si el envío es exitoso.
     * En caso de error, registra la excepción en el log.
     */
    public void sendEmail() {
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom, passwordFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();
            
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(MailService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(MailService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}