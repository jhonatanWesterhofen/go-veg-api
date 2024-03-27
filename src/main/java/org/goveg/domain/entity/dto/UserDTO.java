package org.goveg.domain.entity.dto;

public class UserDTO {

    private String id;

    private String document;

    private String password;

    private String confirmationPass;

    private String createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmationPass() {
        return confirmationPass;
    }

    public void setConfirmationPass(String confirmationPass) {
        this.confirmationPass = confirmationPass;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
