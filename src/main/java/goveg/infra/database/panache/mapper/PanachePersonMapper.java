package goveg.infra.database.panache.mapper;

import goveg.domain.entity.bo.PersonBO;
import goveg.infra.database.panache.model.PanachePerson;

public class PanachePersonMapper {

    public static PanachePerson toEntity(PersonBO bo) {

        if (bo == null) {
            return null;
        }

        var panachePerson = new PanachePerson();

        panachePerson.setId(null);
        panachePerson.setSocialName(bo.getSocialName());
        panachePerson.setDocument(bo.getDocument());
        panachePerson.setEmail(bo.getEmail());
        panachePerson.setPhoneNumber(bo.getPhoneNumber());
        panachePerson.setUser(PanacheUserMapper.toEntity(bo.getUser()));
        panachePerson.setAddress(null);

        return panachePerson;

    }

    public static PersonBO toDomain(PanachePerson panache) {

        if (panache == null) {
            return null;
        }

        return new PersonBO(
                panache.getId(),
                panache.getSocialName(),
                panache.getDocument(),
                panache.getEmail(),
                panache.getPhoneNumber(),
                PanacheUserMapper.toDomain(panache.getUser()),
                null);
    }
}