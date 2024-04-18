package goveg.domain.usecase.person;

import goveg.domain.repositories.IPersonRepository;

public class RemovePersonUseCase {

    private IPersonRepository iPersonRepository;

    public RemovePersonUseCase(IPersonRepository iPersonRepository) {
        this.iPersonRepository = iPersonRepository;
    }

    public void execute(String id) {

        long idLong = Long.parseLong(id);

        var bo = iPersonRepository.findBy(idLong);

        if (bo != null) {

            iPersonRepository.delete(bo);

        }
    }
}