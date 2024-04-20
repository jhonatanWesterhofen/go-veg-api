package goveg.domain.utils;

import goveg.domain.entity.enums.EnumErrorCod;

public class govegException extends RuntimeException {

    private String errorCode = "-1";

    public govegException(EnumErrorCod error) {
        super(error.getError());
        this.errorCode = error.getKey();
    }
}