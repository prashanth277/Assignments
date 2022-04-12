package com.service;

import com.model.Flight;
import com.model.Journey;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Collections;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.service.DataDB.*;

public class JourneyFlightImp implements  JourneyService{
    Connection con = null;
    private  List<Journey> journeys = new ArrayList<>();
    private List<Journey> Connections;


    @Override
    public List<Journey> getJourneyDetails() {
        try {
            con = getConnection();
            ResultSet rs = getResult();

            while (rs.next()) {
                Journey journey = new Journey();
                journey.setJourneyId(rs.getInt(1));
                journey.setStartPlace(rs.getString(2));
                journey.setDestination(rs.getString(3));
                journeys.add(journey);
            }

            con.close();
        }catch (Exception e){
            return null;
        }
        Collections.sort(journeys, new Comparator<Journey>() {
            @Override
            public int compare(Journey o1, Journey o2) {
                return 0;
            }
        });
        Collections.sort(journeys,(a,b)->a.getStartPlace().compareTo(b.getStartPlace()));

        return journeys;
    }

    @Override
    public List<Flight> getFlightDetails() {

        try{
            con= getConnection();
            ResultSet resultSet = getFlightResult();
            List<Flight> flights = new ArrayList<>();

            while (resultSet.next()){

                Flight flight = new Flight();
                flight.setFlightId(resultSet.getInt(1));
                flight.setFlightName(resultSet.getString(2));
                flights.add(flight);
            }
            con.close();
            return flights;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Journey update(Journey journey) {
        updateJourney(journey);

        return null;
    }

    @Override
    public Journey delete(Journey journey) {
        deleteJourney(journey);
        return null;
    }

    @Override
    public List<Journey> sortJourney() throws SQLException {
//         ResultSet rs = sortJourneyDetailsByStartName();
//        while (rs.next()) {
//            Journey journey = new Journey();
//            journey.setJourneyId(rs.getInt(1));
//            journey.setStartPlace(rs.getString(2));
//            journey.setDestination(rs.getString(3));
//            journeys.add(journey);
//
//        }
//
        journeys = getJourneyDetails();

        Collections.sort(journeys,(a,b)->a.getStartPlace().compareTo(b.getStartPlace()));

        System.out.println(journeys.toString());
        return journeys;
    }


    @Override
    public Journey insertDetail(Journey journey) throws SQLException {
        insertJourney(journey);
        return journey;
    }

}
