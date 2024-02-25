package com.company.repository;

import com.company.entity.Account;
import com.company.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AccountRepository {
    private HibernateUtils hibernateUtils;

    public AccountRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<Account> getAllAccounts() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Account> query = session.createQuery("FROM Account ORDER BY id");
            return query.list();
        } finally {
            session.close();
        }
    }

    public Account getAccountById(Integer id) {
        Session session = null;

        try {
            session = hibernateUtils.openSession();
            Account account = session.get(Account.class, id);
            return account;
        } finally {
            session.close();
        }


    }

    public void createAccount(Account account) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.save(account);
        } finally {
            session.close();
        }
    }
}
