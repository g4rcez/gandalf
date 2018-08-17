package io.vandalvnl;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RegexCreator {
    private StringBuilder regex = new StringBuilder();

    public static String escapeRegex(String regex) {
        String escape = "\\\\\\";
        return regex
                .replaceAll("\\[", escape + "[")
                .replaceAll("]", escape + "]")
                .replaceAll("\\{", escape + "{")
                .replaceAll("}", escape + "}")
                .replaceAll("\\(", escape + "(")
                .replaceAll("\\)", escape + ")")
                .replaceAll("\\+", escape + "+")
                .replaceAll("\\$", escape + "$")
                .replaceAll("\\^", escape + "^")
                .trim();
    }

    public static String allASCIIAlphabet() {
        return "[A-Za-z]";
    }

    public static String allUpperCase() {
        return "[A-ZÁÃÀÉẼÈÍĨÌÓÕÒÚŨÙ]";
    }

    public static String allLowerCase() {
        return "[a-záãàéẽèíĩìóõòúũù]";
    }

    public static String allAlphabet() {
        return "[A-Za-záÁãÃàÀéÉẽẼèÈíÍĩĨìÌóÓõÕòÒúÚũŨùÙ]";
    }

    public static String allNumbers() {
        return "[0-9]";
    }

    public static String oneTime() {
        return "{1}";
    }

    public static String oneOrMore() {
        return "+";
    }

    public static String all() {
        return ".*";
    }

    public static String any() {
        return ".";
    }

    public static String rangeTimes(final int first, final int last) {
        return "{" + String.valueOf(first) + "," + String.valueOf(last) + "}";
    }

    public static String moreTimes(final int first) {
        return "{" + String.valueOf(first) + ",}";
    }

    public static String thisChars(final String chars) {
        return "[" + chars + "]";
    }

    public static String rangeChars(final char first, final char last) {
        return last < first ?
                "[" + last + "-" + first + "]" :
                "[" + first + "-" + last + "]";
    }

    public static String thisOrOthers(final String... expressions) {
        StringBuilder string = new StringBuilder();
        string.append("(");
        for (String expr : expressions) {
            string.append(expr).append("|");
        }
        String returnString = string.append(")").toString();
        return !returnString.endsWith("|)") ?
                returnString :
                returnString.replaceAll("\\|\\)$", ")");
    }

    public static String concat(final String... expressions) {
        return Arrays.stream(expressions).collect(Collectors.joining());
    }

    public RegexCreator startsWith(final String string) {
        this.regex.append("^").append(string);
        return this;
    }

    public RegexCreator endsWith(final String string) {
        this.regex.append(string).append("$");
        return this;
    }

    public RegexCreator andThen(final String string) {
        this.regex.append(string);
        return this;
    }

    public String build() {
        String string = this.regex.toString();
        return string.endsWith("$") ? string : (string + "$");
    }

    public Boolean match(final String compare) {
        return compare.matches(this.build());
    }

    public Boolean match(final String... compare) {
        String secure = this.build();
        for (String test : compare) {
            if (!test.matches(secure)) {
                return false;
            }
        }
        return true;
    }

    public RegexCreator clear() {
        this.regex.delete(0, this.regex.length());
        return this;
    }
}
