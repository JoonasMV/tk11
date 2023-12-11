package dao;

import entity.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.LockModeType;
import jakarta.persistence.Persistence;

public class Dao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("tk13");

    public Account saveAccount(Account account) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(account);
        em.getTransaction().commit();
        return account;
    }

    public Account getAccount(int number) {
        EntityManager em = emf.createEntityManager();

        return em.find(Account.class, number);
    }

    public boolean transfer(int sourceAccountNumber, int destinationAccountNumber, double amount) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        try {
            Account sourceAccount = em.find(Account.class, sourceAccountNumber, LockModeType.OPTIMISTIC);
            Account destinationAccount = em.find(Account.class, destinationAccountNumber, LockModeType.OPTIMISTIC);

            if (sourceAccount == null || destinationAccount == null) {
                return false;
            }

            if (sourceAccount.getBalance() < amount) {
                return false;
            }

            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);

            em.getTransaction().commit();
            return true;

        } catch (Error e) {
            em.getTransaction().rollback();
            return false;
        }
    }
}
