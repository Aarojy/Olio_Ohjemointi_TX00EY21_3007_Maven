package Task7_4.entity;

import jakarta.persistence.*;

@Entity
@Table(name="transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Currency currencyFrom;

    @ManyToOne
    private Currency currencyTo;

    @Column(name="amount")
    private Double amount;

    public Transaction(Currency currencyFrom, Currency currencyTo, Double amount) {
        super();
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.amount = amount;
    }

    public Transaction() {}
}
