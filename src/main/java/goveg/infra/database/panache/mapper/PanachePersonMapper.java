package goveg.infra.database.panache.mapper;

import java.util.List;
import java.util.stream.Collectors;

import goveg.domain.entity.bo.AddressBO;
import goveg.domain.entity.bo.PersonBO;
import goveg.domain.utils.Utils;
import goveg.infra.database.panache.model.PanacheAddress;
import goveg.infra.database.panache.model.PanachePerson;

public class PanachePersonMapper {

    public static PanachePerson toEntity(PersonBO bo) {

        if (Utils.isNull(bo)) {
            return null;
        }

        List<PanacheAddress> address = bo.getAddress().stream()
                .map(PanacheAdressMapper::toEntity)
                .collect(Collectors.toList());

        PanachePerson panachePerson = new PanachePerson();

        panachePerson.setId(null);
        panachePerson.setSocialName(bo.getSocialName());
        panachePerson.setCnpj(bo.getCnpj() != null ? bo.getCnpj() : null);
        panachePerson.setCpf(bo.getCpf() != null ? bo.getCpf() : null);
        panachePerson.setEmail(bo.getEmail());
        panachePerson.setPhoneNumber(bo.getPhoneNumber());
        panachePerson.setUser(PanacheUserMapper.toEntity(bo.getUser()));
        panachePerson.setProducerAddress(address);

        return panachePerson;

    }

    public static PersonBO toDomain(PanachePerson panachePerson) {

        if (Utils.isNull(panachePerson)) {
            return null;
        }

        List<AddressBO> address = panachePerson.getProducerAddress().stream()
                .map(PanacheAdressMapper::toDomain)
                .collect(Collectors.toList());

        return new PersonBO(
                panachePerson.getId(),
                panachePerson.getSocialName(),
                panachePerson.getCpf(),
                panachePerson.getCnpj(),
                panachePerson.getEmail(),
                panachePerson.getPhoneNumber(),
                PanacheUserMapper.toDomain(panachePerson.getUser()),
                address);
    }
}