package edu.fst.m2.ipii.carpooling.service.impl;

import edu.fst.m2.ipii.carpooling.service.EmailService;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by Dimitri on 14/04/2015.
 */
public class EmailServiceImpl implements EmailService {

    private MailSender mailSender;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }


    @Override
    public void envoyer(String from, String to, String subject, String msg) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(msg);
        // mailSender.send(message); // A décommenter une fois les infos de connexion fournies
    }
}
