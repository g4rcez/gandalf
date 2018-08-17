package io.vandalvnl.rules;

import io.vandalvnl.utils.RegexMasks;
import io.vandalvnl.utils.Strings;

public class CnpjRule extends GandalfRule implements Rule {

    @Override
    public Boolean validate(Object value) {
        String string = String.valueOf(value);
        if (string.matches(RegexMasks.CPNJ)) {
            string = Strings.replaceNonNumbers(value);
            if (string.equals("00000000000") || (string.length() != 14)) return false;
            char[] code = string.toCharArray();
            char dig13, dig14;
            int sum = 0, i = 11, r, num, w = 2;
            for (; i >= 0; i--) {
                num = code[i] - 48;
                sum += (num * w);
                w += 1;
                if (w == 10) w = 2;
            }
            r = sum % 11;
            if ((r == 0) || (r == 1)) {
                dig13 = '0';
            } else {
                dig13 = (char) ((11 - r) + 48);
            }
            sum = 0;
            w = 2;
            for (i = 12; i >= 0; i--) {
                num = code[i] - 48;
                sum += (num * w);
                w += 1;
                if (w == 10) w = 2;
            }
            r = sum % 11;
            if ((r == 0) || (r == 1)) dig14 = '0';
            else dig14 = (char) ((11 - r) + 48);
            return (dig13 == code[12]) && (dig14 == code[13]);
        }
        return false;
    }
}
