package danielerusso.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "book_loans")
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loan_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "editorial_product_id")
    private EditorialProduct product;

    @Column(name = "loan_start_date")
    private LocalDate loanStartDate;
    @Column(name = "expected_return_date")
    private LocalDate expectedReturnDate;
    @Column(name = "return_date")
    private LocalDate returnDate;

    public BookLoan() {
    }

    ;

    public BookLoan(LocalDate loanStartDate, LocalDate returnDate, User user, EditorialProduct product) {
        this.loanStartDate = loanStartDate;
        this.expectedReturnDate = loanStartDate.plusDays(30);
        this.returnDate = returnDate;
        this.user = user;
        this.product = product;
    }

    ;
}
