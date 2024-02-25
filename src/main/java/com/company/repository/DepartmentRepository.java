package com.company.repository;

import com.company.entity.Department;
import com.company.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DepartmentRepository {
    private HibernateUtils hibernateUtils;

    public DepartmentRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Department> getAllDepartment() {
        Session session = null;

        try {
            session = hibernateUtils.openSession();
            Query<Department> departmentQuery = session.createQuery("FROM Department ORDER BY id");
            return departmentQuery.list();

        } finally {
            session.close();
        }
    }

    public Department getDepartmentById(Integer id) {
        Session session = null;

        try {
            session = hibernateUtils.openSession();
            Department department = session.get(Department.class, id);
            return department;
        } finally {
            session.close();
        }
    }

    public Department getDepartmentByName(String name) {
        Session session = null;

        try {
            session = hibernateUtils.openSession();

            Query<Department> departmentQuery = session.createQuery("FROM Department WHERE name= :nameParam");
            departmentQuery.setParameter("nameParam", name);

            Department department = departmentQuery.uniqueResult();
            return department;
        } finally {
            session.close();
        }
    }

    public void createDepartment(Department department) {
        Session session = null;

        try {
            session = hibernateUtils.openSession();

            session.save(department);
        } finally {
            session.close();
        }
    }

    public void updateDepartment(String newName, Integer id) {

        Session session = null;

        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Department department = session.get(Department.class, id);
            department.setName(newName);

            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public void deleteDepartmentById(Integer id) {
        Session session = null;

        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Department department = session.get(Department.class, id);

            session.delete(department);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public boolean isDepartmentExitsById(Integer id) {
        Department department = getDepartmentById(id);
        return department != null;
    }

    public boolean isDepartmentExitsByName(String name) {
        Department department = getDepartmentByName(name);
        return department != null;
    }
}

