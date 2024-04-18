package goveg.domain.usecase.person;

import goveg.domain.entity.bo.PersonBO;
import goveg.domain.entity.dto.PersonDTO;
import goveg.domain.mapper.PersonMapper;
import goveg.domain.repositories.IPersonRepository;

public class CreatePersonUseCase {

    private IPersonRepository iPersonRepository;

    public CreatePersonUseCase(IPersonRepository iPersonRepository) {
        this.iPersonRepository = iPersonRepository;
    }

    public PersonDTO execute(PersonDTO dto) {
        PersonBO createPerson = iPersonRepository.createPerson(PersonMapper.toBO(dto));

        return PersonMapper.toDTO(createPerson);

    }
}