package io.vandalvnl.rules;

public class EmptyRule extends GandalfRule implements Rule {

    public Boolean validate(Object value) {
        return String.valueOf(value).isEmpty();
    }
}
