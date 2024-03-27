package org.goveg.infra.database.panache.model;

import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "GV_PERSON")
public class PanachePerson extends PanacheEntityBase {

    @Id
    private UUID id;

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
    private PanacheAddress address;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public PanacheAddress getAddress() {
        return address;
    }

    public void setAddress(PanacheAddress address) {
        this.address = address;
    }
}