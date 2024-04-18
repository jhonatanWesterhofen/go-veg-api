package goveg.infra.database.panache.model.repositories;

import goveg.domain.entity.bo.PersonBO;
import goveg.domain.repositories.IPersonRepository;
import goveg.infra.database.panache.mapper.PanachePersonMapper;
import goveg.infra.database.panache.model.PanachePerson;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class PanachePersonRepository implements IPersonRepository {

    EntityManager em = PanachePerson.getEntityManager();

    @Override
    public PersonBO createPerson(PersonBO bo) {

        PanachePerson personEntity = PanachePersonMapper.toEntity(bo);

        personEntity.persistAndFlush();

        return PanachePersonMapper.toDomain(personEntity);
    }

    @Override
    public PersonBO merge(PersonBO person) {

        PanachePerson personEntity = PanachePersonMapper.toEntity(person);

        em.merge(personEntity);

        return PanachePersonMapper.toDomain(personEntity);

    }

    @Override
    public PersonBO findBy(Long id) {

        return PanachePerson.find("id", id.toString())
                .firstResultOptional()
                .map(entity -> PanachePersonMapper.toDomain((PanachePerson) entity))
                .orElse(null);
    }

    @Override
    public void delete(PersonBO person) {

        PanachePerson panachePerson = PanachePersonMapper.toEntity(person);

        if (panachePerson != null) {
            panachePerson.delete();
        }
    }

    @Override
    public PersonBO findDocument(String document) {

        return PanachePerson.find("document", document)
                .firstResultOptional()
                .map(entity -> PanachePersonMapper.toDomain((PanachePerson) entity))
                .orElse(null);
    }
}