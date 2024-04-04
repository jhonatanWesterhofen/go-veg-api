package org.goveg.domain.mapper;

import org.goveg.domain.entity.bo.AddressBO;
import org.goveg.domain.entity.bo.UserBO;
import org.goveg.domain.entity.dto.AddressDTO;
import org.goveg.domain.entity.dto.UserDTO;
import org.goveg.domain.vo.UuidVO;

public class UserMapper {

    public static UserBO toUserBO(UserDTO dto) {

        if (dto.equals(null)) {
            return null;
        }
        return new UserBO(
                new UuidVO(dto.getId()),
                dto.getDocument(),
                dto.getPassword(),
                dto.getConfirmationPass(),
                dto.getCreatedAt());
    }

    public static UserDTO toUserDTO(UserBO bo) {

        if (bo.equals(null)) {
            return null;
        }

        var user = new UserDTO();

        user.setId(bo.getId().getValue().toString());
        user.setDocument(bo.getDocument());
        user.setConfirmationPass(bo.getConfirmationPass());
        user.setPassword(bo.getPassword());
        user.setCreatedAt(bo.getCreatedAt());

        return user;
    }

    public static AddressBO toAddressBO(AddressDTO dto) {

        if (dto.equals(null)) {
            return null;
        }
        return new AddressBO(new UuidVO(dto.getId()),
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

        if (bo.equals(null)) {
            return null;
        }

        var address = new AddressDTO();

        address.setCity(bo.getCity());
        address.setComplement(bo.getComplement());
        address.setId(bo.getId().getValue().toString());
        address.setNumber(bo.getNumber());
        address.setPostalCode(bo.getPostalCode());
        address.setState(bo.getState());
        address.setStreet(bo.getStreet());
        address.setLatitude(bo.getLatitude());
        address.setLongitude(bo.getLongitude());

        return address;
    }

}
