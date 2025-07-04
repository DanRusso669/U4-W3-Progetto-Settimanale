package danielerusso.exceptions;

public class ExpiredLoanNotFoundException extends RuntimeException {
    public ExpiredLoanNotFoundException() {
        super("No expired loans were found.");
    }
}
