package io.vandalvnl.messages;


import java.util.Arrays;

public enum Messenger {
    Blank {
        @Override
        public String rule() {
            return "blank";
        }
    },
    Json {
        @Override
        public String rule() {
            return "isJson";
        }
    },
    DateFormat {
        @Override
        public String rule() {
            return "dateFormat";
        }
    },
    False {
        @Override
        public String rule() {
            return "false";
        }
    },
    True {
        @Override
        public String rule() {
            return "true";
        }
    },
    BrDate {
        @Override
        public String rule() {
            return "brDate";
        }
    },
    Card {
        @Override
        public String rule() {
            return "card";
        }
    },
    Cep {
        @Override
        public String rule() {
            return "cep";
        }
    },
    Cnpj {
        @Override
        public String rule() {
            return "cnpj";
        }
    },
    Cpf {
        @Override
        public String rule() {
            return "cpf";
        }
    },
    Email {
        @Override
        public String rule() {
            return "email";
        }
    },
    Empty {
        @Override
        public String rule() {
            return "empty";
        }
    },
    Equals {
        @Override
        public String rule() {
            return "equals";
        }
    },
    Gandalf {
        @Override
        public String rule() {
            return "gandalf";
        }
    },
    GreaterThan {
        @Override
        public String rule() {
            return "greaterThan";
        }
    },
    GreaterThanOrEqual {
        @Override
        public String rule() {
            return "greaterThanOrEqual";
        }
    },
    Hour24 {
        @Override
        public String rule() {
            return "hour24";
        }
    },
    Http {
        @Override
        public String rule() {
            return "http";
        }
    },
    Ipv4 {
        @Override
        public String rule() {
            return "ipv4";
        }
    },
    Ipv6 {
        @Override
        public String rule() {
            return "ipv6";
        }
    },
    IsoDate {
        @Override
        public String rule() {
            return "isoDate";
        }
    },
    IsoDatetime {
        @Override
        public String rule() {
            return "isoDatetime";
        }
    },
    Length {
        @Override
        public String rule() {
            return "length";
        }
    },
    LessThan {
        @Override
        public String rule() {
            return "lessThan";
        }
    },
    LessThanOrEqual {
        @Override
        public String rule() {
            return "lessThanOrEqual";
        }
    },
    MaxLength {
        @Override
        public String rule() {
            return "maxLength";
        }
    },
    MaxOrEqualsLength {
        @Override
        public String rule() {
            return "maxOrEqualsLength";
        }
    },
    MinLength {
        @Override
        public String rule() {
            return "minLength";
        }
    },
    MinOrEqualsLength {
        @Override
        public String rule() {
            return "minOrEqualsLength";
        }
    },
    Must {
        @Override
        public String rule() {
            return "must";
        }
    },
    Negative {
        @Override
        public String rule() {
            return "negative";
        }
    },
    Nickname {
        @Override
        public String rule() {
            return "nickname";
        }
    },
    Number {
        @Override
        public String rule() {
            return "number";
        }
    },
    NumberType {
        @Override
        public String rule() {
            return "numberType";
        }
    },
    Password {
        @Override
        public String rule() {
            return "password";
        }
    },
    Positive {
        @Override
        public String rule() {
            return "positive";
        }
    },
    Regex {
        @Override
        public String rule() {
            return "regex";
        }
    };

    Messenger() {
    }

    public static Messenger value(String value) {
        return Arrays.stream(Messenger.values()).filter(x -> x.rule().equals(value))
                .findFirst().orElse(null);
    }

    public abstract String rule();
}
