package goveg.infra.database.panache.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "GV_USER")
public class PanacheUser extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "ID_USER", sequenceName = "GEN_GV_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_USER")
    @Column(name = "ID", nullable = false, precision = 0, scale = -127)
    private Long id;

    @Column(name = "DOCUMENT", unique = true)
    private String document;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "CONFIRMATION_PASS", length = 24)
    private String confirmationPass;

    @CreationTimestamp
    @Column(name = "CREATED_AT", updatable = false)
    private LocalDateTime createdAt;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
