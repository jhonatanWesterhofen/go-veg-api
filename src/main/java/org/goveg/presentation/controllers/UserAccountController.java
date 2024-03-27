package org.goveg.presentation.controllers;

import org.goveg.domain.entity.dto.PersonDTO;
import org.jboss.resteasy.annotations.jaxrs.HeaderParam;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/go-veg/v1/account")
public class UserAccountController {

    @POST
    @Path("/create/account")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAccount(@HeaderParam PersonDTO dto) {
        return null;
    }

}