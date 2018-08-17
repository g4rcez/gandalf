package io.vandalvnl.rules;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class TrueRule extends GandalfRule implements Rule {

    public Boolean validate(Object value) {
        return Boolean.parseBoolean(String.valueOf(value));
    }
}
