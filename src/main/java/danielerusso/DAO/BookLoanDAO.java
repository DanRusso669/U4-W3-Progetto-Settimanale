package danielerusso.DAO;

import danielerusso.entities.BookLoan;
import danielerusso.entities.EditorialProduct;
import danielerusso.exceptions.CardNoNotFoundException;
import danielerusso.exceptions.ExpiredLoanNotFoundException;
import danielerusso.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class BookLoanDAO {

    private final EntityManager entityManager;

    public BookLoanDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(BookLoan newLoan) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newLoan);
        transaction.commit();
        System.out.println("Book Loan with id " + newLoan.getLoan_id() + " saved successfully.");
    }

    public BookLoan findBookLoanById(long id) {
        BookLoan found = entityManager.find(BookLoan.class, id);
        if (found == null) throw new NotFoundException(id, "Book Loan");
        return found;
    }

    public List<EditorialProduct> findEPsByCardNo(long cardNo) {
        TypedQuery<EditorialProduct> query = entityManager.createQuery("SELECT bl.product FROM BookLoan bl WHERE bl.user.cardNo = :cardNo AND bl.returnDate IS NULL", EditorialProduct.class);
        query.setParameter("cardNo", cardNo);
        if (query.getResultList().isEmpty()) throw new CardNoNotFoundException(cardNo);

        return query.getResultList();
    }

    //  https://www.datacamp.com/doc/postgresql/current_date
    public List<BookLoan> findExpiredAndNotReturnedYetLoan() {
        TypedQuery<BookLoan> query = entityManager.createQuery("SELECT bl FROM BookLoan bl WHERE bl.expectedReturnDate < CURRENT_DATE AND bl.returnDate IS NULL", BookLoan.class);
        if (query.getResultList().isEmpty()) throw new ExpiredLoanNotFoundException();
        return query.getResultList();
    }

}
