package goveg.presentation.service;

import goveg.infra.database.panache.model.repositories.PanacheAccountRepository;
import jakarta.inject.Inject;



public abstract class AbstractService {

    @Inject
    PanacheAccountRepository accountRepository;

}
