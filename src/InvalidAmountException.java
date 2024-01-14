public class InvalidAmountException extends BankAccountException {

        public InvalidAmountException() {
                super("The amount is invalid! Please enter a valid one.");
        }

        public InvalidAmountException(String s) {
                super(s);
        }

        public String getMessage() {
                return super.getMessage();
        }

        }
