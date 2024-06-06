package goveg.domain.usecase.person;

import goveg.domain.entity.bo.PersonBO;
import goveg.domain.entity.dto.PersonDTO;
import goveg.domain.entity.enums.EnumErrorCod;
import goveg.domain.mapper.PersonMapper;
import goveg.domain.repositories.IPersonRepository;
import goveg.domain.utils.exception.GoVegException;
import goveg.domain.validate.ValidadeDocument;

public class FindPersonDocumentUseCase {

    private IPersonRepository iPersonRepository;

    final ValidadeDocument validate = new ValidadeDocument();

    public FindPersonDocumentUseCase(IPersonRepository iPersonRepository) {
        this.iPersonRepository = iPersonRepository;
    }

    public PersonDTO execute(String document) {

        if (!validate.isValidCNPJ(document) && !validate.isValidCPF(document)) {
            throw new GoVegException(EnumErrorCod.DOCUMENTO_INVALIDO);

        }

        PersonBO personBO = iPersonRepository.findDocument(document);

        return PersonMapper.toDTO(personBO);
    }
}