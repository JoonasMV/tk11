package entity;

import jakarta.persistence.Entity;

@Entity
public class ContractCustomer extends Customer {

    private int contractId;
    private java.sql.Date startDate;
    private java.sql.Date endDate;

    public ContractCustomer() {
    }

    public ContractCustomer(String firstName, String lastName, int contractId, java.sql.Date startDate, java.sql.Date endDate) {
        super(firstName, lastName);
        this.contractId = contractId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
