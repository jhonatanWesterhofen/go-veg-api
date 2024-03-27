package org.goveg.infra.database.panache.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "GV_USER")
public class PanacheUser extends PanacheEntityBase {

    @Id
    private UUID id;

    @Column(name = "AUTH_ID")
    private UUID authId;

    @Column(name = "DOCUMENT", unique = true)
    private String document;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "CONFIRMATION_PASS", length = 24)
    private String confirmationPass;

    @CreationTimestamp
    @Column(name = "CREATED_AT", updatable = false)
    private LocalDateTime createdAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getAuthId() {
        return authId;
    }

    public void setAuthId(UUID authId) {
        this.authId = authId;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
