package org.goveg.presentation.service;

import org.goveg.infra.database.panache.model.repositories.PanacheAccountRepository;

import jakarta.inject.Inject;

public abstract class AbstractService {

    @Inject
    PanacheAccountRepository accountRepository;

}
