package entity;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class ContractCustomer extends Customer {

    private int contractId;
    private Date startDate;
    private Date endDate;

    public ContractCustomer() {
    }
}
