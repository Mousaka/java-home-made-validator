import java.util.List;
import java.util.function.BooleanSupplier;

import static java.util.Arrays.asList;

public class Main {

   public static void main(String args[]) {
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
   }
}
