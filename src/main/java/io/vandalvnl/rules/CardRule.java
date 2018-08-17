package io.vandalvnl.rules;

import io.vandalvnl.utils.RegexMasks;
import io.vandalvnl.utils.Strings;

public class CardRule extends GandalfRule implements Rule {

    @Override
    public Boolean validate(Object value) {
        if (Strings.regex(value, RegexMasks.CARD)) {
            String[] string = Strings.replaceNonNumbers(value).split("");
            int sum = 0;
            for (int i = 0; i < string.length; i++) {
                int digit = Integer.parseInt(string[string.length - i - 1]);
                if (i % 2 == 1) digit *= 2;
                sum += digit > 9 ? digit - 9 : digit;
            }
            return sum % 10 == 0;
        }
        return false;
    }
}
