import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
   boolean terminated;
   List<String> errors;

   ValidationResult() {
      terminated = false;
      errors = new ArrayList<>();
   }

   private ValidationResult(boolean terminated, List<String> errors) {
      this.terminated = terminated;
      this.errors = errors;
   }

   public ValidationResult validate(Validation validation) {
      if (!this.terminated) {
         if (validation.validationTest().getAsBoolean()) {
            return new ValidationResult(this.terminated, this.errors);
         } else {
            this.errors.add(validation.errorMsg());
            return new ValidationResult(validation.terminating(), this.errors);
         }
      } else {
         return new ValidationResult(this.terminated, this.errors);
      }
   }


   public List<String> errors() {
      return errors;
   }

   public boolean validationSuccess() {
      return errors.size() == 0;
   }
}
