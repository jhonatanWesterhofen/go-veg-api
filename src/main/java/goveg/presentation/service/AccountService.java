package goveg.presentation.service;

import goveg.domain.entity.dto.PersonDTO;
import goveg.domain.usecase.CreateAccount;
import goveg.domain.usecase.RemoveAccount;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Status;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class AccountService extends AbstractService {

    @Transactional
    public Response createAccount(PersonDTO dto) {

        if (dto == null) {
            return null;
        }

        var response = new CreateAccount(accountRepository);
        var create = response.execute(dto);

        return Response.status(Status.STATUS_COMMITTED).entity(create).build();
    }

    @Transactional
    public Response updateAccount(PersonDTO dto) {

        if (dto == null) {
            return null;
        }

        // var response = new UpdateAccount(accountRepository);
        // response.execute(dto);

        return Response.status(Status.STATUS_COMMITTED).build();
    }

    @Transactional
    public Response removeAccount(String id) {

        if (id == null) {
            return null;
        }

        var response = new RemoveAccount(accountRepository);
        response.execute(id);

        return Response.status(Status.STATUS_COMMITTED).build();
    }
}