package io.vandalvnl.rules;

public class BlankRule extends GandalfRule implements Rule {

    public Boolean validate(Object value) {
        return String.valueOf(value)
                .replaceAll("\r", "")
                .replaceAll("\n", "")
                .replaceAll("\t", "")
                .replaceAll(" ", "").isEmpty();
    }
}
