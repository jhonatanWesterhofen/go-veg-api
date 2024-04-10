package goveg.infra.database.panache.model;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "GV_PERSON")
public class PanachePerson extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "ID_PERSON", sequenceName = "GEN_GV_PERSON", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PERSON")
    @Column(name = "ID", nullable = false, precision = 0, scale = -127)
    private Long id;

    @Column(name = "SOCIAL_NAME")
    private String socialName;

    @Column(name = "DOCUMENT", unique = true)
    private String document;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @JoinColumn(name = "ID_USER", referencedColumnName = "ID")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PanacheUser user;

    @JoinColumn(name = "ID_ADDRESS", referencedColumnName = "ID")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PanacheAddress> address;

    public String getSocialName() {
        return socialName;
    }

    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PanacheUser getUser() {
        return user;
    }

    public void setUser(PanacheUser user) {
        this.user = user;
    }

    public List<PanacheAddress> getAddress() {
        return address;
    }

    public void setAddress(List<PanacheAddress> address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}