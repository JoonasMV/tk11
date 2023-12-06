package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Date;

@Entity
public class BasicProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profileId;
    private int birthyear;
    private double weight;
    private double height;

    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;

    public BasicProfile() {
    }

    public BasicProfile(int birthyear, double weight, double height, Customer customer) {
        this.birthyear = birthyear;
        this.weight = weight;
        this.height = height;
        this.customer = customer;
    }
}
