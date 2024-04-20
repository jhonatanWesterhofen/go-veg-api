package goveg.domain.validate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import goveg.domain.utils.ListUtil;
import goveg.domain.utils.StringUtil;

public class ValidateUtil {

    private List<Object> listNull = new ArrayList<>();

    public List<Object> validateFields(Object obj, String fieldName) {

        if (isNullOrEmpty(obj)) {
            listNull.add(fieldName);

            return listNull;
        }
        return null;
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