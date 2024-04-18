package goveg.domain.usecase.person;

import goveg.domain.entity.bo.PersonBO;
import goveg.domain.entity.dto.PersonDTO;
import goveg.domain.mapper.PersonMapper;
import goveg.domain.repositories.IPersonRepository;

public class FindPersonDocumentUseCase {

    private IPersonRepository iPersonRepository;

    public FindPersonDocumentUseCase(IPersonRepository iPersonRepository) {
        this.iPersonRepository = iPersonRepository;
    }

    public PersonDTO execute(String id) {

        PersonBO personBO = iPersonRepository.findDocument(id);

        return PersonMapper.toDTO(personBO);
    }

}
