package io.vandalvnl.rules;

public class IsNumber extends GandalfRule implements Rule {

    public Boolean validate(Object value) {
        return value.getClass().getSuperclass().getName().endsWith("Number");
    }
}
