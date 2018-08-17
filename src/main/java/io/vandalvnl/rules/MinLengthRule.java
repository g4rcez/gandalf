package io.vandalvnl.rules;

import io.vandalvnl.utils.Numbers;

public class MinLengthRule extends GandalfRule implements RuleCompare {

    MinLengthRule(Object comparator) {
        this.comparator = comparator;
    }

    public Boolean validate(Object value, Object comparator) {
        Integer string = String.valueOf(value).length();
        Integer compare = Numbers.compare(string, comparator);
        return compare.equals(-1);
    }
}
