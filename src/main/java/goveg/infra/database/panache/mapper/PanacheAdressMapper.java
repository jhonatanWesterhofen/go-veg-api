package goveg.infra.database.panache.mapper;

import goveg.domain.entity.bo.AddressBO;
import goveg.infra.database.panache.model.PanacheAddress;

public class PanacheAdressMapper {

    public static PanacheAddress toEntity(AddressBO bo) {

        if (bo == null) {
            return null;
        }

        var panacheAddress = new PanacheAddress();

        panacheAddress.setId(bo.getId());
        panacheAddress.setStreet(bo.getStreet());
        panacheAddress.setNumber(bo.getNumber());
        panacheAddress.setComplement(bo.getComplement());
        panacheAddress.setPostalCode(bo.getPostalCode());
        panacheAddress.setCity(bo.getCity());
        panacheAddress.setState(bo.getState());
        return panacheAddress;

    }

    public static AddressBO toDomain(PanacheAddress panacheAddress) {

        if (panacheAddress == null) {
            return null;
        }

        return new AddressBO(
                panacheAddress.getId(),
                panacheAddress.getStreet(),
                panacheAddress.getNumber(),
                panacheAddress.getComplement(),
                panacheAddress.getPostalCode(),
                panacheAddress.getCity(),
                panacheAddress.getState(),
                panacheAddress.getLongitude(),
                panacheAddress.getLatitude());

    }
}