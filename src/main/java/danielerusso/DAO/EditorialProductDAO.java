package danielerusso.DAO;

import danielerusso.entities.Book;
import danielerusso.entities.EditorialProduct;
import danielerusso.entities.Magazine;
import danielerusso.exceptions.AuthorOrTitleNotFoundException;
import danielerusso.exceptions.ISBNNotFoundException;
import danielerusso.exceptions.NotFoundException;
import danielerusso.exceptions.YearNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EditorialProductDAO {
    private final EntityManager entityManager;

    public EditorialProductDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(EditorialProduct newProduct) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newProduct);
        transaction.commit();
        System.out.println("Editorial product " + newProduct.getTitle() + " saved successfully.");
    }

    public EditorialProduct findEPById(long id) {
        EditorialProduct found = entityManager.find(EditorialProduct.class, id);
        if (found == null) throw new NotFoundException(id, "Records");
        return found;
    }

    public Book findBookById(long id) {
        Book found = entityManager.find(Book.class, id);
        if (found == null) throw new NotFoundException(id, "Book");
        return found;
    }

    public Magazine findMagazineById(long id) {
        Magazine found = entityManager.find(Magazine.class, id);
        if (found == null) throw new NotFoundException(id, "Magazine");
        return found;
    }

    public void findEditProductByISBNAndDelete(long ISBN) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("DELETE FROM EditorialProduct ep WHERE ep.ISBNCode = :ISBN");
        query.setParameter("ISBN", ISBN);

        int deletedNo = query.executeUpdate();

        transaction.commit();
        System.out.println(deletedNo + " removed successfully.");
    }

    public EditorialProduct findByISBN(long ISBN) {
        TypedQuery<EditorialProduct> query = entityManager.createQuery("SELECT ep FROM EditorialProduct ep WHERE ep.ISBNCode = :ISBN", EditorialProduct.class);
        query.setParameter("ISBN", ISBN);
        EditorialProduct found = query.getSingleResultOrNull();
        if (found == null) throw new ISBNNotFoundException(ISBN);

        return found;
    }

    public List<EditorialProduct> findByYear(int year) {
        TypedQuery<EditorialProduct> query = entityManager.createNamedQuery("findByYear", EditorialProduct.class);
        query.setParameter("year", year);
        List<EditorialProduct> found = query.getResultList();
        if (found.isEmpty()) throw new YearNotFoundException(year);
        return found;
    }

    public List<EditorialProduct> findByAuthor(String author) {
        TypedQuery<EditorialProduct> query = entityManager.createNamedQuery("findByAuthor", EditorialProduct.class);
        query.setParameter("author", author);
        List<EditorialProduct> found = query.getResultList();
        if (found.isEmpty()) throw new AuthorOrTitleNotFoundException(author, "author");
        return found;
    }

    public List<EditorialProduct> findByTitle(String title) {
        TypedQuery<EditorialProduct> query = entityManager.createNamedQuery("findByTitle", EditorialProduct.class);
        query.setParameter("title", "%" + title + "%");
        List<EditorialProduct> found = query.getResultList();
        if (found.isEmpty()) throw new AuthorOrTitleNotFoundException(title, "title");
        return found;
    }

}
