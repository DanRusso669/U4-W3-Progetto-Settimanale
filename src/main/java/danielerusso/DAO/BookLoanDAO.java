package danielerusso.DAO;

import danielerusso.entities.BookLoan;
import danielerusso.entities.EditorialProduct;
import danielerusso.exceptions.CardNoNotFoundException;
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
        TypedQuery<EditorialProduct> query = entityManager.createQuery("SELECT bl.product FROM BookLoan bl WHERE bl.user.cardNo = :cardNo", EditorialProduct.class);
        query.setParameter("cardNo", cardNo);
        List<EditorialProduct> found = query.getResultList();
        if (found.isEmpty()) throw new CardNoNotFoundException(cardNo);

        return found;
    }
}
