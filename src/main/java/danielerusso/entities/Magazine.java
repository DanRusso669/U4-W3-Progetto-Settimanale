package danielerusso.entities;

public class Magazine extends EditorialProduct {
    private MagazinePeriodicity periodicity;

    public Magazine() {
    }

    ;

    public Magazine(long ISBNCode, String title, int year, int pagesNo, MagazinePeriodicity periodicity) {
        super(ISBNCode, title, year, pagesNo);
        this.periodicity = periodicity;
    }

    public MagazinePeriodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(MagazinePeriodicity periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "periodicity=" + periodicity +
                ", id=" + id +
                ", ISBNCode=" + ISBNCode +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", pagesNo=" + pagesNo +
                '}';
    }
}
