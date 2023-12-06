package application;

import dao.Dao;
import entity.BasicProfile;
import entity.Clinic;
import entity.ContractCustomer;
import entity.Customer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestApp {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Dao dao = new Dao();

        Clinic clinic = new Clinic("Helsinki");
        Customer customer = new Customer("John", "Doe");
        BasicProfile basicProfile = new BasicProfile(1990, 80, 180, customer);
        ContractCustomer contractCustomer = new ContractCustomer(
                "Mary",
                "Jane",
                123,
                new java.sql.Date(-2020),
                new java.sql.Date(31-12-2023)
        );
        dao.save(clinic);
        dao.save(basicProfile);
        dao.addCustomerToClinic(clinic, customer);
        dao.save(contractCustomer);
    }
}
