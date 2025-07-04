package danielerusso;

import danielerusso.DAO.EditorialProductDAO;
import danielerusso.entities.Book;
import danielerusso.entities.BookGenre;
import danielerusso.entities.Magazine;
import danielerusso.entities.MagazinePeriodicity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3progsett");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        EditorialProductDAO epd = new EditorialProductDAO(em);

        Book book1 = new Book(978145150, "Full Dark , No Stars", 2014, 458, "Stephen King", BookGenre.HORROR);
        Book book2 = new Book(928037542, "Oceano Mare", 1993, 293, "Alessandro Baricco", BookGenre.FICTION);
        Book book3 = new Book(978884613, "Lord of the Rings", 1954, 846, "J.R.R. Tolkien", BookGenre.FANTASY);

        Magazine magazine1 = new Magazine(978834874, "Di Più TV", 2021, 50, MagazinePeriodicity.WEEKLY);
        Magazine magazine2 = new Magazine(978741135, "GialloZafferano", 2005, 63, MagazinePeriodicity.SEMIANNUALY);
        Magazine magazine3 = new Magazine(875862819, "Quattro Ruote", 2011, 74, MagazinePeriodicity.MONTHLY);

        epd.save(book1);
        epd.save(magazine1);
        epd.save(book2);
        epd.save(magazine2);
        epd.save(book3);
        epd.save(magazine3);


        System.out.println("Hello World!");
    }
}
