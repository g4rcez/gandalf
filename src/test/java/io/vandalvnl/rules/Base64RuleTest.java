package io.vandalvnl.rules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Base64RuleTest {
    private Base64Rule base64 = new Base64Rule();

    @Test
    void base64Padding() {
        assertTrue(base64.validate("QUJDRAo="));
    }

    @Test
    void base64WithoutPadding() {
        assertTrue(base64.validate("SGVsbG8gV29ybGQKABDC"));
    }

    @Test
    void base64InvalidLength() {
        assertFalse(base64.validate("SGVsbG8gV29ybGQ"));
    }

    /**
     * Has a valid value
     */
    @Test
    void tryBase32() {
        assertTrue(base64.validate("IFBEGRAK"));
    }

    @Test
    void tryBase32Error() {
        assertFalse(base64.validate("JBAUGSZAKREEKICQJRAU4RKUEBKEKU2UBI======"));
    }

}