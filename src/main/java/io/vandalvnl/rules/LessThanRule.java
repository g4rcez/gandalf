package io.vandalvnl.rules;

import io.vandalvnl.utils.Numbers;

public class LessThanRule extends GandalfRule implements RuleCompare {
    LessThanRule(Object comparator) {
        this.comparator = comparator;
    }

    @Override
    public Boolean validate(Object value, Object comparator) {
        return Numbers.compare(value, comparator).equals(1);
    }
}
