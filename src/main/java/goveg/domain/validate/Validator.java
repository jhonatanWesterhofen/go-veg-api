package goveg.domain.validate;

import goveg.domain.entity.dto.PersonDTO;

public class Validator {

    public void validateRequiredFields(PersonDTO person) {

        final ValidateUtil validate = new ValidateUtil();

        validate.validateFields(person.getDocument(), "document");
        validate.validateFields(person.getSocialName(), "socialName");
        validate.validateFields(person.getAddress(), "address");
        validate.validateFields(person.getEmail(), "email");

        validate.validate();
    }
}