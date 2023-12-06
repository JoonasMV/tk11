package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clinicId;
    private String location;
    @ManyToMany
    private List<Customer> customers = new ArrayList<>();

    public Clinic() {
    }

    public Clinic(String location) {
        this.location = location;
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }
}
