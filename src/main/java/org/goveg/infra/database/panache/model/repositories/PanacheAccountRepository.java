package org.goveg.infra.database.panache.model.repositories;

import org.goveg.domain.entity.bo.PersonBO;
import org.goveg.domain.repositories.IPersonRepository;
import org.goveg.infra.database.panache.mapper.PanachePersonMapper;
import org.goveg.infra.database.panache.model.PanachePerson;

import jakarta.persistence.EntityManager;

public class PanacheAccountRepository implements IPersonRepository {

    EntityManager em = PanachePerson.getEntityManager();

    @Override
    public PersonBO create(PersonBO person) {

        var panache = PanachePersonMapper.toEntity(person);

        em.persist(person);

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

        if (entity != null) {
            em.remove(entity);
        }
    }
}