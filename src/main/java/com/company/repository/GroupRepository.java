package com.company.repository;

import com.company.entity.Group;
import com.company.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class GroupRepository {
    private static HibernateUtils hibernateUtils;

    public GroupRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<Group> getAllGroups() {
        Session session = null;

        try {
            session = hibernateUtils.openSession();
            Query<Group> groupQuery = session.createQuery("FROM Group ORDER BY id");
            return groupQuery.list();
        } finally {
            session.close();
        }
    }

    public void createdGroup(Group group) {
        Session session = null;

        try {
            session = hibernateUtils.openSession();
            session.save(group);
        } finally {
            session.close();
        }
    }
}
