package org.goveg.infra.database.panache.mapper;

import org.goveg.domain.entity.bo.PersonBO;
import org.goveg.domain.vo.UuidVO;
import org.goveg.infra.database.panache.model.PanachePerson;

public class PanachePersonMapper {

    public static PanachePerson toEntity(PersonBO bo) {

        if (bo == null) {
            return null;
        }

        var panachePerson = new PanachePerson();

        panachePerson.setId(bo.getId().getValue());
        panachePerson.setSocialName(bo.getSocialName());
        panachePerson.setDocument(bo.getDocument());
        panachePerson.setEmail(bo.getEmail());
        panachePerson.setPhoneNumber(bo.getPhoneNumber());

        return panachePerson;
    }

    public static PersonBO toDomain(PanachePerson panache) {

        return new PersonBO(
                new UuidVO(panache.getId().toString()),
                panache.getSocialName(),
                panache.getDocument(),
                panache.getEmail(),
                panache.getPhoneNumber(),
                null,
                null);
    }
}