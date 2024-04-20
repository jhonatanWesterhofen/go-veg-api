package goveg.domain.usecase.person;

import goveg.domain.entity.bo.PersonBO;
import goveg.domain.entity.dto.PersonDTO;
import goveg.domain.mapper.PersonMapper;
import goveg.domain.repositories.IPersonRepository;

public class FindPersonUseCase {

    private IPersonRepository iPersonRepository;

    public FindPersonUseCase(IPersonRepository iPersonRepository) {
        this.iPersonRepository = iPersonRepository;
    }

    public PersonDTO execute(String id) {

        PersonBO personBO = iPersonRepository.findBy(Long.parseLong(id));

        return PersonMapper.toDTO(personBO);
    }
}