package org.goveg.domain.usecase;

import org.goveg.domain.entity.dto.PersonDTO;
import org.goveg.domain.mapper.PersonMapper;
import org.goveg.domain.repositories.IPersonRepository;

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