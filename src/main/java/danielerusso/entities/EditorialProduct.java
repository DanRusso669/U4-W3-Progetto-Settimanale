package danielerusso.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "editorial_products")
@Inheritance(strategy = InheritanceType.JOINED)

@NamedQuery(name = "findByYear", query = "SElECT ep FROM EditorialProduct ep WHERE ep.year = :year")
@NamedQuery(name = "findByAuthor", query = "SElECT ep FROM EditorialProduct ep WHERE ep.author = :author")
@NamedQuery(name = "findByTitle", query = "SElECT ep FROM EditorialProduct ep WHERE LOWER(ep.title) LIKE LOWER(:title)")

public abstract class EditorialProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    @Column(name = "ISBN_code")
    protected long ISBNCode;
    protected String title;
    @Column(name = "year_of_publication")
    protected int year;
    @Column(name = "number_of_pages")
    protected int pagesNo;

    public EditorialProduct() {
    }

    ;

    public EditorialProduct(long ISBNCode, String title, int year, int pagesNo) {
        this.ISBNCode = ISBNCode;
        this.title = title;
        this.year = year;
        this.pagesNo = pagesNo;
    }

    ;

    public long getId() {
        return id;
    }

    public long getISBNCode() {
        return ISBNCode;
    }

    public void setISBNCode(long ISBNCode) {
        this.ISBNCode = ISBNCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPagesNo() {
        return pagesNo;
    }

    public void setPagesNo(int pagesNo) {
        this.pagesNo = pagesNo;
    }

    @Override
    public String toString() {
        return "EditorialProduct{" +
                "id=" + id +
                ", ISBNCode=" + ISBNCode +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", pagesNo=" + pagesNo +
                '}';
    }
}
