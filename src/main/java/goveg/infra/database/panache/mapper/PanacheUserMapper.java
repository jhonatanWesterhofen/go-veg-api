package goveg.infra.database.panache.mapper;

import java.time.format.DateTimeFormatter;

import goveg.domain.entity.bo.UserBO;
import goveg.infra.database.panache.model.PanacheUser;

public class PanacheUserMapper {

    public static PanacheUser toEntity(UserBO bo) {

        if (bo == null) {
            return null;
        }

        var panacheUser = new PanacheUser();

        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        panacheUser.setId(bo.getId());
        panacheUser.setConfirmationPass(bo.getConfirmationPass());
        panacheUser.setPassword(bo.getPassword());
        panacheUser.setDocument(bo.getDocument());
        panacheUser.setCreatedAt(null);

        return panacheUser;
    }

    public static UserBO toDomain(PanacheUser panache) {
        if (panache == null) {
            return null;
        }

        return new UserBO(
                panache.getId(),
                panache.getDocument(),
                panache.getPassword(),
                panache.getConfirmationPass(),
                panache.getCreatedAt().toString());
    }

}
