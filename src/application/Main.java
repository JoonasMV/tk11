package application;

import dao.Dao;
import entity.Account;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Dao dao = new Dao();
        Account account = new Account(123.45);
        System.out.println(account);
        dao.saveAccount(account);
        Account accountAfterSaving = dao.getAccount(1);
        System.out.println(accountAfterSaving);

        Account account2 = dao.saveAccount(new Account(100));
        Account account3 = dao.saveAccount(new Account(50.50));

        boolean success = dao.transfer(account3.getNumber(), account2.getNumber(), 30);
        System.out.println("Transfer success: " + success);
    }
}
