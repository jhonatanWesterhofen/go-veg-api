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

    @Column(name = "CPF", unique = true)
    private String cpf;

    @Column(name = "CNPJ", unique = true)
    private String cnpj;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "rural_Producer")
    private boolean ruralProducer;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @JoinColumn(name = "ID_USER", referencedColumnName = "ID")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PanacheUser user;

    @JoinColumn(name = "ID_PRODUCER", referencedColumnName = "ID")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PanacheAddress> producerAddress;

    public String getSocialName() {
        return socialName;
    }

    public void setSocialName(String socialName) {
        this.socialName = socialName;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PanacheAddress> getProducerAddress() {
        return producerAddress;
    }

    public void setProducerAddress(List<PanacheAddress> producerAddress) {
        this.producerAddress = producerAddress;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public boolean isRuralProducer() {
        return ruralProducer;
    }

    public void setRuralProducer(boolean ruralProducer) {
        this.ruralProducer = ruralProducer;
    }
}