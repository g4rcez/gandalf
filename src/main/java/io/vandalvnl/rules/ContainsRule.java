package io.vandalvnl.rules;

public class ContainsRule extends GandalfRule implements RuleCompare {

    ContainsRule(Object comparator) {
        this.comparator = comparator;
    }

    public Boolean validate(Object value, Object comparator) {
        return String.valueOf(value).contains(String.valueOf(comparator));
    }
}
