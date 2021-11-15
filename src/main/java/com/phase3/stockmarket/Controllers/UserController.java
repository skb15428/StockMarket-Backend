package com.phase3.stockmarket.Controllers;

import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.phase3.stockmarket.Entities.User;
import com.phase3.stockmarket.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserRepository userrepo;

    // @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/setuser", method = RequestMethod.GET)
    public String Stringreactuserapi(@RequestParam Map<String, String> userobj)
            throws AddressException, MessagingException {
        User usr = new User();

        usr.setname(userobj.get("name"));
        usr.setpassword(userobj.get("password"));
        usr.setemail(userobj.get("email"));

        userrepo.save(usr);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "UserController");
        headers.add("Access-Control-Allow-Origin", "*");
        sendemail(usr);
        return userobj.toString();
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/signinuser", method = RequestMethod.GET)
    public String userSignin(@RequestParam Map<String, String> userobj) {
        String email = userobj.get("email");
        String pass = userobj.get("password");

        User user = userrepo.signin(email, pass);

        if (user == null) {
            return "invalid";
        } 
        else {
            if (user.getAdmin() != null && user.getAdmin() != false) {
                return "admin";
            }
            else
            {
                return "user";
            }
        }
    }

    public void sendemail(User usr) throws AddressException, MessagingException {

        final String username = "stockmarketpro99@gmail.com";
        final String password = "stock@123";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); // TLS
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2"); // TLS

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("stockmarketpro99@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(usr.getemail()));
            message.setSubject("User confirmation email");
            // message.setText("Dear Mail Crawler,"
            // + "\n\n Please do not spam my email!");
            message.setContent(
                    "<h1><a href =\"http://127.0.0.1:9090/confirmuser/" + usr.getId() + "/\"> Click to confirm </a></h1>",
                    "text/html");
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/confirmuser/{userid}", method = RequestMethod.GET)
    public String welcomepage(@PathVariable Long userid) {
        User usr = new User();
        usr = userrepo.getById(userid);
        usr.setConfirmed(true);
        userrepo.save(usr);
        return "User confirmed " + usr.getname();
    }

}

