package goveg.presentation.controllers;

import org.jboss.resteasy.annotations.jaxrs.HeaderParam;

import goveg.domain.entity.dto.PersonDTO;
import goveg.presentation.service.AccountService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/go-veg/v1/account")
public class UserAccountController {

    @Inject
    AccountService accountService;

    @POST
    @Path("/create/account")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAccount(PersonDTO dto) {
        return accountService.createAccount(dto);
    }

    @PATCH
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAccount(PersonDTO dto) {
        return accountService.updateAccount(dto);
    }

    @DELETE
    @Path("remove")
    public Response removeAccount(@HeaderParam String id) {
        return accountService.removeAccount(id);
    }
}