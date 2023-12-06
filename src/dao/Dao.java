package dao;

import entity.Clinic;
import entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Dao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevPU");

    public void init() {
        emf.createEntityManager();
    }

    public <T> void save(T t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
    }

    public void addCustomerToClinic(Clinic clinic, Customer customer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        clinic.addCustomer(customer);
        em.merge(clinic);
        em.getTransaction().commit();
        em.close();
    }
}
