package danielerusso.exceptions;

public class YearNotFoundException extends RuntimeException {
    public YearNotFoundException(int year) {
        super("There aren't records with year " + year);
    }
}
