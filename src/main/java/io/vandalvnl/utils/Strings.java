package io.vandalvnl.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Strings {
    private static final String ALL_SPECIAL_UPPER_CASE = "A-ZÇÁÀÃÂÉÈẼÊÌÍĨÎÕÓÒÔŨÚÙÜÛ.";
    private static final String ALL_SPECIAL_LOWER_CASE = "a-zçáàãâéèẽêìíĩîõóòôũúùüû.";
    private static final String REGEX_ALL_UPPER_CASE = "[" + ALL_SPECIAL_UPPER_CASE + "]";
    private static final String REGEX_ALL_LOWER_CASE = "[" + ALL_SPECIAL_LOWER_CASE + "]";

    public static String replaceNonNumbers(final Object string) {
        return String.valueOf(string).replaceAll("[^0-9]", "");
    }

    public static boolean regex(Object string, String regex) {
        return String.valueOf(string).matches(regex);
    }

    public static String class2Key(Class clazz) {
        String[] split = clazz.getName().split("\\.");
        String string = split[split.length - 1].replaceAll("Rule", "");
        return camelCase(string);
    }

    public static String pascalCase(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        Matcher matcher = matcher(string);
        while (matcher.find())
            stringBuilder.append(matcher.group(0).substring(0, 1).toUpperCase())
                    .append(matcher.group(0).substring(1).toLowerCase());
        return String.valueOf(stringBuilder).trim();
    }

    public static String camelCase(String string) {
        String camelCase = pascalCase(string);
        return camelCase.substring(0, 1).toLowerCase()
                .concat(camelCase.substring(1));
    }

    private static Matcher matcher(String string) {
        return Pattern.compile(REGEX_ALL_UPPER_CASE +
                "{2,}(?=" + REGEX_ALL_UPPER_CASE + REGEX_ALL_LOWER_CASE +
                "+[0-9]*|\\b)|" + REGEX_ALL_UPPER_CASE + "?" + REGEX_ALL_LOWER_CASE
                + "+[0-9]*|" + REGEX_ALL_UPPER_CASE + "|[0-9]+").matcher(string);
    }

    public static Boolean isLeap(String year, String mouth, String day) {
        if (mouth.equals("02") && Integer.valueOf(year) % 4 == 0) return Integer.valueOf(day) <= 29;
        else if (mouth.equals("02") && Integer.valueOf(year) % 4 != 0) return Integer.valueOf(day) <= 28;
        return true;
    }
}
