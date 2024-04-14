package goveg.domain.mapper;

import goveg.domain.entity.bo.AddressBO;
import goveg.domain.entity.dto.AddressDTO;

public class AddressMapper {

    public static AddressBO toAddressBO(AddressDTO dto) {

        if (dto == null) {
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

    public static AddressDTO toAddressDTO(AddressBO bo) {

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