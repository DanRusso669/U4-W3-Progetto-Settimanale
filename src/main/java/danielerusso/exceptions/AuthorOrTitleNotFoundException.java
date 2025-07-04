package danielerusso.exceptions;

public class AuthorOrTitleNotFoundException extends RuntimeException {
    public AuthorOrTitleNotFoundException(String query, String type) {
        super("There aren't records with " + type + " " + query);
    }
}
