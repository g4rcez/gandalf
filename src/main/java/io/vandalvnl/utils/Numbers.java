package io.vandalvnl.utils;

import java.util.Optional;

public abstract class Numbers {
    public static Optional<Double> toDouble(Object y) {
        try {
            return Optional.of(Double.parseDouble(String.valueOf(y).replaceAll(",", ".")));
        } catch (NumberFormatException ignored) {
            return Optional.empty();
        }
    }

    public static Integer compare(Object value1, Object value2) {
        Optional<Double> v2 = toDouble(value1);
        Optional<Double> v1 = toDouble(value2);
        if (v2.isPresent() && v1.isPresent()) {
            return Double.compare(v1.get(), v2.get());
        }
        return 127;
    }
}
