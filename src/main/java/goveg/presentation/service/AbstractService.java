package goveg.presentation.service;

import goveg.infra.database.panache.model.repositories.PanachePersonRepository;
import jakarta.inject.Inject;

public abstract class AbstractService {

    @Inject
    PanachePersonRepository personRepository;

}