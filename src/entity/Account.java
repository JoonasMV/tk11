package entity;

import jakarta.persistence.*;

@Entity
@EntityListeners(Converter.class)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;
    private double balance;

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", balance=" + balance +
                '}';
    }
}
