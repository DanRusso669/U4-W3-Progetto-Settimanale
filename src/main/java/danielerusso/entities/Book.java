package danielerusso.entities;

public class Book extends EditorialProduct {
    private String author;
    private BookGenre genre;

    public Book() {
    }

    ;

    public Book(long ISBNCode, String title, int year, int pagesNo, String author, BookGenre genre) {
        super(ISBNCode, title, year, pagesNo);
        this.author = author;
        this.genre = genre;
    }

    ;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", genre=" + genre +
                ", id=" + id +
                ", ISBNCode=" + ISBNCode +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", pagesNo=" + pagesNo +
                '}';
    }
}
