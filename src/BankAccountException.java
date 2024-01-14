public class BankAccountException extends Exception {
    public BankAccountException() {
        super("This bank account does not exist! Please enter a valid one.");
    }

    public BankAccountException(String s) {
        super(s);
    }

    public String getMessage() {
        return super.getMessage();
    }

}

