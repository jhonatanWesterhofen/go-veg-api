package org.goveg.domain.entity.bo;

public class UserBO {

    private String id;

    private String document;

    private String password;

    private String confirmationPass;

    private String createdAt;

    public String getId() {
        return id;
    }

    public String getDocument() {
        return document;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmationPass() {
        return confirmationPass;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}