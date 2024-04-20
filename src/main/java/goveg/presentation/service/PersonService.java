package goveg.presentation.service;

import goveg.domain.entity.dto.PersonDTO;
import goveg.domain.entity.enums.EnumErrorCod;
import goveg.domain.usecase.person.CreatePersonUseCase;
import goveg.domain.usecase.person.FindPersonDocumentUseCase;
import goveg.domain.usecase.person.FindPersonUseCase;
import goveg.domain.usecase.person.RemovePersonUseCase;
import goveg.domain.usecase.person.UpdatePersonUseCase;
import goveg.domain.utils.StringUtil;
import goveg.domain.utils.Utils;
import goveg.domain.utils.exception.GoVegException;
import goveg.domain.validate.ValidateUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class PersonService extends AbstractService {

    @Transactional
    public Response createPerson(PersonDTO personDTO) {

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

        if (Utils.isNull(id)) {
            throw new GoVegException(EnumErrorCod.CAMPO_OBRIGATORIO);
        }

        RemovePersonUseCase removePerson = new RemovePersonUseCase(personRepository);
        removePerson.execute(id);

        return Response.status(Response.Status.OK).build();
    }

    @Transactional
    public Response findIdPerson(String id) {

        if (Utils.isNull(id)) {
            throw new GoVegException(EnumErrorCod.CAMPO_OBRIGATORIO);
        }

        if (!StringUtil.onlyNumbers(id)) {
            throw new GoVegException(EnumErrorCod.FORMATO_INVALIDO_DO_CAMPO);
        }

        var findPerson = new FindPersonUseCase(personRepository);
        PersonDTO person = findPerson.execute(id);

        return Response.status(Response.Status.OK).entity(person).build();
    }

    @Transactional
    public Response findPersonDocument(String id) {

        if (Utils.isNull(id)) {
            throw new GoVegException(EnumErrorCod.CAMPO_OBRIGATORIO, "id");
        }

        if (!StringUtil.onlyNumbers(id)) {
            throw new GoVegException(EnumErrorCod.FORMATO_INVALIDO_DO_CAMPO);
        }

        var findPerson = new FindPersonDocumentUseCase(personRepository);
        PersonDTO person = findPerson.execute(id);

        return Response.status(Response.Status.OK).entity(person).build();
    }

    private void validadePerson(PersonDTO personDTO) {

        if (Utils.isNull(personDTO)) {
            throw new GoVegException(EnumErrorCod.OBJETO_OBRIGATORIO, "person");
        }

        final ValidateUtil validate = new ValidateUtil();

        if (validate.validateFields(personDTO.getSocialName(), "socialName").size() > 0) {
            throw new GoVegException(EnumErrorCod.CAMPO_OBRIGATORIO, "socialName");
        }

        if (validate.validateFields(personDTO.getDocument(), "document").size() > 0) {
            throw new GoVegException(EnumErrorCod.CAMPO_OBRIGATORIO, "document");

        }

        personDTO.getAddress().forEach(e -> {

            if (validate.validateFields(e.getPostalCode(), "postalCode").size() > 0) {
                throw new GoVegException(EnumErrorCod.CAMPO_OBRIGATORIO, "postalCode");
            }

        });

        if (validate.validateFields(personDTO.getUser().getPassword(), "password").size() > 0) {
            throw new GoVegException(EnumErrorCod.CAMPO_OBRIGATORIO, "password");

        }
    }
}