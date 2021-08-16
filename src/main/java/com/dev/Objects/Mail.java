package com.dev.Objects;

public class Mail {
    private String sender;
    private String date;
    private String content;

    public Mail(String sender, String date, String content) {
        this.sender = sender;
        this.date = date;
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
