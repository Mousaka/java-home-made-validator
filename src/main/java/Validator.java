import java.util.List;

public class Validator {

   public static ValidationResult validateAll(List<Validation> validations) {
      return validations.stream().sequential()
                        .reduce(new ValidationResult(),
                                ValidationResult::validate,
                                (result1, result2) -> result1); //Not sure about this. I think it makes it not work in parallel.
   }
}
