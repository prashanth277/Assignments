package com.service;

import com.model.Intern;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("database1")
public class InternDatabaseImpl implements InternService{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Intern> getInterns() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Intern> interns = session.createQuery("from Intern", Intern.class).list();
        transaction.commit();
        session.close();
        return interns;
    }

    @Override
    public Intern createIntern(Intern intern) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(intern);
        transaction.commit();
        session.close();
        return intern;
    }

    @Override
    public Intern deleteIntern(Intern intern) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(intern);
        transaction.commit();
        session.close();
        return intern;
    }

    @Override
    public Intern updateIntern(Intern intern) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(intern);
        transaction.commit();
        session.close();
        return intern;
    }

}
