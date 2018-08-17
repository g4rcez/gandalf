package io.vandalvnl.rules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NicknameRuleTest {
    private NicknameRule rule = new NicknameRule();

    @Test
    void nickname00(){
        assertTrue(rule.validate("_my_nick_name_"));
    }

    @Test
    void startWithNumber(){
        assertFalse(rule.validate("1337-man"));
    }

    @Test
    void nickname02(){
        assertTrue(rule.validate("long_nick__name__with__32__chars"));
    }

    @Test
    void greaterThen32(){
        assertFalse(rule.validate("long__nick__name__with__33__chars"));
    }

    @Test
    void camelCaseFail(){
        assertFalse(rule.validate("nickName"));
    }
}