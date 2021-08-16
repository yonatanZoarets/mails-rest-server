package com.dev.Objects;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;
    private String password;
    private List<Mail> mails;
    private double tellphone_num;

    public void addEmail (Mail email) {
        if (this.mails == null) {
            this.mails = new ArrayList<>();
        }
        this.mails.add(email);
    }

    public User(String username, String password, List<Mail> mails) {
        this.username = username;
        this.password = password;
        this.mails = mails;
        this.tellphone_num=0;
    }
    public User(String username, String password, List<Mail> mails,double tellphone_num) {
        this.username = username;
        this.password = password;
        this.mails = mails;
        this.tellphone_num=tellphone_num;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Mail> getMails() {
        return mails;
    }

    public void setMails(List<Mail> mails) {
        this.mails = mails;
    }
}
