package danielerusso.DAO;

import danielerusso.entities.EditorialProduct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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
}
