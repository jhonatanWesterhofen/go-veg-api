package goveg.domain.entity.bo;

public class PersonBO {

    private Long id;

    private String socialName;

    private String document;

    private String email;

    private String phoneNumber;

    private UserBO user;

    private AddressBO address;

    public PersonBO(Long id, String socialName, String document, String email, String phoneNumber, UserBO user,
            AddressBO address) {
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

    public AddressBO getAddress() {
        return address;
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

}