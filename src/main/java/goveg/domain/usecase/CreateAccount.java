package goveg.domain.usecase;

import goveg.domain.entity.dto.PersonDTO;
import goveg.domain.mapper.PersonMapper;
import goveg.domain.repositories.IPersonRepository;
import jakarta.transaction.Transactional;

@Transactional
public class CreateAccount {

    private IPersonRepository iPersonRepository;

    public CreateAccount(IPersonRepository iPersonRepository) {
        this.iPersonRepository = iPersonRepository;
    }

    public PersonDTO execute(PersonDTO dto) {
        var createPerson = iPersonRepository.create(PersonMapper.toBO(dto));

        return PersonMapper.toDTO(createPerson);

    }
}