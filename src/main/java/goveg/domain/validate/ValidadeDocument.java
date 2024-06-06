package goveg.domain.validate;

import goveg.domain.entity.enums.EnumErrorCod;
import goveg.domain.utils.StringUtil;
import goveg.domain.utils.Utils;
import goveg.domain.utils.exception.GoVegException;

public class ValidadeDocument {

    String regex = "[^a-zA-Z0-9 ]";

    public void validate(String str) {

        if (!isCNPJ(str) && !isCPF(str)) {
            throw new GoVegException(EnumErrorCod.DOCUMENTO_INFORMADO_INVALIDO);
        }

        if (!isValidCNPJ(str) && !isValidCPF(str)) {
            throw new GoVegException(EnumErrorCod.DOCUMENTO_INFORMADO_INVALIDO);
        }

    }

    public boolean isCPF(String str) {

        if (StringUtil.onlyNumbers(str) && !Utils.isNull(str)) {
            return str.replaceAll(regex, "").length() == 11 ? true : false;
        }

        return false;
    }

    public boolean isCNPJ(String str) {
        if (StringUtil.onlyNumbers(str) && !Utils.isNull(str)) {
            return str.replaceAll(regex, "").length() == 14 ? true : false;
        }

        return false;
    }

    public boolean isValidCPF(String cpf) {

        if (cpf == null || cpf.length() != 11) {
            return false;
        }

        int[] digits = new int[11];
        for (int i = 0; i < 11; i++) {
            digits[i] = Integer.parseInt(cpf.substring(i, i + 1));
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += digits[i] * (10 - i);
        }
        int mod = sum % 11;
        int expectedDigit1 = (mod < 2) ? 0 : (11 - mod);

        if (digits[9] != expectedDigit1) {
            return false;
        }

        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += digits[i] * (11 - i);
        }
        mod = sum % 11;
        int expectedDigit2 = (mod < 2) ? 0 : (11 - mod);

        return (digits[10] == expectedDigit2);
    }

    public boolean isValidCNPJ(String cnpj) {

        if (cnpj == null || cnpj.length() != 14) {
            return false;
        }

        int[] digits = new int[14];
        for (int i = 0; i < 14; i++) {
            digits[i] = Integer.parseInt(cnpj.substring(i, i + 1));
        }

        int sum = 0;
        int factor = 5;
        for (int i = 0; i < 12; i++) {
            sum += digits[i] * factor;
            factor = (factor == 2) ? 9 : (factor - 1);
        }
        int mod = sum % 11;
        int expectedDigit1 = (mod < 2) ? 0 : (11 - mod);
        if (digits[12] != expectedDigit1) {
            return false;
        }
        sum = 0;
        factor = 6;
        for (int i = 0; i < 13; i++) {
            sum += digits[i] * factor;
            factor = (factor == 2) ? 9 : (factor - 1);
        }
        mod = sum % 11;
        int expectedDigit2 = (mod < 2) ? 0 : (11 - mod);
        return (digits[13] == expectedDigit2);
    }
}