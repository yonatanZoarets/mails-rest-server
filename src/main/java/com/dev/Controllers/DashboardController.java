package com.dev.Controllers;

import com.dev.Objects.LoginResponse;
import com.dev.Objects.Mail;
import com.dev.Objects.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@RestController
public class DashboardController {

    private List<User> users = new ArrayList<>();


    @PostConstruct
    public void init () {
        System.out.println("This is init method");
        Mail m1 = new Mail("Oren", "20-1-21", "Hi");
        Mail m2 = new Mail("Ilana", "10-1-21", "Hi2");
        List<Mail> mailList = new ArrayList<>();
        mailList.add(m1);
        mailList.add(m2);
        users.add(new User("Shai", "1111", mailList));
        users.add(new User("Daniel", "5678", null));
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public Object login (String username, String password) {
        LoginResponse response = new LoginResponse();
        if (username != null && password != null) {
            User matchedUser = getUser(username, password);
            if (matchedUser != null) {
                response.setSuccess(true);
                response.setEmails(matchedUser.getMails());
            }
        }
        return response;
    }
    @RequestMapping(value = "/get-emails", method = RequestMethod.GET)
    public Object getEmails(String username, String password) {
        return getUser(username,password).getMails();
    }

    @RequestMapping(value = "/send-email", method = {RequestMethod.POST})
    public Object sendEmail (String sender, String recipientName, String content) {
        boolean success = false;
        User recipient = getUserByRecipientName(recipientName);
        if (recipient != null) {
            Mail newEmail = new Mail(sender, "1-1-2021", content);
            recipient.addEmail(newEmail);
            success = true;
        } else {
            System.out.println("There is no such user");
        }

        System.out.println(sender+" "+recipientName+" "+content+" "+success);
        return success;
    }

    @RequestMapping(value = "/create-user", method = {RequestMethod.POST})
    public void createUser(String name,String password) {
        if (getUserByRecipientName(name) == null) {
            users.add(new User(name, password, null));
            System.out.println("success "+users.get(users.size()-1).getUsername());
        }
    }
//    @RequestMapping(value = "/reset-password", method = {RequestMethod.POST})
    protected void resetPassword(User user,String newPassword) {
        user.setPassword(newPassword);
    }
    @RequestMapping(value = "/verification-code", method = {RequestMethod.GET})
    public void verificationCode(String newPassword) {

    }
    public User getUser (String username, String password) {
        User matchedUser = null;
        for (User user : this.users) {
            if (user.getPassword().equals(password) && user.getUsername().equals(username)) {
                matchedUser = user;
                break;
            }
        }
        return matchedUser;
    }

    public User getUserByRecipientName (String recipientName) {
        User recipient = null;
        for (User user : this.users) {
            if (user.getUsername().equals(recipientName)) {
                recipient = user;
                break;
            }
        }
        return recipient;
    }
    @RequestMapping(value = "/user-exist", method = {RequestMethod.GET})
    public Object existUser(String userName){
        LoginResponse response=new LoginResponse();
        User recipt=getUserByRecipientName(userName);
        if (recipt!=null) {
            response.setSuccess(true);
            response.setEmails(recipt.getMails());
        }
        return response;

    }



}
