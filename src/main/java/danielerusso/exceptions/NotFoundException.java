package danielerusso.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("Record with id " + id + " not found!");
    }
}