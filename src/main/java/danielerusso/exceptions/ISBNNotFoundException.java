package danielerusso.exceptions;

public class ISBNNotFoundException extends RuntimeException {
    public ISBNNotFoundException(long ISBN) {
        super("Record with ISBN code " + ISBN + " not found!");
    }
}