package danielerusso.DAO;

import danielerusso.entities.User;
import danielerusso.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UserDAO {
    private final EntityManager entityManager;

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveUser(User newUser) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newUser);
        transaction.commit();
        System.out.println("User " + newUser.getName() + " " + newUser.getSurname() + " saved successfully.");
    }

    public User findUserById(long id) {
        User found = entityManager.find(User.class, id);
        if (found == null) throw new NotFoundException(id, "User");
        return found;
    }
}
