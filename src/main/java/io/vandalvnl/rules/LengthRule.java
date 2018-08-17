package io.vandalvnl.rules;

import io.vandalvnl.utils.Numbers;

public class LengthRule extends GandalfRule implements RuleCompare {

    LengthRule(Object comparator) {
        this.comparator = comparator;
    }

    public Boolean validate(Object value, Object comparator) {
        String string = String.valueOf(value);
        return Numbers.compare(string.length(), comparator) == 0;
    }
}
