package com.mineSweeper.domainLayer.service;

/**
 * Created by qiaorui on 1/14/15.
 */

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SvEmail {

    final private String username = "lab.xiang@gmail.com";
    final private String password = "Ox175188263";
    private String receiver;
    private String text;

    /**
     * SvEmail
     * Crea una instancia del servicio de mensajeria
     */
    public SvEmail(){
    }

    /**
     * SvEmail
     * Crea una instancia el servicio de mensajeria dado un
     * destinatario y un mensaje
     * @param receiver Direccion de email del destinatario
     * @param text Texto del mensaje a enviar
     */
    public SvEmail(String receiver, String text){
        this.receiver = receiver;
        this.text = text;
    }

    /**
     * getReceiver
     * @return Direccion de correo electronico del receptor del mensaje
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * setReceiver
     * @param receiver Asigna una dirección de correo al destinatario
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * getText
     * @return Texto del mensaje
     */
    public String getText() {
        return text;
    }

    /**
     * setText
     * @param text Asigna un valor al texto del mensaje
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * enviar
     * Envia un email al destinatario con el texto asignado
     */
    public void enviar() {
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
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(receiver));
            message.setSubject("MineSweeper");
            message.setText(text);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
