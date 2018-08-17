package io.vandalvnl.rules;

import io.vandalvnl.utils.RegexMasks;
import io.vandalvnl.utils.Strings;

public class IsoDatetimeRule extends GandalfRule implements Rule {

    public Boolean validate(Object value) {
        if (Strings.regex(value, RegexMasks.ISO_DATETIME)) {
            String[] date = String.valueOf(value).split("T")[0].split("-");
            return Strings.isLeap(date[0], date[1], date[2]);
        }
        return false;
    }
}
