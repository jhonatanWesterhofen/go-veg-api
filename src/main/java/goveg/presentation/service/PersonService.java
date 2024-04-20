package goveg.presentation.service;

import goveg.domain.entity.dto.PersonDTO;
import goveg.domain.entity.enums.EnumErrorCod;
import goveg.domain.usecase.person.CreatePersonUseCase;
import goveg.domain.usecase.person.FindPersonDocumentUseCase;
import goveg.domain.usecase.person.FindPersonUseCase;
import goveg.domain.usecase.person.RemovePersonUseCase;
import goveg.domain.usecase.person.UpdatePersonUseCase;
import goveg.domain.utils.StringUtils;
import goveg.domain.utils.govegException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class PersonService extends AbstractService {

    @Transactional
    public Response createAccount(PersonDTO personDTO) {

        validadePerson(personDTO);

        CreatePersonUseCase createPerson = new CreatePersonUseCase(personRepository);
        PersonDTO create = createPerson.execute(personDTO);

        return Response.status(Response.Status.CREATED).entity(create).build();
    }

    @Transactional
    public Response updateAccount(PersonDTO personDTO) {

        validadePerson(personDTO);

        UpdatePersonUseCase updatePerson = new UpdatePersonUseCase(personRepository);
        updatePerson.execute(personDTO);

        return Response.status(Response.Status.CREATED).build();
    }

    @Transactional
    public Response removeAccount(String id) {

        validade(id);

        RemovePersonUseCase removePerson = new RemovePersonUseCase(personRepository);
        removePerson.execute(id);

        return Response.status(Response.Status.OK).build();
    }

    @Transactional
    public Response findIdPerson(String id) {

        validade(id);

        if (!StringUtils.onlyNumbers(id)) {
            throw new govegException(EnumErrorCod.FORMATO_INVALIDO_DO_CAMPO);
        }

        var findPerson = new FindPersonUseCase(personRepository);
        PersonDTO person = findPerson.execute(id);

        return Response.status(Response.Status.OK).entity(person).build();
    }

    @Transactional
    public Response findPersonDocument(String id) {

        validade(id);

        if (!StringUtils.onlyNumbers(id)) {
            throw new govegException(EnumErrorCod.FORMATO_INVALIDO_DO_CAMPO);
        }

        var findPerson = new FindPersonDocumentUseCase(personRepository);
        PersonDTO person = findPerson.execute(id);

        return Response.status(Response.Status.OK).entity(person).build();
    }

    private void validadePerson(PersonDTO personDTO) {

        if (personDTO == null) {
            throw new govegException(EnumErrorCod.OBJETO_PERSON_OBRIGATORIO);
        }

        if (personDTO.getSocialName() == null) {
            throw new govegException(EnumErrorCod.CAMPO_OBRIGATORIO_NAME);
        }

        if (personDTO.getDocument() == null) {
            throw new govegException(EnumErrorCod.CAMPO_OBRIGATORIO_DOCUMENT);
        }

        if (personDTO.getAddress().get(0).getPostalCode() == null) {
            throw new govegException(EnumErrorCod.CAMPO_OBRIGATORIO_CEP);
        }

        if (personDTO.getUser().getPassword() == null) {
            throw new govegException(EnumErrorCod.CAMPO_OBRIGATORIO_SENHA);
        }
    }

    private void validade(String id) {

        if (id == null) {
            throw new govegException(EnumErrorCod.CAMPO_OBRIGATORIO);
        }
    }
}