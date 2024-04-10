package goveg.domain.mapper;

import goveg.domain.entity.bo.PersonBO;
import goveg.domain.entity.dto.PersonDTO;

public class PersonMapper {

    public static PersonBO toBO(PersonDTO dto) {
        if (dto.equals(null)) {
            return null;
        }

        return new PersonBO(
                Long.valueOf(dto.getId()),
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

        personDTO.setId(bo.getId().toString());
        personDTO.setSocialName(bo.getSocialName());
        personDTO.setDocument(bo.getDocument());
        personDTO.setEmail(bo.getEmail());
        personDTO.setPhoneNumber(bo.getPhoneNumber());
        personDTO.setUser(UserMapper.toUserDTO(bo.getUser()));
        personDTO.setAddress(UserMapper.tAddressDTO(bo.getAddress()));

        return personDTO;

    }

}