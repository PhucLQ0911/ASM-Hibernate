package com.company.repository;

import java.util.List;

import com.company.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.company.entity.GroupAccount;

public class GroupAccountRepository {

    private HibernateUtils hibernateUtils;

    public GroupAccountRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<GroupAccount> getAllGroupAccounts() {

        Session session = null;

        try {
            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<GroupAccount> query = session.createQuery("FROM GroupAccount");

            // return result
            return query.list();

        } finally {
            session.close();
        }
    }

    public void createGroupAccount(GroupAccount groupAccount) {

        Session session = null;

        try {
            // get session
            session = hibernateUtils.openSession();

            // create
            session.beginTransaction();
            session.save(groupAccount);
            session.getTransaction().commit();

        } finally {
            session.close();
        }
    }
}
