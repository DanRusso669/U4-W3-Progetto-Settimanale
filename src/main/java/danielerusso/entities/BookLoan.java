package danielerusso.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "book_loans")

//@NamedQuery(name = "findByCardNo", query = "SElECT bl FROM BookLoan bl WHERE user.card_number = ")

public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loan_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Bisogna guardare alla vita totale dell'elemento e non al momento specifico.
    // Un libro può avere più prestiti, semplicemente non nello stesso momento.
    // @OneToOne è quindi sbagliato concettualmente.
    @ManyToOne
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

    public BookLoan(LocalDate loanStartDate, LocalDate returnDate, User user, EditorialProduct product) {
        this.loanStartDate = loanStartDate;
        this.expectedReturnDate = loanStartDate.plusDays(30);
        this.returnDate = returnDate;
        this.user = user;
        this.product = product;
    }

    public long getLoan_id() {
        return loan_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EditorialProduct getProduct() {
        return product;
    }

    public void setProduct(EditorialProduct product) {
        this.product = product;
    }

    public LocalDate getLoanStartDate() {
        return loanStartDate;
    }

    public void setLoanStartDate(LocalDate loanStartDate) {
        this.loanStartDate = loanStartDate;
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(LocalDate expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BookLoan{" +
                "loan_id=" + loan_id +
                ", user=" + user +
                ", product=" + product +
                ", loanStartDate=" + loanStartDate +
                ", expectedReturnDate=" + expectedReturnDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
