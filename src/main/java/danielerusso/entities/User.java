package danielerusso.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @OneToMany(mappedBy = "user")
    List<BookLoan> bookLoanList;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    private String name;
    private String surname;
    private LocalDate birthday;
    @Column(name = "card_number")
    private long cardNo;

    public User() {
    }

    public User(String name, String surname, LocalDate birthday, long cardNo) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.cardNo = cardNo;
    }

    public long getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public long getCardNo() {
        return cardNo;
    }

    public void setCardNo(long cardNo) {
        this.cardNo = cardNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", cardNo=" + cardNo +
                '}';
    }
}
