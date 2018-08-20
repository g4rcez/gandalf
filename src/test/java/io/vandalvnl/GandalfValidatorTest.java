package io.vandalvnl;

import io.vandalvnl.messages.Messenger;
import io.vandalvnl.rules.Rules;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GandalfValidatorTest {

    private GandalfValidator validator = new GandalfValidator();

    @Test
    void test00() {
        validator.validate("cpf", "070.680.938-68", Rules.New().cpf().messagesFor(Messenger.Cpf, "%k equals to %s, and is valid: %b"));
        assertTrue(validator.allRight());
        validator.cleanValidations();
    }

}