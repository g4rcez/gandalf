package io.vandalvnl.rules;

import static io.vandalvnl.utils.RegexMasks.BASE64;
import static io.vandalvnl.utils.Strings.regex;

public class Base64Rule extends GandalfRule implements Rule {

    public Boolean validate(Object value) {
        return String.valueOf(value).length() % 4 == 0 && regex(value, BASE64);
    }
}
