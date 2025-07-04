package danielerusso.entities;

public abstract class EditorialProduct {
    protected long id;
    protected long ISBNCode;
    protected String title;
    protected int year;
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
