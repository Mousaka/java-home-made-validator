import java.util.function.BooleanSupplier;

public class Validation {

   private BooleanSupplier validationTest;
   private String errorMsg;
   private boolean terminating;

   private Validation(final BooleanSupplier validationTest, final String errorMsg, final boolean terminating) {

      this.validationTest = validationTest;
      this.errorMsg = errorMsg;
      this.terminating = terminating;
   }

   public boolean terminating() {
      return terminating;
   }


   public static Validation of(BooleanSupplier validationTest, String errorMsg, boolean terminating){
      return new Validation(validationTest, errorMsg, terminating);
   }

   public BooleanSupplier validationTest() {
      return validationTest;
   }

   public String errorMsg() {
      return errorMsg;
   }
}
