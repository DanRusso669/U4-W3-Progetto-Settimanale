package danielerusso.entities;

import java.time.LocalDate;

public class BookLoan {
    private long loan_id;
    private User user;
    private EditorialProduct product;
    private LocalDate loanStartDate;
    private LocalDate expectedReturnDate;
    private LocalDate returnDate;

    public BookLoan() {
    }

    ;

    public BookLoan(LocalDate loanStartDate, LocalDate returnDate) {
        this.loanStartDate = loanStartDate;
        this.expectedReturnDate = loanStartDate.plusDays(30);
        this.returnDate = returnDate;
    }

    ;
}
