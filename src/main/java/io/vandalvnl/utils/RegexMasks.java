package io.vandalvnl.utils;

public interface RegexMasks {
    /**
     * For Base32 and Base64, I read the RFC 4648: http://www.ietf.org/rfc/rfc4648.txt
     */
    String BASE32 = "^(?:[A-Z2-7]{8})*(?:[A-Z2-7]{2}={6}|[A-Z2-7]{4}={4}|[A-Z2-7]{5}={3}|[A-Z2-7]{7}=)?$";
    String BASE64 = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$";

    /**
     * After read the rules brazilian calendar, I made this regex. Some tests in Regex101:
     * https://regex101.com/r/VNSBOa/1
     */
    String BR_DATE_FORMAT = "^(((0[1-9]|1\\d|2\\d|3[01])/(0[13578]|1[02])|(0[1-9]|1\\d|2\\d|30)/(0[469]|11))|" +
            "(0[1-9]|1\\d|2[0-9])/((|0)2))/[12]\\d{3}$";
    /**
     * After 10 cards, I build this regex, according by https://en.wikipedia.org/wiki/Payment_card_number
     */
    String CARD = "^(\\d{4}(| )){3}\\d{4}$";
    /**
     * The ZipCode in Brazil
     */
    String CEP = "\\d{5}(|-| - )\\d{3}";
    /**
     * A document. CNPJ == Cadastro Nacional da Pessoa Jurídica
     */
    String CPNJ = "^\\d{2}((|\\.)\\d{3}){2}(|/)\\d{4}(|-)\\d{2}$";
    /**
     * A document. CPF == Cadastro de Pessoa Física
     */
    String CPF = "^((\\d{3})(|\\.)){2}(\\d{3})(|-)\\d{2}$";
    /**
     * The same regex of W3C <input type="email" />
     * http://emailregex.com/
     * https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input/email#Basic_validation
     */
    String EMAIL = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
    /**
     * Pattern used in some countries, 24:59?:59. Seconds are optional
     */
    String HOUR = "^([01]\\d|2[0-3]):[0-5]\\d(:[0-5]\\d)?$";
    /**
     * By according the RFC 5988 https://tools.ietf.org/html/rfc5988
     */
    String HTTP = "^(http(|s):\\/\\/)(?:\\S+(?::\\S*)?@)?(?:(?!(?:10|127)(?:\\.\\d{1,3}){3})(?!(?:169\\.254|192\\.168)(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z\\u00a1-\\uffff0-9]-*)*[a-z\\u00a1-\\uffff0-9]+)(?:\\.(?:[a-z\\u00a1-\\uffff0-9]-*)*[a-z\\u00a1-\\uffff0-9]+)*(?:\\.(?:[a-z\\u00a1-\\uffff]{2,}))\\.?)(?::\\d{2,5})?(?:[/?#]\\S*)?$";
    /**
     * IPV4 masks, prevent validate the octets greater then 255. Read some rules in https://en.wikipedia.org/wiki/IPv4
     * and inspired by http://aurelio.net/regex/casar-ip.html
     */
    String IPV4 = "^(((1\\d|[1-9]?)\\d|2([0-4]\\d|5[0-5]))\\.){3}((1\\d|[1-9]?)\\d|2([0-4]\\d|5[0-5]))$";
    /**
     * IPV6 mask. Reading the https://www.ietf.org/rfc/rfc2732.txt and https://www.ietf.org/rfc/rfc2460.txt.
     * After some researches in Stack Overflow, the result is this
     */
    String IPV6 = "^(([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}\\d){0,1}\\d)\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}\\d){0,1}\\d)|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}\\d){0,1}\\d)\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}\\d){0,1}\\d))$";
    /**
     * Just match a pattern of ISO. Extract by ISO 8601:
     * http://support.sas.com/documentation/cdl/en/lrdict/64316/HTML/default/viewer.htm#a003169814.htm
     */
    String ISO_DATE = "^\\d{4}-(0[13578]-([012]\\d|3[01])|0[469]-([012]\\d|30)|02-([012]\\d))$";
    String ISO_DATETIME = "^\\d{4}-(0[13578]-([012]\\d|3[01])|0[469]-([012]\\d|30)|02-([012]\\d))T([01]\\d|2[0-4])(:[0-5]\\d){2}($|:\\d{6})$";
    /**
     * JWT is just a concat with 3 Base64 encodedURL
     */
    String JWT = "^[a-zA-Z0-9\\-_]+?\\.[a-zA-Z0-9\\-_]+?\\.([a-zA-Z0-9\\-_]+)?$";
    /**
     * Rules for username in *Unix:  lower case letters, digits, underscores, or dashes
     */
    String USERNAME = "^[a-z_]([a-z0-9_-]{0,31})?$";
    /**
     * The famous "SECURE PASSWORD", I tried all the characters to enable a "SECURE PASSWORD"
     * Two or more Upper chars A-Z
     * Two or more lower chars a-z
     * Two or more numbers
     * One or more special char: !@#$&*_-%¬¨=§~^/.;:`´{}()]["'<>,ºª°
     * And the length of password must be greater than 8 chars
     */
    String PASSWORD = "^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*_-%¬¨=§~^/.;:`´{}()][\"'<>,ºª°])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8,}$";
    /**
     * The UUID, rules in: https://en.wikipedia.org/wiki/Universally_unique_identifier
     * and I tried to match "all" patterns of https://uuidgenerator.net
     */
    String UUID = "^[a-f0-9]{8}(-[a-f0-9]{4}){3}-[a-f0-9]{12}$";
}
