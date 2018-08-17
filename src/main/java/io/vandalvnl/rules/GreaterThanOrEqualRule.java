package io.vandalvnl.rules;

import io.vandalvnl.utils.Numbers;

public class GreaterThanOrEqualRule extends GandalfRule implements RuleCompare {

    GreaterThanOrEqualRule(Object comparator) {
        this.comparator = comparator;
    }

    @Override
    public Boolean validate(Object value, Object comparator) {
        Integer compare = Numbers.compare(value, comparator);
        return compare.equals(-1) || compare.equals(0);
    }
}
