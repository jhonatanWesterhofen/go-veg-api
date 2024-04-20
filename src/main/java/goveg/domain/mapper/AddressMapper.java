package goveg.domain.mapper;

import goveg.domain.entity.bo.AddressBO;
import goveg.domain.entity.dto.AddressDTO;
import goveg.domain.utils.Utils;

public class AddressMapper {

    public static AddressBO toAddressBO(AddressDTO dto) {

        if (Utils.isNull(dto)) {
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

        if (Utils.isNull(bo)) {
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