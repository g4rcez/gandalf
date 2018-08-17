package io.vandalvnl.rules;

import io.vandalvnl.utils.Strings;

public class RegexRule extends GandalfRule implements RuleCompare {

    RegexRule(Object comparator) {
        this.comparator = comparator;
    }

    public Boolean validate(Object value, Object comparator) {
        return Strings.regex(String.valueOf(value), String.valueOf(comparator));
    }
}
