package danielerusso.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id, String type) {
        super(type + " with id " + id + " not found!");
    }
}