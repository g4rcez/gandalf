package io.vandalvnl.rules;

public class EndsWithRule extends GandalfRule implements RuleCompare {

    EndsWithRule(Object comparator) {
        this.comparator = comparator;
    }

    public Boolean validate(Object value, Object comparator) {
        return String.valueOf(value).endsWith(String.valueOf(comparator));
    }
}
