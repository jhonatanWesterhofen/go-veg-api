package goveg.domain.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import goveg.domain.entity.bo.AddressBO;
import goveg.domain.entity.bo.UserBO;
import goveg.domain.entity.dto.AddressDTO;
import goveg.domain.entity.dto.UserDTO;

public class UserMapper {

    public static UserBO toUserBO(UserDTO dto) {

        if (dto.equals(null)) {
            return null;
        }

        var creatAt = LocalDateTime.of(LocalDate.parse(dto.getCreatedAt()), LocalTime.MIDNIGHT);

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

        var user = new UserDTO();

        user.setId(bo.getId().toString());
        user.setDocument(bo.getDocument());
        user.setConfirmationPass(bo.getConfirmationPass());
        user.setPassword(bo.getPassword());
        user.setCreatedAt(bo.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));

        return user;
    }

    public static AddressBO toAddressBO(AddressDTO dto) {

        if (dto.equals(null)) {
            return null;
        }
        return new AddressBO(Long.valueOf(dto.getId()),
                dto.getStreet(),
                dto.getNumber(),
                dto.getComplement(),
                dto.getPostalCode(),
                dto.getCity(),
                dto.getState(),
                dto.getLongitude(),
                dto.getLatitude());
    }

    public static AddressDTO tAddressDTO(AddressBO bo) {

        if (bo == null) {
            return null;
        }

        var address = new AddressDTO();

        address.setCity(bo.getCity());
        address.setComplement(bo.getComplement());
        address.setId(bo.getId().toString());
        address.setNumber(bo.getNumber());
        address.setPostalCode(bo.getPostalCode());
        address.setState(bo.getState());
        address.setStreet(bo.getStreet());
        address.setLatitude(bo.getLatitude());
        address.setLongitude(bo.getLongitude());

        return address;
    }
}