package goveg.domain.validate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import goveg.domain.entity.enums.EnumErrorCod;
import goveg.domain.utils.ListUtil;
import goveg.domain.utils.StringUtil;
import goveg.domain.utils.exception.GoVegException;

public class ValidateUtil {

    private List<String> nullFields = new ArrayList<>();

    public void validateFields(Object obj, String fieldName) {

        boolean verifyFieldsNullOrEmpty = isNullOrEmpty(obj);
        if (verifyFieldsNullOrEmpty) {
            nullFields.add(fieldName);
        }
    }

    public void validate() {

        if (ListUtil.isNotNullOrNotEmpty(nullFields)) {
            throw new GoVegException(EnumErrorCod.OBJETO_OBRIGATORIO);
        }
    }

    private boolean isNullOrEmpty(Object obj) {

        if (obj instanceof Collection<?>) {
            return ListUtil.isNullOrEmpty((Collection<?>) obj);
        }

        if (obj instanceof CharSequence) {
            return StringUtil.isNullOrEmpty(obj.toString());
        }

        if (obj != null && obj.getClass().isArray()) {
            return ListUtil.isNullOrEmpty((Object[]) obj);
        }

        return obj.equals(null);
    }
}