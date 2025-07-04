package danielerusso;

import danielerusso.DAO.BookLoanDAO;
import danielerusso.DAO.EditorialProductDAO;
import danielerusso.DAO.UserDAO;
import danielerusso.entities.*;
import danielerusso.exceptions.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3progsett");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        EditorialProductDAO epd = new EditorialProductDAO(em);
        UserDAO ud = new UserDAO(em);
        BookLoanDAO bld = new BookLoanDAO(em);

        Book book1 = new Book(978145150, "Full Dark , No Stars", 2014, 458, "Stephen King", BookGenre.HORROR);
        Book book2 = new Book(928037542, "Oceano Mare", 1993, 293, "Alessandro Baricco", BookGenre.FICTION);
        Book book3 = new Book(978884613, "Lord of the Rings", 1954, 846, "J.R.R. Tolkien", BookGenre.FANTASY);

        Magazine magazine1 = new Magazine(978834874, "Di Più TV", 2021, 50, MagazinePeriodicity.WEEKLY);
        Magazine magazine2 = new Magazine(978741135, "GialloZafferano", 2005, 63, MagazinePeriodicity.SEMIANNUALY);
        Magazine magazine3 = new Magazine(875862819, "Quattro Ruote", 2014, 74, MagazinePeriodicity.MONTHLY);

        User user1 = new User("Mario", "Rossi", LocalDate.of(1994, 7, 19), 8748136);
        User user2 = new User("Giuseppe", "Verdi", LocalDate.of(2000, 1, 8), 5971684);
        User user3 = new User("John", "Doe", LocalDate.of(1987, 10, 29), 7784153);

       /* ud.saveUser(user1);
        ud.saveUser(user2);
        ud.saveUser(user3); */


        EditorialProduct book1FromDB = epd.findBookById(1);
        EditorialProduct book2FromDB = epd.findBookById(3);
        EditorialProduct magazine1FromDB = epd.findMagazineById(2);
        EditorialProduct magazine2FromDB = epd.findMagazineById(4);

        User user1FromDB = ud.findUserById(1);
        User user2FromDB = ud.findUserById(2);
        User user3FromDB = ud.findUserById(3);

        BookLoan loan1 = new BookLoan(LocalDate.now(), LocalDate.now().plusDays(15), user1FromDB, book1FromDB);
        BookLoan loan2 = new BookLoan(LocalDate.now().minusDays(4), LocalDate.now(), user2FromDB, book2FromDB);
        BookLoan loan3 = new BookLoan(LocalDate.now().minusDays(40), null, user3FromDB, magazine1FromDB);
        BookLoan loan4 = new BookLoan(LocalDate.now().minusDays(40), null, user3FromDB, magazine2FromDB);
        BookLoan loan5 = new BookLoan(LocalDate.now().minusDays(40), null, user1FromDB, magazine1FromDB);

       /* bld.save(loan1);
        bld.save(loan2);
        bld.save(loan3);
        bld.save(loan4);
        bld.save(loan5); */

        // ----------- Task 1 ------------

        /* epd.saveEditorialProduct(book1);
        epd.saveEditorialProduct(magazine1);
        epd.saveEditorialProduct(book2);
        epd.saveEditorialProduct(magazine2);
        epd.saveEditorialProduct(book3);
        epd.saveEditorialProduct(magazine3); */

        // ----------- Task 2 ------------

        System.out.println("--------------------- Delete by ISBN Code -----------------------");
        // Questo specifico libro può essere eliminato perchè non è in relazione con nessun BookLoan,
        // nel caso invece ci sia una relazione, non si può eliminare perchè da ERRORE.

        //epd.findEditProductByISBNAndDelete(978884613);

        // ----------- Task 3 ------------

        try {
            System.out.println("--------------------- Find By ISBN -----------------------");
            System.out.println(epd.findByISBN(97883487));
        } catch (ISBNNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // ----------- Task 4 ------------

        try {
            System.out.println("--------------------- Find By Year -----------------------");
            epd.findByYear(2014).forEach(System.out::println);
        } catch (YearNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // ----------- Task 5 ------------

        try {
            System.out.println("--------------------- Find By Author -----------------------");
            epd.findByAuthor("Alessandro Baricco").forEach(System.out::println);
        } catch (AuthorOrTitleNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // ----------- Task 6 ------------

        try {
            System.out.println("--------------------- Find By Title -----------------------");
            epd.findByTitle("NO").forEach(System.out::println);
        } catch (AuthorOrTitleNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // ----------- Task 7 ------------

        try {
            System.out.println("--------------------- Find By Card Number -----------------------");
            bld.findEPsByCardNo(7784153).forEach(System.out::println);
        } catch (CardNoNotFoundException e) {
            System.out.println(e.getMessage());
        }


        // ----------- Task 8 ------------
        try {
            System.out.println("--------------------- Find By Expired Loans -----------------------");
            bld.findExpiredAndNotReturnedYetLoan().forEach(System.out::println);
        } catch (ExpiredLoanNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }
}
