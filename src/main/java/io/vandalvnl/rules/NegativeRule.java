package io.vandalvnl.rules;

import io.vandalvnl.utils.Numbers;

public class NegativeRule extends GandalfRule implements Rule{

    @Override
    public Boolean validate(Object value) {
        return Numbers.compare(value, 0) == -1;
    }
}
