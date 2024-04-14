package goveg.domain.entity.bo;

import java.util.List;

public class PersonBO {

    private Long id;

    private String socialName;

    private String document;

    private String email;

    private String phoneNumber;

    private UserBO user;

    private List<AddressBO> address;

    public PersonBO(Long id, String socialName, String document, String email, String phoneNumber, UserBO user,
            List<AddressBO> address) {
        this.id = id;
        this.socialName = socialName;
        this.document = document;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.user = user;
        this.address = address;
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

    public UserBO getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }

    public List<AddressBO> getAddress() {
        return address;
    }
}