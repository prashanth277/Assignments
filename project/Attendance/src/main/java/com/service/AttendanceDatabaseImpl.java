package com.service;

import com.model.Attendance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service("database")
public class AttendanceDatabaseImpl implements AttendanceService {
    @Autowired
    private SessionFactory sessionFactory;

    public Transaction getTransaction(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        return transaction;
    }

    @Override
    public Attendance postAttendance(Attendance attendance) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(attendance);
        transaction.commit();
        session.close();
        return attendance;
    }

    @Override
    public List<Attendance> getAttendance() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Attendance> attendanceList = session.createQuery("from Attendance", Attendance.class).list();
        transaction.commit();
        session.close();
        return attendanceList;
    }



    @Override
    public List<Attendance> getTodayAttendance() {
        LocalDate d = LocalDate.now();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = (Query) session.createNativeQuery("SELECT internAttendance.id as customID, intern.id as internId, intern.name, internAttendance.present, internAttendance.reason\n" +
                "FROM intern\n" +
                "INNER JOIN internAttendance ON intern.id=internAttendance.intern_id and internAttendance.date=:date ");
        query.setParameter("date",java.sql.Date.valueOf(d));
        List<Attendance> attendanceList = query.list();
        transaction.commit();
        session.close();
        return attendanceList;
    }

    @Override
    public List<Attendance> getAbsentees() {
        LocalDate d = LocalDate.now();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = (Query) session.createNativeQuery("SELECT i.name as Names, ia.reason FROM internAttendance ia," +
                "intern i where i.id=ia.intern_id and ia.present=0 and ia.date=:date ");
        query.setParameter("date",java.sql.Date.valueOf(d));
        List<Attendance> attendanceList = query.list();
        transaction.commit();
        session.close();
        return attendanceList;
    }

    @Override
    public Object getNumberOfAbsentees() {
        LocalDate d = LocalDate.now();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query1 = (Query) session.createQuery("select count(present) from Attendance a where a.present = :name and a.date = :date");
        query1.setParameter("name",false);
        query1.setParameter("date",java.sql.Date.valueOf(d));
        Object n = (Object) query1.uniqueResult();
        System.out.println(n);
        transaction.commit();
        session.close();
        return n;
    }

    @Override
    public Object getNumberOfPresents() {
        LocalDate d = LocalDate.now();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query1 = (Query) session.createQuery("select count(present) from Attendance a where a.present = :name and a.date = :date");
        query1.setParameter("name",true);
        query1.setParameter("date",java.sql.Date.valueOf(d));
        Object present = (Object) query1.uniqueResult();
        transaction.commit();
        session.close();
        return present;
    }

    @Override
    public List<Attendance> getAbsentCountOfIntern() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = (Query) session.createNativeQuery("SELECT i.name as Names, COUNT(intern_id) absentCount FROM internAttendance,intern i where i.id=intern_id and internAttendance.present=0 GROUP BY intern_id;");
        List<Attendance> attendanceList = query.list();
        transaction.commit();
        session.close();
        return attendanceList;
    }

    @Override
    public Attendance updateInternAttendance(Attendance attendance) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(attendance);
        transaction.commit();
        session.close();
        return attendance;
    }

    @Override
    public List<Attendance> getAttendanceByDate(Date date) {
        System.out.println(date);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = (Query) session.createNativeQuery("SELECT internAttendance.id as customID, intern.id as internId, intern.name, internAttendance.present, internAttendance.reason\n" +
                "FROM intern\n" +
                "INNER JOIN internAttendance ON intern.id=internAttendance.intern_id and internAttendance.date=:date ");
        query.setParameter("date",date);
        List<Attendance> attendanceList = query.list();
        transaction.commit();
        session.close();
        return attendanceList;
    }
}

