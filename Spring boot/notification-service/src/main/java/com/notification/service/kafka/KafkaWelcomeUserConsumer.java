package com.notification.service.kafka;

import com.notification.service.dto.UserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import static com.notification.service.util.CommonUtil.GROUP_ID;
import static com.notification.service.util.CommonUtil.USER_TOPIC;

@Service
@Slf4j
public class KafkaWelcomeUserConsumer {

    private final JavaMailSender mailSender;

    public KafkaWelcomeUserConsumer(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @KafkaListener(topics = USER_TOPIC, groupId = GROUP_ID)
    public void welcomeUserEmailConsumer(UserDetails user) {
        log.info("Received Object : {}",user);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@gmail.com");
        message.setTo(user.getEmail());
        message.setSubject("Welcome");
        message.setText("Welcome to our e-commerce website, Thank you for registration.");
        mailSender.send(message);
        log.info("Mail Send completed Successfully | Email : {}",user.getEmail());
    }

}
