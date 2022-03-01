package db.prescriptions.assignment.Service;

import db.prescriptions.assignment.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Properties;

@Service
@Component
public class EmailService {

    @Autowired
    PersonRepository personRepository;

    //@Value("${spring.mail.host}")
    private String host = "smtp.gmail.com";
    //@Value("${spring.mail.port}")
    private int port = 587;
    //@Value("${spring.mail.username}")
    private String username = "patr180499@gmail.com";
    //@Value("${spring.mail.password}")
    private String password = "pa180499";



    public String sendSimpleMessage(String receiverMail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("DitApotek");
        message.setTo(receiverMail);
        message.setSubject("Udløbenderecipt");
        message.setText("Hej, + \n Dette er en påmindelse om at du har en recipt der udløber om 1 uge fra i dag.");
        try {
            getJavaMailSender().send(message);
            return "Mail successfully sent.";
        } catch (Exception e) {
            System.out.println("Error " + e);
            return "Error while sending mail.";
        }
    }

    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();


        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    //1:00 am every day
    //"0 1 0 * * ?"
    //"*/10 * * * * *"
    @Scheduled(cron = "0 1 0 * * ?")
    public void readDaily() {
        EmailService emailService = new EmailService();
        List<String> emailsToSend = personRepository.fetchEmailsWherePrescriptionExpireInOneWeek();

        emailService.sendSimpleMessage("patr5152@hotmail.com");
        emailService.sendSimpleMessage("cph-nt123@cphbusiness.dk");
        /*
        for (String emails : emailsToSend) {
            emailService.sendSimpleMessage(emails);
        }
        */
    }

}
