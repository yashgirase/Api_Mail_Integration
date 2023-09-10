package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

@RestController
public class Controller {

    @Autowired
    private MyObject myObject;





    @GetMapping("GetObj")
    public String ApiToMail(){
        String myObjAsString = myObject.toString();
        MailManagement mailManagement = new MailManagement();
        MimeMessage mailMessage = new MimeMessage((Session) null);
        try {
            mailMessage.setSubject("Sending object via Java Code");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        try {
            mailMessage.setText(myObjAsString);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


        mailManagement.sendMail();
        return myObjAsString;
    }

}

