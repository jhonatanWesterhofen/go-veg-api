package goveg.domain.repositories;

import goveg.domain.entity.bo.PersonBO;

public interface IPersonRepository {

    PersonBO create(PersonBO person);

    PersonBO merge(PersonBO person);

    PersonBO findBy(String id);

    void delete(String id);

}