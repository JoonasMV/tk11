package application;

import dao.Dao;
import entity.Account;
import org.checkerframework.checker.units.qual.A;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Dao dao = new Dao();
        Account account = new Account(123.45);
        dao.saveAccount(account);
        Account accountAfterSaving = dao.getAccount(1);
        System.out.println(accountAfterSaving);
    }
}
