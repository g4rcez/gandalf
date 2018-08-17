package io.vandalvnl.rules;

public class GandalfRule {
    Object comparator = null;

    public Boolean compareIsNull() {
        return this.comparator == null;
    }

    public Object getComparator() {
        return this.comparator;
    }

    public Boolean validate(Rule rule, Object value) {
        return rule.validate(value);
    }

    public Boolean validate(RuleCompare rule, Object value) {
        return rule.validate(value, this.comparator);
    }
}
