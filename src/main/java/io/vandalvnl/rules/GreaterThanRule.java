package io.vandalvnl.rules;

import io.vandalvnl.utils.Numbers;

public class GreaterThanRule extends GandalfRule implements RuleCompare {
    GreaterThanRule(Object comparator) {
        this.comparator = comparator;
    }

    @Override
    public Boolean validate(Object value, Object comparator) {
        return Numbers.compare(value, comparator).equals(-1);
    }
}
