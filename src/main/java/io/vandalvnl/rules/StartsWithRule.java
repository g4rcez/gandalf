package io.vandalvnl.rules;

public class StartsWithRule extends GandalfRule implements RuleCompare {

    StartsWithRule(Object comparator) {
        this.comparator = comparator;
    }

    public Boolean validate(Object value, Object comparator) {
        return String.valueOf(value).startsWith(String.valueOf(comparator));
    }
}
