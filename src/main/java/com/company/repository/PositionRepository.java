package com.company.repository;

import com.company.entity.Position;
import com.company.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PositionRepository {
    private HibernateUtils hibernateUtils;

    public PositionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }


    public List<Position> getAllPositions() {

        Session session = null;

        try {
            session = hibernateUtils.openSession();
            Query<Position> query = session.createQuery("FROM Position ");
            return query.list();
        } finally {
            session.close();
        }
    }

    public Position getPositionById(Integer id) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Position position = session.get(Position.class, id);
            return position;
        } finally {
            session.close();
        }
    }
}
