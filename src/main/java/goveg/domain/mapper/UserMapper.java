package goveg.domain.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import goveg.domain.entity.bo.UserBO;
import goveg.domain.entity.dto.UserDTO;

public class UserMapper {

    public static UserBO toUserBO(UserDTO dto) {

        if (dto.equals(null)) {
            return null;
        }

        LocalDateTime creatAt = LocalDateTime.of(LocalDate.parse(dto.getCreatedAt()), LocalTime.MIDNIGHT);

        return new UserBO(Long.valueOf(dto.getId()),
                dto.getDocument(),
                dto.getPassword(),
                dto.getConfirmationPass(),
                creatAt);
    }

    public static UserDTO toUserDTO(UserBO bo) {

        if (bo == null) {
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