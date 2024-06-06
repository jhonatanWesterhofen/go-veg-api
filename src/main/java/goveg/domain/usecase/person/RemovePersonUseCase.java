package goveg.domain.usecase.person;

import goveg.domain.entity.bo.PersonBO;
import goveg.domain.entity.enums.EnumErrorCod;
import goveg.domain.repositories.IPersonRepository;
import goveg.domain.utils.exception.GoVegException;

public class RemovePersonUseCase {

    private IPersonRepository iPersonRepository;

    public RemovePersonUseCase(IPersonRepository iPersonRepository) {
        this.iPersonRepository = iPersonRepository;
    }

    public void execute(String document) {

        PersonBO bo = iPersonRepository.findDocument(document);

        if (bo != null) {
            iPersonRepository.delete(bo, bo.getId());
        } else {
            throw new GoVegException(EnumErrorCod.USUARIO_EXISTENTE);
        }
    }
}