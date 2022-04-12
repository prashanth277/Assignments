package com.service;

import com.model.Flight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("database")
public class DatabaseServiceImpl implements FlightService {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Flight> getFlights() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Flight> flightList = session.createQuery("from Flight", Flight.class).list();
        transaction.commit();
        session.close();
        return flightList;
    }

    @Override
    public Flight getFlightById(int flightId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Flight flight = session.get(Flight.class, flightId);
            transaction.commit();
            session.close();
            return flight;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String createFlight(Flight flight) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(flight);
            transaction.commit();
        } catch (Exception e) {
            return "unable to create object";
        }
        session.close();
        return "Object created";
    }

    @Override
    public String deleteFlight(Flight flight) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(flight);
        try {
            transaction.commit();
            session.close();
            return "deleted successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "can't delete!!";
        }
    }

    @Override
    public String  updateFlight(Flight flight) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(flight);
            transaction.commit();
            session.close();
            return "object updated";
        } catch (Exception e) {
            return "Unable to update";
        }
    }
}
