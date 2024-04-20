package goveg.domain.entity.bo;

import java.util.List;

import goveg.domain.validate.ValidadeDocument;

public class PersonBO {

    private Long id;

    private String socialName;

    private String cpf;

    private String cnpj;

    private String email;

    private String phoneNumber;

    private UserBO user;

    private List<AddressBO> address;

    public PersonBO(Long id, String socialName, String cpf, String cnpj, String email, String phoneNumber, UserBO user,
            List<AddressBO> address) {
        this.id = id;
        this.socialName = socialName;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.user = user;
        this.address = address;

        validate(cpf);
        validate(cnpj);
    }

    public String getSocialName() {
        return socialName;
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

    public String getCpf() {
        return cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void validate(String str) {
        ValidadeDocument validador = new ValidadeDocument();
        validador.validate(str);
    }
}