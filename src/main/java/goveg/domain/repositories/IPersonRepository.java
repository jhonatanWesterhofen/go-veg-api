package goveg.domain.repositories;

import goveg.domain.entity.bo.PersonBO;

public interface IPersonRepository {

    PersonBO createPerson(PersonBO person);

    PersonBO merge(PersonBO person);

    PersonBO findBy(Long id);

    PersonBO findDocument(String document);

    void delete(PersonBO person);
}