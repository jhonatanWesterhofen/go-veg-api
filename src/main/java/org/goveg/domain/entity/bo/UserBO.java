package org.goveg.domain.entity.bo;

import org.goveg.domain.vo.UuidVO;

public class UserBO {

    private UuidVO id;

    private String document;

    private String password;

    private String confirmationPass;

    private String createdAt;

    public UserBO(UuidVO id, String document, String password, String confirmationPass, String createdAt) {
        this.id = id;
        this.document = document;
        this.password = password;
        this.confirmationPass = confirmationPass;
        this.createdAt = createdAt;
    }

    public UuidVO getId() {
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