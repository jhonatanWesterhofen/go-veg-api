package goveg.domain.usecase.person;

import goveg.domain.entity.bo.PersonBO;
import goveg.domain.entity.dto.PersonDTO;
import goveg.domain.mapper.PersonMapper;
import goveg.domain.repositories.IPersonRepository;

public class UpdatePersonUseCase {

    private IPersonRepository iPersonRepository;

    public UpdatePersonUseCase(IPersonRepository iPersonRepository) {
        this.iPersonRepository = iPersonRepository;
    }

    public void execute(PersonDTO dto) {

        PersonBO  bo = iPersonRepository.findBy(Long.parseLong(dto.getId()));

        if (bo != null) {

            iPersonRepository.merge(PersonMapper.toBO(dto));

        }
    }
}