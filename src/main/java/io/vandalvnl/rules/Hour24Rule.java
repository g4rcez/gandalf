package io.vandalvnl.rules;

import io.vandalvnl.utils.RegexMasks;
import io.vandalvnl.utils.Strings;

public class Hour24Rule extends GandalfRule implements Rule {

    public Boolean validate(Object value) {
        return Strings.regex(value, RegexMasks.HOUR);
    }
}
