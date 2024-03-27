package org.goveg.domain.entity.bo;

import org.goveg.domain.entity.dto.UserDTO;

public class PersonBO {

    private String id;

    private String socialName;

    private String document;

    private String email;

    private String phoneNumber;

    private UserDTO user;

    public String getId() {
        return id;
    }

    public String getSocialName() {
        return socialName;
    }

    public String getDocument() {
        return document;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserDTO getUser() {
        return user;
    }

}
