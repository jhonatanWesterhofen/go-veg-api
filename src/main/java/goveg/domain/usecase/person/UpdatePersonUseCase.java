package goveg.domain.usecase.person;

import goveg.domain.entity.bo.PersonBO;
import goveg.domain.entity.dto.PersonDTO;
import goveg.domain.entity.enums.EnumErrorCod;
import goveg.domain.mapper.PersonMapper;
import goveg.domain.repositories.IPersonRepository;
import goveg.domain.utils.exception.GoVegException;
import goveg.domain.validate.ValidadeDocument;

public class UpdatePersonUseCase {

    private IPersonRepository iPersonRepository;

    public UpdatePersonUseCase(IPersonRepository iPersonRepository) {
        this.iPersonRepository = iPersonRepository;
    }

    public void execute(PersonDTO dto, String document) {

        ValidadeDocument validate = new ValidadeDocument();

        if (dto.getDocument() == null) {
            throw new GoVegException(EnumErrorCod.CAMPO_OBRIGATORIO, "Documento");
        }

        if (!validate.isValidCNPJ(document) && !validate.isValidCPF(document)) {
            throw new GoVegException(EnumErrorCod.DOCUMENTO_INVALIDO);
        }

        PersonBO bo = iPersonRepository.findDocument(document);

        if (bo != null) {
            iPersonRepository.merge(PersonMapper.toBO(dto), bo.getId());
        }
    }
}