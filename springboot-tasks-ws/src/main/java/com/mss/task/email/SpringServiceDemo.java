package com.mss.task.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SpringServiceDemo {
      @Autowired
      private JavaMailSender mailSender;
      public String sendEmail()
      {
    	  SimpleMailMessage message = new SimpleMailMessage();
    	  message.setFrom("ajaypulapa@gmail.com");
    	  message.setTo("nshaikh@miraclesoft.com");
    	  message.setText("Mail Sent Through SpringBoot Application Successfully  \nThank You");
    	  message.setSubject("Spring Boot Email Task");
    	  mailSender.send(message);
    	  return "Mail Sent Suucessfully";

    	  
      }
}
