package io.vandalvnl.rules;

import io.vandalvnl.messages.Messenger;

import java.util.ArrayList;
import java.util.HashMap;

public class Rules {
    private HashMap<Messenger, String> mapMessage;
    private ArrayList<GandalfRule> rules = new ArrayList<>();

    public Rules() {
        mapMessage = new HashMap<>();
    }

    public static Rules obj() {
        return new Rules();
    }

    public static Rules New() {
        return new Rules();
    }

    public HashMap<Messenger, String> getMapMessage() {
        return mapMessage;
    }

    public Rules messagesFor(Messenger key, String value) {
        this.mapMessage.put(key, value);
        return this;
    }

    public Rules blank() {
        rules.add(new BlankRule());
        return this;
    }

    public Rules brDate() {
        rules.add(new BrDateRule());
        return this;
    }

    public Rules card() {
        rules.add(new CardRule());
        return this;
    }

    public Rules cep() {
        rules.add(new CepRule());
        return this;
    }

    public Rules cnpj() {
        rules.add(new CnpjRule());
        return this;
    }

    public Rules cpf() {
        rules.add(new CpfRule());
        return this;
    }

    public Rules email() {
        rules.add(new EmailRule());
        return this;
    }

    public Rules empty() {
        rules.add(new EmptyRule());
        return this;
    }

    public Rules equalsTo(Object value) {
        rules.add(new EqualsRule(value));
        return this;
    }

    public Rules greaterThanOrEqual(Object value) {
        rules.add(new GreaterThanOrEqualRule(value));
        return this;
    }

    public Rules greaterThan(Object value) {
        rules.add(new GreaterThanRule(value));
        return this;
    }

    public Rules hour24() {
        rules.add(new Hour24Rule());
        return this;
    }

    public Rules http() {
        rules.add(new HttpRule());
        return this;
    }

    public Rules ipv4() {
        rules.add(new Ipv4Rule());
        return this;
    }

    public Rules ipv6() {
        rules.add(new Ipv6Rule());
        return this;
    }

    public Rules isoDate() {
        rules.add(new IsoDateRule());
        return this;
    }

    public Rules isoDatetime() {
        rules.add(new IsoDatetimeRule());
        return this;
    }

    public Rules length(Object value) {
        rules.add(new LengthRule(value));
        return this;
    }

    public Rules lessThanOrEqual(Object value) {
        rules.add(new LessThanOrEqualRule(value));
        return this;
    }

    public Rules lessThan(Object value) {
        rules.add(new LessThanRule(value));
        return this;
    }

    public Rules maxLength(Object value) {
        rules.add(new MaxLengthRule(value));
        return this;
    }

    public Rules maxOrEqualsLength(Object value) {
        rules.add(new MaxOrEqualsLengthRule(value));
        return this;
    }

    public Rules minLength(Object value) {
        rules.add(new MinLengthRule(value));
        return this;
    }

    public Rules minOrEqualsLength(Object value) {
        rules.add(new MinOrEqualsLengthRule(value));
        return this;
    }

    public Rules must(Object value) {
        rules.add(new MustRule(value));
        return this;
    }

    public Rules negative() {
        rules.add(new NegativeRule());
        return this;
    }

    public Rules nickname() {
        rules.add(new NicknameRule());
        return this;
    }

    public Rules number() {
        rules.add(new NumberRule());
        return this;
    }

    public Rules numberType() {
        rules.add(new NumberTypeRule());
        return this;
    }

    public Rules uuid() {
        rules.add(new UuidRule());
        return this;
    }

    public Rules jwt() {
        rules.add(new JwtRule());
        return this;
    }

    public Rules password() {
        rules.add(new PasswordRule());
        return this;
    }

    public Rules positive() {
        rules.add(new PositiveRule());
        return this;
    }

    public Rules regex(Object value) {
        rules.add(new RegexRule(value));
        return this;
    }

    public Rules json() {
        rules.add(new IsJson());
        return this;
    }

    public Rules isTrue() {
        rules.add(new TrueRule());
        return this;
    }

    public Rules dateFormat(Object compare){
        rules.add(new DateFormatRule(compare));
        return this;
    }

    public Rules isFalse() {
        rules.add(new FalseRule());
        return this;
    }

    public Rules base64() {
        rules.add(new Base64Rule());
        return this;
    }

    public Rules isString() {
        rules.add(new IsString());
        return this;
    }

    public Rules isNumber() {
        rules.add(new IsNumber());
        return this;
    }

    public Rules endsWith(Object value) {
        rules.add(new EndsWithRule(value));
        return this;
    }

    public Rules contains(Object value) {
        rules.add(new ContainsRule(value));
        return this;
    }

    public Rules startsWith(Object value) {
        rules.add(new StartsWithRule(value));
        return this;
    }

    public ArrayList<GandalfRule> all() {
        return this.rules;
    }
}
