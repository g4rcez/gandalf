package io.vandalvnl.rules;

import io.vandalvnl.utils.RegexMasks;
import io.vandalvnl.utils.Strings;

public class UuidRule extends GandalfRule implements Rule {

    public Boolean validate(Object value) {
        return Strings.regex(value, RegexMasks.UUID);
    }
}
