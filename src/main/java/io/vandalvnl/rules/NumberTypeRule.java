package io.vandalvnl.rules;

public class NumberTypeRule extends GandalfRule implements Rule {

    @Override
    public Boolean validate(Object value) {
        String[] s = value.getClass().getSuperclass().toString().split("\\.");
        return s[s.length - 1].equals("Number");
    }
}
