package io.vandalvnl.rules;

import io.vandalvnl.utils.Numbers;

public class MaxOrEqualsLengthRule extends GandalfRule implements RuleCompare {

    MaxOrEqualsLengthRule(Object comparator) {
        this.comparator = comparator;
    }

    public Boolean validate(Object value, Object comparator) {
        Integer string = String.valueOf(value).length();
        Integer compare = Numbers.compare(string, comparator);
        return compare.equals(1) || compare.equals(0);
    }
}
