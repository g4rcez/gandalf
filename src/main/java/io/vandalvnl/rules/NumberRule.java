package io.vandalvnl.rules;

public class NumberRule extends GandalfRule implements Rule {
    @Override
    public Boolean validate(Object value) {
        String string = String.valueOf(value);
        if (string.contains(".") || string.contains(",")) {
            return num(string.replaceAll("\\.", "").replaceAll(",", ""));
        }
        return num(string);
    }

    private Boolean num(String string) {
        return string.chars().allMatch(Character::isDigit);
    }
}
