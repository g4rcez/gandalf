package io.vandalvnl.rules;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class IsJson extends GandalfRule implements Rule {

    public Boolean validate(Object value) {
        try {
            new Gson().fromJson(String.valueOf(value), Object.class);
            return true;
        } catch (JsonSyntaxException ignored) {
            return false;
        }
    }
}
