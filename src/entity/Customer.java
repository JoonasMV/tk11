package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custId;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "customers")
    private List<Clinic> clinics;

    @OneToOne(mappedBy = "customer")
    private BasicProfile basicProfile;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
