package io.vandalvnl.rules;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UuidRuleTest {
    private UuidRule rule = new UuidRule();
    @Test
    void uuid4() {
        assertTrue(rule.validate("615a1818-e162-48f2-805c-4283d2021736"));
    }

    @Test
    void uuid1(){
        assertTrue(rule.validate("67adf288-a0da-11e8-98d0-529269fb1459"));
    }

    @Test
    void guid(){
        assertTrue(rule.validate("0385fc3a-00bc-42a7-9855-9fef72d2a65d"));
    }

    @Test
    void randomUuid(){
        assertTrue(rule.validate(UUID.randomUUID()));
    }

    @Test
    void invalidate00(){
        assertFalse(rule.validate("0385fc3a-00bc-42A7_9855-9fef72d2a65d"));
    }

    @Test
    void invalidate01(){
        assertFalse(rule.validate("0385fc3a-00bc-42A7-9855-9fef72d2a65d"));
    }

}