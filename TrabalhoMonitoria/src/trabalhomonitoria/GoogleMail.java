/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhomonitoria;
import java.util.Properties;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author JonathamPetzolddeSou
 */
public class GoogleMail {


// Set up the SMTP server.
    public void sendMail(String messageMail, String destinatary, String subject){
            Properties props = new Properties();
            /** Parâmetros de conexão com servidor Gmail */
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication()
                             {
                                   return new PasswordAuthentication("jonatham.santos@uniriotec.br", "35234722");
                             }
                        });
            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("jonatham.santos@uniriotec.br")); //Remetente

                  Address[] toUser = InternetAddress //Destinatário(s)
                             .parse(destinatary);  

                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject(subject);//Assunto
                  message.setText(messageMail);
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);
                  Alert alert = new Alert (Alert.AlertType.INFORMATION, "E-mail enviado =)", ButtonType.OK);
                  alert.setHeaderText("Sucesso!");
                  alert.setTitle("Sucesso");
                  alert.showAndWait();
             } catch (MessagingException e) {
                  Alert alert = new Alert (Alert.AlertType.INFORMATION, "Não foi possível enviar o e-mail =(", ButtonType.OK);
                  alert.showAndWait();
                  throw new RuntimeException(e);
            }
    }
}
