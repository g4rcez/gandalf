package io.vandalvnl;

import com.google.gson.Gson;
import io.vandalvnl.messages.GandalfLogger;
import io.vandalvnl.messages.Messenger;
import io.vandalvnl.rules.GandalfRule;
import io.vandalvnl.rules.Rule;
import io.vandalvnl.rules.RuleCompare;
import io.vandalvnl.rules.Rules;
import io.vandalvnl.utils.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GandalfValidator {
    private HashMap<String, HashMap<String, GandalfLogger>> validators = new HashMap<>();
    private Boolean alreadyVerify = false;

    public void cleanValidations() {
        if (alreadyVerify) this.validators.clear();
    }

    public GandalfValidator validate(String chainKey, Object value, Rules rules) {
        HashMap<String, GandalfLogger> loggers = new HashMap<>();
        rules.all().forEach(rule -> {
            String key = Strings.class2Key(rule.getClass());
            GandalfLogger logger = new GandalfLogger().setValue(value).setKey(key)
                    .setValid(forRule(value, rule))
                    .setCompare(rule.getComparator())
                    .setMessage(rules.getMapMessage().get(Messenger.value(key)));
            loggers.put(key, logger);
        });
        validators.put(chainKey, loggers);
        return this;
    }

    public Boolean allRight() {
        alreadyVerify = true;
        return validators.entrySet().stream().filter(this::hasErrors)
                .collect(Collectors.toList()).size() == validators.size();
    }

    public Boolean hasError() {
        return !allRight();
    }

    public String jsonErrors() {
        return new Gson().toJson(errors());
    }

    public HashMap<String, HashMap<String, GandalfLogger>> errors() {
        HashMap<String, HashMap<String, GandalfLogger>> loggers = new HashMap<>();
        validators.entrySet().forEach(entry -> entry.getValue().forEach((key, value) -> {
            if (!value.getValid()) {
                HashMap<String, GandalfLogger> map = getHashMap(loggers, entry);
                map.put(key, value);
                loggers.put(entry.getKey(), map);
            }
        }));
        return loggers;
    }

    public HashMap<String, HashMap<String, GandalfLogger>> logs() {
        HashMap<String, HashMap<String, GandalfLogger>> loggers = new HashMap<>();
        validators.entrySet().forEach(entry -> entry.getValue().forEach((key, value) -> {
            HashMap<String, GandalfLogger> map = getHashMap(loggers, entry);
            map.put(key, value);
            loggers.put(entry.getKey(), map);
        }));
        return loggers;
    }

    public String jsonLogs() {
        return new Gson().toJson(logs());
    }

    private HashMap<String, GandalfLogger> getHashMap(HashMap<String, HashMap<String, GandalfLogger>> loggers,
                                                      Map.Entry<String, HashMap<String, GandalfLogger>> map) {
        return loggers.get(map.getKey()) == null ?
                new HashMap<>() : loggers.get(map.getKey());
    }

    private Boolean hasErrors(Map.Entry<String, HashMap<String, GandalfLogger>> stream) {
        return stream.getValue().entrySet().stream()
                .filter(y -> y.getValue().getValid())
                .collect(Collectors.toList()).size() == stream.getValue().size();
    }

    private boolean forRule(Object value, GandalfRule rule) {
        if (rule.compareIsNull()) return rule.validate((Rule) rule, value);
        return rule.validate((RuleCompare) rule, value);
    }
}
