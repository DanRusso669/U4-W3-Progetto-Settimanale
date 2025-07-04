Un prestito può essere collegato solo un utente. @ManyToOne
Un utente può avere più prestiti. @OneToMany

Un prestito può essere collegato solo a un libro. @OneToOne
Un libro può essere collegato solo a un prestito. @OneToOne

Ho scelto JOINED perchè, nonostante la classe padre EditorialProducts sia astratta, mi permette di collegarmi a ogni suo figlio e alla classe BookLoan.
Quindi posso creare query utilizzando lei.