package io.vandalvnl.rules;

public class FalseRule extends GandalfRule implements Rule {

    public Boolean validate(Object value) {
        return !Boolean.parseBoolean(String.valueOf(value));
    }
}
