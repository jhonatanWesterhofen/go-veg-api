package goveg.domain.entity.bo;

import java.time.LocalDateTime;

public class UserBO {

    private Long id;

    private String document;

    private String password;

    private String confirmationPass;

    private LocalDateTime createdAt;

    public UserBO(Long id, String document, String password, String confirmationPass, LocalDateTime createdAt) {
        this.id = id;
        this.document = document;
        this.password = password;
        this.confirmationPass = confirmationPass;
        this.createdAt = createdAt;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getId() {
        return id;
    }
}