package goveg.domain.mapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import goveg.domain.entity.bo.AddressBO;
import goveg.domain.entity.bo.PersonBO;
import goveg.domain.entity.dto.AddressDTO;
import goveg.domain.entity.dto.PersonDTO;
import goveg.domain.utils.Utils;
import goveg.domain.validate.ValidadeDocument;

public class PersonMapper {

    final ValidadeDocument validate = new ValidadeDocument();

    public static PersonBO toBO(PersonDTO dto) {
        if (Utils.isNull(dto)) {
            return null;
        }

        List<AddressBO> addressBO = dto.getAddress().stream()
                .map(AddressMapper::toAddressBO)
                .collect(Collectors.toList());

        Long id = dto.getId() != null ? Long.valueOf(dto.getId())
                : UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;

        return new PersonBO(
                id,
                dto.getSocialName(),
                dto.getDocument(),
                dto.getDocument(),
                dto.getEmail(),
                dto.getPhoneNumber(),
                UserMapper.toUserBO(dto.getUser()),
                addressBO,
                dto.isRuralProducer());
    }

    public static PersonDTO toDTO(PersonBO bo) {

        if (Utils.isNull(bo)) {
            return null;
        }
        List<AddressDTO> addressDTO = bo.getAddress().stream()
                .map(AddressMapper::toAddressDTO)
                .collect(Collectors.toList());

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId(bo.getId().toString());
        personDTO.setSocialName(bo.getSocialName());
        personDTO.setDocument(bo.getCpf());
        personDTO.setEmail(bo.getEmail());
        personDTO.setPhoneNumber(bo.getPhoneNumber());
        personDTO.setUser(UserMapper.toUserDTO(bo.getUser()));
        personDTO.setAddress(addressDTO);
        personDTO.setRuralProducer(bo.isRuralProducer());

        return personDTO;
        
    }
}