package io.vandalvnl.rules;

import io.vandalvnl.utils.RegexMasks;
import io.vandalvnl.utils.Strings;

public class BrDateRule extends GandalfRule implements Rule {

    public Boolean validate(Object value) {
        if (Strings.regex(value, RegexMasks.BR_DATE_FORMAT)) {
            String[] date = String.valueOf(value).split("/");
            return Strings.isLeap(date[2], date[1], date[0]);
        }
        return false;
    }
}
