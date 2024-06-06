package goveg.domain.utils.exception;

import goveg.domain.entity.enums.EnumErrorCod;
import goveg.domain.utils.StringUtil;

public class GoVegException extends RuntimeException {

    private String errorCode;

    public GoVegException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public GoVegException(EnumErrorCod error) {
        super(error.getError());
        this.errorCode = error.getKey();
    }

    public GoVegException(EnumErrorCod error, Object args) {
        super(StringUtil.stringFormat(error.getError(), args));
        this.errorCode = error.getKey();
    }

    public String getErrorCode() {
        return errorCode;
    }
}