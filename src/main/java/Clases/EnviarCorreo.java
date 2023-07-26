package Clases;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Set;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;


public class EnviarCorreo {

    public  void main(String CorreoDestino) throws MessagingException {
        final String userName = "aroblesc14@gmail.com"; //same fromMail
        final String password = "zfewqqtavpvmkyrj";
        final String toEmail = CorreoDestino;
        
        

        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        //props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        // props.put("mail.smtp.ssl.enable", "true");
        // props.put("mail.smtp.socketFactory.port", "587"); //TLS Port

        //Session session = Session.getDefaultInstance(props);
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(userName, password);

            }
        });
         BodyPart texto= new MimeBodyPart();  
        texto.setText("Gusto en saludarte Estimad@ Docente, se envía su Boleta de Pago. Colegio Villa America siempre a tu lado...");
         BodyPart adjunto= new MimeBodyPart();  
          adjunto.setDataHandler(new DataHandler(new FileDataSource("C:\\Users\\apsenior\\Downloads\\ProyectoCasiCasiFinal\\SendMailBasic_Maven-main\\Boleta.pdf")));
         adjunto.setFileName("Boleta.pdf");
          MimeMultipart m= new MimeMultipart();
          m.addBodyPart(texto);
          m.addBodyPart(adjunto);

        try{
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail, true));
            message.setSubject("Villa America - Boleta de Pago");
           // message.setText("Blablabla");
            message.setContent(m);
            
            System.out.println("sending...");
            Transport.send(message);
            System.out.println("Sent message successfully....");

        }catch (MessagingException me){
            System.out.println("Exception: "+me);

        }
    }
}
