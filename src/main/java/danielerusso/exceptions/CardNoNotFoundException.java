package danielerusso.exceptions;

public class CardNoNotFoundException extends RuntimeException {
    public CardNoNotFoundException(long cardNo) {
        super("There aren't loans on the card with number " + cardNo);
    }
}
