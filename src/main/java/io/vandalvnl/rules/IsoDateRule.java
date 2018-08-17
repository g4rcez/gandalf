package io.vandalvnl.rules;

import io.vandalvnl.utils.RegexMasks;
import io.vandalvnl.utils.Strings;

public class IsoDateRule extends GandalfRule implements Rule {


    public Boolean validate(Object value) {
        if (Strings.regex(value, RegexMasks.ISO_DATE)) {
            String[] date = String.valueOf(value).split("-");
            return Strings.isLeap(date[0], date[1], date[2]);
        }
        return false;
    }
}
