package goveg.domain.mapper;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import goveg.domain.entity.bo.UserBO;
import goveg.domain.entity.dto.UserDTO;
import goveg.domain.utils.Utils;

public class UserMapper {

    public static UserBO toUserBO(UserDTO dto) {

        if (Utils.isNull(dto)) {
            return null;
        }

        Long id = dto.getId() != null ? Long.valueOf(dto.getId())
                : UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;

        return new UserBO(id,
                dto.getDocument(),
                dto.getPassword(),
                dto.getConfirmationPass(),
                LocalDateTime.now());
    }

    public static UserDTO toUserDTO(UserBO bo) {

        if (Utils.isNull(bo)) {
            return null;
        }

        UserDTO user = new UserDTO();

        user.setId(bo.getId().toString());
        user.setDocument(bo.getDocument());
        user.setConfirmationPass(bo.getConfirmationPass());
        user.setPassword(bo.getPassword());
        user.setCreatedAt(bo.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));

        return user;
    }
}