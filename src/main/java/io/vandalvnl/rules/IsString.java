package io.vandalvnl.rules;

public class IsString extends GandalfRule implements Rule {

    public Boolean validate(Object value) {
        return value.getClass().getTypeName().endsWith("String");
    }
}
