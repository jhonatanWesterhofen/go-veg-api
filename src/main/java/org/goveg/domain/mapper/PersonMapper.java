package org.goveg.domain.mapper;

import org.goveg.domain.entity.bo.PersonBO;
import org.goveg.domain.entity.dto.PersonDTO;

import org.goveg.domain.vo.UuidVO;

public class PersonMapper {

    public static PersonBO toBO(PersonDTO dto) {
        if (dto.equals(null)) {
            return null;
        }

        return new PersonBO(
                new UuidVO(dto.getId()),
                dto.getSocialName(),
                dto.getDocument(),
                dto.getEmail(),
                dto.getPhoneNumber(),
                UserMapper.toUserBO(dto.getUser()),
                UserMapper.toAddressBO(dto.getAddress()));
    }

    public static PersonDTO toDTO(PersonBO bo) {

        if (bo.equals(null)) {
            return null;
        }

        var personDTO = new PersonDTO();

        personDTO.setId(bo.getId().getValue().toString());
        personDTO.setSocialName(bo.getSocialName());
        personDTO.setDocument(bo.getDocument());
        personDTO.setEmail(bo.getEmail());
        personDTO.setPhoneNumber(bo.getPhoneNumber());
        personDTO.setUser(UserMapper.toUserDTO(bo.getUser()));
        personDTO.setAddress(UserMapper.tAddressDTO(bo.getAddress()));

        return personDTO;

    }

}