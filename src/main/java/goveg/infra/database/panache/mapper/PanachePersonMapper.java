package goveg.infra.database.panache.mapper;

import java.util.List;
import java.util.stream.Collectors;

import goveg.domain.entity.bo.AddressBO;
import goveg.domain.entity.bo.PersonBO;
import goveg.infra.database.panache.model.PanacheAddress;
import goveg.infra.database.panache.model.PanachePerson;

public class PanachePersonMapper {

    public static PanachePerson toEntity(PersonBO bo) {

        if (bo == null) {
            return null;
        }

        List<PanacheAddress> address = bo.getAddress().stream()
                .map(PanacheAdressMapper::toEntity)
                .collect(Collectors.toList());

        var panachePerson = new PanachePerson();

        panachePerson.setId(null);
        panachePerson.setSocialName(bo.getSocialName());
        panachePerson.setDocument(bo.getDocument());
        panachePerson.setEmail(bo.getEmail());
        panachePerson.setPhoneNumber(bo.getPhoneNumber());
        panachePerson.setUser(PanacheUserMapper.toEntity(bo.getUser()));
        panachePerson.setProducerAddress(address);

        return panachePerson;

    }

    public static PersonBO toDomain(PanachePerson panache) {

        if (panache == null) {
            return null;
        }

        List<AddressBO> address = panache.getProducerAddress().stream()
                .map(PanacheAdressMapper::toDomain)
                .collect(Collectors.toList());

        return new PersonBO(
                panache.getId(),
                panache.getSocialName(),
                panache.getDocument(),
                panache.getEmail(),
                panache.getPhoneNumber(),
                PanacheUserMapper.toDomain(panache.getUser()),
                address);
    }
}