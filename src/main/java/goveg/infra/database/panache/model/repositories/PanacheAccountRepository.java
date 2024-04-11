package goveg.infra.database.panache.model.repositories;

import goveg.domain.entity.bo.PersonBO;
import goveg.domain.repositories.IPersonRepository;
import goveg.infra.database.panache.mapper.PanachePersonMapper;
import goveg.infra.database.panache.model.PanachePerson;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class PanacheAccountRepository implements IPersonRepository {

    EntityManager em = PanachePerson.getEntityManager();

    
    @Override
    public PersonBO create(PersonBO bo) {

        var panache = PanachePersonMapper.toEntity(bo);

        panache.persistAndFlush();

        return PanachePersonMapper.toDomain(panache);
    }

    @Override
    public PersonBO merge(PersonBO person) {

        var panache = PanachePersonMapper.toEntity(person);

        em.merge(panache);

        return PanachePersonMapper.toDomain(panache);

    }

    @Override
    public PersonBO findBy(String id) {
        return PanachePerson.find(id, "id")
                .firstResultOptional()
                .map(entity -> PanachePersonMapper.toDomain((PanachePerson) entity))
                .orElse(null);
    }

    @Override
    public void delete(String id) {

        var entity = findBy(id);

        var mapper = PanachePersonMapper.toEntity(entity);

        if (mapper != null) {
            em.remove(mapper);
        }
    }
}