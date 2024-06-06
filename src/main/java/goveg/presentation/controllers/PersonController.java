package goveg.presentation.controllers;

import org.jboss.resteasy.annotations.jaxrs.HeaderParam;
import goveg.domain.entity.dto.PersonDTO;
import goveg.presentation.service.PersonService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/go-veg/v1/account")
public class PersonController {

    @Inject
    PersonService accountService;

    @POST
    @Path("/create/person")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPerson(PersonDTO dto) {
        return accountService.createPerson(dto);
    }

    @GET
    @Path("/find/person/id")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findPerson(@HeaderParam String id) {
        return accountService.findIdPerson(id);
    }

    @GET
    @Path("/find/person/document")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findPersonDocument(@HeaderParam String document) {
        return accountService.findPersonDocument(document);
    }

    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAccount(PersonDTO dto, @HeaderParam String document) {
        return accountService.updateAccount(dto, document);
    }

    @DELETE
    @Path("remove")
    public Response removeAccount(@HeaderParam String document) {
        return accountService.removeAccount(document);
    }
}