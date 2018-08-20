package io.vandalvnl.utils;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumbersTest {
    @Test
    void testNull() {
        Optional<Double> optional = Numbers.toDouble(null);
        assertTrue(!optional.isPresent());
    }

    @Test
    void testDouble() {
        Optional<Double> optional = Numbers.toDouble(10);
        assertEquals(10d, optional.get(), 0.0);
    }

    @Test
    void testType() {
        Optional<Double> optional = Numbers.toDouble(10);
        assertEquals(10, (double) optional.get());
    }
}