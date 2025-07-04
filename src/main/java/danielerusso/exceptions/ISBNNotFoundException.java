package danielerusso.exceptions;

public class ISBNNotFoundException extends RuntimeException {
    public ISBNNotFoundException(long ISBN) {
        super("Element with ISBN code " + ISBN + " not found!");
    }
}