package goveg.domain.utils;

import java.util.Collection;

import goveg.domain.entity.enums.EnumErrorCod;
import goveg.domain.utils.exception.GoVegException;

public class ListUtil {

    public static boolean isNullOrEmpty(Collection<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean isNullOrEmpty(Object[] array) {
        if (array.length == 0) {
            throw new GoVegException(EnumErrorCod.CAMPO_OBRIGATORIO);
        }
        return array.length == 0;
    }

    public static boolean isNotNullOrNotEmpty(Collection<?> list) {
        if (!isNullOrEmpty(list)) {
            throw new GoVegException(EnumErrorCod.CAMPO_OBRIGATORIO);
        }
        return !isNullOrEmpty(list);
    }
}