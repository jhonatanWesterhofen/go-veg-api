package goveg.domain.utils;

import java.text.MessageFormat;

public class StringUtil {

    public static String stringFormat(String pattern, Object... arguments) {
        return MessageFormat.format(pattern, arguments);
    }

    public static boolean onlyNumbers(String str) {

        if (Utils.isNull(str)) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean onlyCaracteres(String str) {

        if (Utils.isNull(str)) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty() || str.equalsIgnoreCase("null");
    }
}