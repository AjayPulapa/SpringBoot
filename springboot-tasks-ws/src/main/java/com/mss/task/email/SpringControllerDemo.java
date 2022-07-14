package com.mss.task.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/email")
public class SpringControllerDemo {
    @Autowired 
    SpringServiceDemo ss;
    @GetMapping("/sendEmail")
    public String sendEmail()
    {
    	return ss.sendEmail();
    }
    
}
