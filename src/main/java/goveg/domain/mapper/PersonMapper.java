package goveg.domain.mapper;

import java.util.stream.Collectors;

import goveg.domain.entity.bo.PersonBO;
import goveg.domain.entity.dto.PersonDTO;

public class PersonMapper {

    public static PersonBO toBO(PersonDTO dto) {
        if (dto == null) {
            return null;
        }

        var addressBO = dto.getAddress().stream()
                .map(AddressMapper::toAddressBO)
                .collect(Collectors.toList());

        return new PersonBO(
                Long.valueOf(dto.getId()),
                dto.getSocialName(),
                dto.getDocument(),
                dto.getEmail(),
                dto.getPhoneNumber(),
                UserMapper.toUserBO(dto.getUser()),
                addressBO);
    }

    public static PersonDTO toDTO(PersonBO bo) {

        if (bo == null) {
            return null;
        }

        var addressDTO = bo.getAddress().stream()
                .map(AddressMapper::toAddressDTO)
                .collect(Collectors.toList());

        var personDTO = new PersonDTO();

        personDTO.setId(bo.getId().toString());
        personDTO.setSocialName(bo.getSocialName());
        personDTO.setDocument(bo.getDocument());
        personDTO.setEmail(bo.getEmail());
        personDTO.setPhoneNumber(bo.getPhoneNumber());
        personDTO.setUser(UserMapper.toUserDTO(bo.getUser()));
        personDTO.setAddress(addressDTO);

        return personDTO;

    }
}