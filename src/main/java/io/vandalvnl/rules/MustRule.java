package io.vandalvnl.rules;

public class MustRule extends GandalfRule implements RuleCompare {

    MustRule(Object comparator) {
        this.comparator = comparator;
    }

    public Boolean validate(Object value, Object comparator) {
        return Boolean.parseBoolean(String.valueOf(comparator));
    }
}
