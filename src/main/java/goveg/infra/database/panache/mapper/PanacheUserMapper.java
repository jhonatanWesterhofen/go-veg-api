package goveg.infra.database.panache.mapper;

import goveg.domain.entity.bo.UserBO;
import goveg.domain.utils.Utils;
import goveg.infra.database.panache.model.PanacheUser;

public class PanacheUserMapper {

    public static PanacheUser toEntity(UserBO bo) {

        if (Utils.isNull(bo)) {
            return null;
        }

        var panacheUser = new PanacheUser();

        panacheUser.setId(null);
        panacheUser.setConfirmationPass(bo.getConfirmationPass());
        panacheUser.setPassword(bo.getPassword());
        panacheUser.setDocument(bo.getDocument());
        panacheUser.setCreatedAt(bo.getCreatedAt());

        return panacheUser;
    }

    public static UserBO toDomain(PanacheUser panacheUser) {
        if (Utils.isNull(panacheUser)) {
            return null;
        }

        return new UserBO(
                panacheUser.getId(),
                panacheUser.getDocument(),
                panacheUser.getPassword(),
                panacheUser.getConfirmationPass(),
                panacheUser.getCreatedAt());
    }
}