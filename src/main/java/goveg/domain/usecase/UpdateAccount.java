package goveg.domain.usecase;

import goveg.domain.entity.dto.PersonDTO;
import goveg.domain.mapper.PersonMapper;
import goveg.domain.repositories.IPersonRepository;

public class UpdateAccount {

    private IPersonRepository iPersonRepository;

    public UpdateAccount(IPersonRepository iPersonRepository) {
        this.iPersonRepository = iPersonRepository;
    }

    public void execute(PersonDTO dto) {

        var bo = iPersonRepository.findBy(Long.parseLong(dto.getId()));

        if (bo != null) {

            iPersonRepository.merge(PersonMapper.toBO(dto));

        }
    }
}