# java-home-made-validator
A simple data validator library - Made for fun and learning in a rush and should probably not be used in production!

Can remove the need of a lot of if-statements when validating stuff.
A validation can be marked as terminating which means that the validator should stop doing any further validations.

Example:
```java
      int number = 10;

      final BooleanSupplier biggerThanOne = () -> number > 1;
      final BooleanSupplier smallerThan8 = () -> number < 8;
      final BooleanSupplier divisibleBy11 = () -> number % 11 == 0;
      final BooleanSupplier is4 = () -> number == 4;

      final List<Validation> validations =
              asList(
                      Validation.of(biggerThanOne, "must be bigger than 1", true)
                      , Validation.of(smallerThan8, "must smaller than 8", false)
                      , Validation.of(divisibleBy11, "REALLY MUST be divisible by 11", true)
                      , Validation.of(is4, "number must be 4", false)  //never run
              );

      final ValidationResult validationResult = Validator.validateAll(validations);
      System.out.println("Validations succeeded: " + validationResult.validationSuccess());
      validationResult.errors().stream().forEach(System.out::println);
```
Output:
```
Validations succeeded: false
must smaller than 8
REALLY MUST be divisible by 11
```
