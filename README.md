# Gandalf Validator

A little collection to help you define who can "PASS!!"

## Using

GandalfValidator is the main class to control all data to validate. You will use "Rules" class to specify all 
validations for your data. "Talk is cheap, show me the code":

```
User user = getUserById("imagine-uuid");
GandalfValidator gandalf = new GandalfValidator()
    .validate("cpf", user.cpf(), Rules.cpf()) 
    .validate("cpf", user.login(), Rules.username()) // unix rules
gandalf.allRight() // Return a boolean
gandalf.jsonErrors() // Return a string with all errors in the validations
```

## Validations

Coming Soon...Wait please

## ToDo

- Write the docs and JavaDoc
- Create tests
- Post on Maven/Gradle
- Maybe, on a remote day, write in Scala or Clojure