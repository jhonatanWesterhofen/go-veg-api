package goveg.domain.usecase;

import goveg.domain.repositories.IPersonRepository;

public class RemoveAccount {

    private IPersonRepository iPersonRepository;

    public RemoveAccount(IPersonRepository iPersonRepository) {
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