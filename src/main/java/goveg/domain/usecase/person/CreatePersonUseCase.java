package goveg.domain.usecase.person;

import goveg.domain.entity.bo.PersonBO;
import goveg.domain.entity.dto.PersonDTO;
import goveg.domain.entity.enums.EnumErrorCod;
import goveg.domain.mapper.PersonMapper;
import goveg.domain.repositories.IPersonRepository;
import goveg.domain.utils.exception.GoVegException;
import goveg.domain.validate.ValidadeDocument;

public class CreatePersonUseCase {

    private IPersonRepository iPersonRepository;

    final ValidadeDocument validate = new ValidadeDocument();

    public CreatePersonUseCase(IPersonRepository iPersonRepository) {
        this.iPersonRepository = iPersonRepository;
    }

    public PersonDTO execute(PersonDTO dto) {

        if (!validate.isValidCNPJ(dto.getDocument()) && !validate.isValidCPF(dto.getDocument())) {
            throw new GoVegException(EnumErrorCod.DOCUMENTO_INVALIDO);
        }
        
        PersonBO createPerson = iPersonRepository.createPerson(PersonMapper.toBO(dto));

        return PersonMapper.toDTO(createPerson);

    }
}