package com.dev.Objects;

import java.util.List;

public class LoginResponse {
    private boolean success;
    private List<Mail> emails;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Mail> getEmails() {
        return emails;
    }

    public void setEmails(List<Mail> emails) {
        this.emails = emails;
    }
}
