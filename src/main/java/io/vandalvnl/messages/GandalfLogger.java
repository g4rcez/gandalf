package io.vandalvnl.messages;

import io.vandalvnl.utils.Strings;

public class GandalfLogger {
    private String key;
    private Object value;
    private Boolean valid;
    private Object compare;
    private String message;

    public String getMessage() {
        return message;
    }

    public GandalfLogger setMessage(String message) {
        if (message != null) {
            message = message.replaceAll("%s", String.valueOf(value))
                    .replaceAll("%k", key).replaceAll("%K", Strings.pascalCase(key))
                    .replaceAll("%b", String.valueOf(valid))
                    .replaceAll("%c", String.valueOf(compare));
        }
        this.message = message;
        return this;
    }

    public Boolean getValid() {
        return valid;
    }

    public GandalfLogger setValid(Boolean valid) {
        this.valid = valid;
        return this;
    }

    public String getKey() {
        return key;
    }

    public GandalfLogger setKey(String key) {
        this.key = key;
        return this;
    }

    public Object getValue() {
        return value;
    }

    public GandalfLogger setValue(Object value) {
        this.value = value;
        return this;
    }

    public Object getCompare() {
        return compare;
    }

    public GandalfLogger setCompare(Object compare) {
        this.compare = compare;
        return this;
    }
}
