package io.vandalvnl.rules;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatRule extends GandalfRule implements RuleCompare {

    DateFormatRule(Object comparator) {
        this.comparator = comparator;
    }

    public Boolean validate(Object object, Object comparator) {
        String value = String.valueOf(object);
        String format = String.valueOf(comparator);
        Date date;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            return false;
        }
        return date != null;
    }
}
