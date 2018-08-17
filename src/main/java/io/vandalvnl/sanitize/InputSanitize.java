package io.vandalvnl.sanitize;

public abstract class InputSanitize {
    public static String html(final String html) {
        return html.replaceAll("<[^>]*>", "");
    }
}
