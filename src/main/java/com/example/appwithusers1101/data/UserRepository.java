package com.example.appwithusers1101.data;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static SessionFactory factory;

    public UserRepository() {
        try {
            factory = new Configuration()
                    .configure()
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Book.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public User login(String email, String password) {
        var session = factory.openSession();

        try {
            String hql = "FROM User U WHERE U.email = :email and U.password = MD5(:pwd)";
            Query query = session.createQuery(hql);

            query.setParameter("email", email);
            query.setParameter("pwd", password);

            var results = query.list();

            if (results.size() > 0) {
                return (User) results.get(0);
            }
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return null;
    }

    public List<Book> getBooks() {
        var session = factory.openSession();

        try {
            return session.createQuery("FROM Book").list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return new ArrayList<>();
    }

}
