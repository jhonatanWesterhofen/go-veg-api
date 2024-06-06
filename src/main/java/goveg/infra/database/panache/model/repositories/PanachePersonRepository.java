package goveg.infra.database.panache.model.repositories;

import goveg.domain.entity.bo.PersonBO;
import goveg.domain.entity.enums.EnumErrorCod;
import goveg.domain.repositories.IPersonRepository;
import goveg.domain.utils.exception.GoVegException;
import goveg.domain.validate.ValidadeDocument;
import goveg.infra.database.panache.mapper.PanachePersonMapper;
import goveg.infra.database.panache.model.PanachePerson;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class PanachePersonRepository implements IPersonRepository {

    @Inject
    EntityManager em;

    final ValidadeDocument validate = new ValidadeDocument();

    @Override
    public PersonBO createPerson(PersonBO bo) {

        PanachePerson personEntity = PanachePersonMapper.toEntity(bo, null);

        personEntity.persistAndFlush();

        return PanachePersonMapper.toDomain(personEntity);
    }

    @Override
    public PersonBO merge(PersonBO person, Long id) {

        PanachePerson personEntity = PanachePersonMapper.toEntity(person, id);

        em.merge(personEntity);

        return PanachePersonMapper.toDomain(personEntity);

    }

    @Override
    public PersonBO findBy(Long id) {

        return PanachePerson.find("id", id)
                .firstResultOptional()
                .map(entity -> PanachePersonMapper.toDomain((PanachePerson) entity))
                .orElse(null);
    }

    @Override
    public void delete(PersonBO person, Long id) {

        PanachePerson panachePerson = PanachePersonMapper.toEntity(person, id);

        if (panachePerson != null) {
            if (panachePerson.getId() != null) {
                panachePerson.delete();
            } else {
                throw new GoVegException(EnumErrorCod.CAMPO_OBRIGATORIO, "ID");
            }
        } else {
            throw new GoVegException(EnumErrorCod.OBJETO_OBRIGATORIO, "Person");
        }
    }

    @Override
    public PersonBO findDocument(String document) {

        String param;

        if (validate.isCNPJ(document) && !validate.isCPF(document)) {
            param = "cnpj";

        } else {
            param = "cpf";
        }

        return PanachePerson.find(param, document)
                .firstResultOptional()
                .map(entity -> PanachePersonMapper.toDomain((PanachePerson) entity))
                .orElse(null);
    }
}