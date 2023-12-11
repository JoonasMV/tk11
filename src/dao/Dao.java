package dao;

import entity.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Dao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("tk13");

    public void saveAccount(Account account) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(account);
        em.getTransaction().commit();
    }

    public Account getAccount(int number) {
        EntityManager em = emf.createEntityManager();

        return em.find(Account.class, number);
    }
}
