package io.vandalvnl.rules;

public class EqualsRule extends GandalfRule implements RuleCompare {

    EqualsRule(Object comparator) {
        this.comparator = comparator;
    }

    public Boolean validate(Object value, Object comparator) {
        return value.equals(comparator);
    }
}
