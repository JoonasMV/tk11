package application;

import dao.Dao;
import entity.BasicProfile;
import entity.Clinic;
import entity.Customer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Dao dao = new Dao();

        Clinic clinic = new Clinic("Helsinki");
        Customer customer = new Customer("John", "Doe");
        BasicProfile basicProfile = new BasicProfile(1990, 80, 180, customer);
        dao.save(clinic);
        dao.save(basicProfile);
        dao.addCustomerToClinic(clinic, customer);
    }
}
