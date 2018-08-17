package io.vandalvnl.rules;

import io.vandalvnl.utils.RegexMasks;
import io.vandalvnl.utils.Strings;

public class CpfRule extends GandalfRule implements Rule {

    public Boolean validate(Object value) {
        String string = String.valueOf(value);
        if (string.matches(RegexMasks.CPF)) {
            String cpf = Strings.replaceNonNumbers(string);
            if (cpf.length() != 11 || cpf.equals("00000000000")) {
                return false;
            }
            char verify0, verify1;
            int totalSum = 0, i = 0, r, num, weight = 10;
            for (; i < 9; i++) {
                num = cpf.charAt(i) - 48;
                totalSum = totalSum + num * weight;
                weight--;
            }
            r = 11 - totalSum % 11;
            if (r == 10 || r == 11) {
                verify0 = '0';
            } else {
                verify0 = (char) (r + 48);
            }
            totalSum = 0;
            weight = 11;
            for (i = 0; i < 10; i++) {
                num = cpf.charAt(i) - 48;
                totalSum = totalSum + num * weight;
                weight--;
            }
            r = 11 - totalSum % 11;
            if ((r == 10) || (r == 11)) {
                verify1 = '0';
            } else {
                verify1 = (char) (r + 48);
            }
            return (verify0 == cpf.charAt(9)) && (verify1 == cpf.charAt(10));
        }
        return false;
    }
}
